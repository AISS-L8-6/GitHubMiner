package aiss.githubminer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import aiss.githubminer.model.Author;
@Service
public class UserService {
    @Autowired
    RestTemplate restTemplate;

    String token = "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";
    public List<Author> getUsersByOwnerRepo(String owner, String repo) throws HttpClientErrorException {

        HttpHeaders headers = new HttpHeaders();
        if(token != "") {
            headers.set("Authorization", "Bearer " + token);
        }
        HttpEntity<Author> request = new HttpEntity<>(null, headers);
        ResponseEntity<Author[]> response = restTemplate
                .exchange("https://api.github.com/repos/" + owner + "/" + repo + "/collaborators", HttpMethod.GET, request, Author[].class);

        List<Author> result = new ArrayList<>();
        result.addAll(Arrays.asList(response.getBody()));

        return result;
    }
}
