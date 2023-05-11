package aiss.githubminer.service;

import aiss.githubminer.model.Issue.Issue;
import aiss.githubminer.model.Issue.Reactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IssueService {

    @Autowired
    RestTemplate restTemplate;
    @Value("${token}")
    private String token;

    private final Integer sinceCommits = 2;
    private final Integer maxPages = 2;


    public List<Issue> findAllIssueByOwnerAndRepository(String owner, String repository, Integer sinceCommits, Integer maxPages) throws HttpClientErrorException{
        String url = "https://api.github.com/repos/" + owner + "/" + repository + "/issues";

        HttpHeaders headers = new HttpHeaders();
        if(token != "") {
            headers.set("Authorization", "Bearer " + token);
        }

        if(sinceCommits.equals(null)) {
            url.concat("?since=" + this.sinceCommits + "&");
        }else {
            url.concat("?since=" + LocalDateTime.now().minusDays(sinceCommits) + "&");
        }
        if(maxPages.equals(null)) {
            url.concat("?maxPages=" + this.maxPages);
        }else {
            url.concat("?maxPages=" + maxPages);
        }

        HttpEntity<Issue[]> request = new HttpEntity<>(null, headers);
        ResponseEntity<Issue[]> response = restTemplate
                .exchange(url, HttpMethod.GET, request, Issue[].class);

        List<Issue> result = new ArrayList<>();
        result.addAll(Arrays.asList(response.getBody()));

        return result;
    }

    public Integer findUpvotesByIssue(String owner, String repo, String issueNumber){
        HttpHeaders headers = new HttpHeaders();
        if(token != "") {
            headers.set("Authorization", "Bearer " + token);
        }

        HttpEntity<Reactions[]> request = new HttpEntity<>(null, headers);
        ResponseEntity<Reactions[]> response = restTemplate
                .exchange("/repos/" + owner + "/" + repo + "/issues/" + issueNumber + "/reactions?content=+1", HttpMethod.GET, request, Reactions[].class);
        List<Reactions> result = new ArrayList<>();
        return result.size();
    }

    public Integer findDownvotesByIssue(String owner, String repo, String issueNumber){
        HttpHeaders headers = new HttpHeaders();
        if(token != "") {
            headers.set("Authorization", "Bearer " + token);
        }

        HttpEntity<Reactions[]> request = new HttpEntity<>(null, headers);
        ResponseEntity<Reactions[]> response = restTemplate
                .exchange("/repos/" + owner + "/" + repo + "/issues/" + issueNumber + "/reactions?content=-1", HttpMethod.GET, request, Reactions[].class);
        List<Reactions> result = new ArrayList<>();
        return result.size();
    }

}
