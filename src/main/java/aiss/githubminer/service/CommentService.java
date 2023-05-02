package aiss.githubminer.service;

import aiss.githubminer.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    RestTemplate restTemplate;

    // @Value("${githubminer.token}")
    private final String token = "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";

    public List<Comment> findAllComment(String owner, String repo, String issueNumber) throws HttpClientErrorException {

        HttpHeaders headers = new HttpHeaders();
        if(token != "") {
            headers.set("Authorization", "Bearer " + token);
        }
        HttpEntity<Comment[]> request = new HttpEntity<>(null, headers);
        ResponseEntity<Comment[]> response = restTemplate
                .exchange("https://api.github.com/repos/" + owner + "/" + repo + "/issues/" + issueNumber + "/comments", HttpMethod.GET, request, Comment[].class);

        List<Comment> result = new ArrayList<>();
        result.addAll(Arrays.asList(response.getBody()));

        return result;
    }


    public Comment getCommentById(String owner, String repo, String commentId) throws HttpClientErrorException{

        HttpHeaders headers = new HttpHeaders();
        if(token != "") {
            headers.set("Authorization", "Bearer " + token);
        }
        HttpEntity<Comment> request = new HttpEntity<>(null, headers);
        ResponseEntity<Comment> response = restTemplate
                .exchange("https://api.github.com/repos/" + owner + "/" + repo + "/issues/comments/" + commentId, HttpMethod.GET, request, Comment.class);
        return response.getBody();
    }
}