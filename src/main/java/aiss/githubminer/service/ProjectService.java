package aiss.githubminer.service;

import java.util.List;

import aiss.githubminer.model.Project;
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

@Service
public class ProjectService {
    @Autowired
    RestTemplate restTemplate;

    // @Value("${githubminer.baseuri}")
    private String url=  "https://api.github.com/repos";

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
    public Project getProjectByUserRepo(String owner,String repository) throws HttpClientErrorException{

        HttpHeaders headers = new HttpHeaders();
        if(token != "") {
            headers.set("Authorization", "Bearer " + token);
        }
        HttpEntity<Project> request = new HttpEntity<>(null, headers);
        ResponseEntity<Project> response = restTemplate
                .exchange(url+"/"+owner+"/"+repository, HttpMethod.GET, request, Project.class);
        return response.getBody();
    }
}