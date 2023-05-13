package aiss.githubminer.service;

import aiss.githubminer.model.commit.Commit;
import aiss.githubminer.utils.Utils;
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

@Service
public class CommitService {
    @Autowired
    RestTemplate restTemplate;

    @Value("${token}")
    private String token;

    private final LocalDateTime sinceCommits = LocalDateTime.now().minusDays(2);
    private final String maxPages = "2";

    public List<Commit> findAllCommit(String owner,String repo, Integer sinceCommits, Integer maxPages) throws HttpClientErrorException {

        String url = "https://api.github.com/repos/" + owner + "/" + repo + "/commits?since=" + LocalDateTime.now().minusDays(sinceCommits) + "&?page=" + 1;

        HttpHeaders headers = new HttpHeaders();
        if(token != "") {
            headers.set("Authorization", "Bearer " + token);
        }
        HttpEntity<Commit[]> request = new HttpEntity<>(null, headers);
        ResponseEntity<Commit[]> response = restTemplate
                .exchange(url, HttpMethod.GET, request, Commit[].class);

        List<Commit> result = new ArrayList<>();
        result.addAll(Arrays.asList(response.getBody()));

        String nextPageUrl = Utils.getNextPageUrl(response.getHeaders());
        for(int i = 0; i <= maxPages && nextPageUrl != null; i++){
            response = restTemplate.exchange(nextPageUrl, HttpMethod.GET, request, Commit[].class);
            result.addAll(Arrays.asList(response.getBody()));
            nextPageUrl = Utils.getNextPageUrl(response.getHeaders());
        }

        return result;
    }
}
