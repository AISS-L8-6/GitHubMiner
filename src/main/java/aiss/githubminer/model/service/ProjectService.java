package aiss.githubminer.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProjectService {
    @Autowired
    RestTemplate restTemplate;

    // @Value("${githubminer.baseuri}")
    private String url=  "https://github.com/api/v4/projects";

    // @Value("${githubminer.token}")
    private String token = "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";

    public List<Project> findAllProjects() throws HttpClientErrorException {

        HttpHeaders headers = new HttpHeaders();
        if(token != "") {
            headers.set("Authorization", "Bearer " + token);
        }
        HttpEntity<Project[]> request = new HttpEntity<>(null, headers);
        ResponseEntity<Project[]> response = restTemplate
                .exchange(url, HttpMethod.GET, request, Project[].class);

        List<Project> result = new ArrayList<>();
        result.addAll(Arrays.asList(response.getBody()));

        return result;
    }

    public Project getProjectById(String id) throws HttpClientErrorException{

        HttpHeaders headers = new HttpHeaders();
        if(token != "") {
            headers.set("Authorization", "Bearer " + token);
        }
        HttpEntity<Project> request = new HttpEntity<>(null, headers);
        ResponseEntity<Project> response = restTemplate
                .exchange(url+"/"+id, HttpMethod.GET, request, Project.class);
        return response.getBody();
    }
}