package aiss.githubminer.service;

import aiss.githubminer.model.commit.Commit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommitService {
    @Autowired
    RestTemplate restTemplate;

    // @Value("${githubminer.token}")
    private final String token = "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";

    private final LocalDateTime sinceCommits = LocalDateTime.now().minusDays(2);
    private final String maxPages = "2";

    public List<Commit> findAllCommit(String owner,String repo, Integer sinceCommits, Integer per_page) throws HttpClientErrorException {

        String url = "https://api.github.com/repos/"+owner+"/"+repo+"/commits";

        if(sinceCommits.equals(null)) {
            url.concat("?since=" + this.sinceCommits + "&");
        }else {
            url.concat("?since=" + LocalDateTime.now().minusDays(sinceCommits) + "&");
        }
        if(per_page.equals(null)) {
            url.concat("?per_page=" + this.maxPages);
        }else {
            url.concat("?per_page=" + per_page);
        }

        HttpHeaders headers = new HttpHeaders();
        if(token != "") {
            headers.set("Authorization", "Bearer " + token);
        }
        HttpEntity<Commit[]> request = new HttpEntity<>(null, headers);
        ResponseEntity<Commit[]> response = restTemplate
                .exchange(url, HttpMethod.GET, request, Commit[].class);

        List<Commit> result = new ArrayList<>();
        result.addAll(Arrays.asList(response.getBody()));

        return result;
    }
}
