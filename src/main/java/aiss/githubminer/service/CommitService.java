package aiss.githubminer.service;

import aiss.githubminer.model.commit.Commit;
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

    public List<Commit> findAllCommit(String owner,String repo, Integer sinceCommits, Integer per_page) throws HttpClientErrorException {

        String url = "https://api.github.com/repos/" + owner + "/" + repo + "/commits?since=" + LocalDateTime.now().minusDays(sinceCommits) + "&?per_page=" + per_page;

        /* String nextPageURL= Util.getNextPageURL(response.getHeaders());
        int page=2;
        while (nextPageURL != null && page <= maxPages){
            logger.debug("Retrieving commits form page"+ page+":"+nextPageURL);
            response = getCommits(nextPageURL);
            pageCommits=Arrays.stream(response.getBody()).toList();
            logger.debug(pageCommits.size()+"commits retrieved.");
            commits.addAll(pageCommits);
            nextPageURL= Util.getNextPaggeUrl(response.getHeaders());
            page++;
        }
        */

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
