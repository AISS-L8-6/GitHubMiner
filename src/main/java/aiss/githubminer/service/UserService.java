package aiss.githubminer.service;


import aiss.githubminer.GitHubMinerApplication;
import aiss.githubminer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

@Service
public class UserService {
    @Autowired
    RestTemplate restTemplate;

    @Value("${token}")
    private String token;

    public User getUserByUsername(String username) throws HttpClientErrorException{
        HttpHeaders headers = new HttpHeaders();
        if(token != "") {
            headers.set("Authorization", "Bearer " + token);
        }
        HttpEntity<User> request = new HttpEntity<>(null, headers);
        ResponseEntity<User> response = restTemplate
                .exchange("https://api.github.com/users/" + username, HttpMethod.GET, request, User.class);
        return response.getBody();
    }

    public String getNameFromUserByUsername(String username) throws HttpClientErrorException{
        HttpHeaders headers = new HttpHeaders();
        if(token != "") {
            headers.set("Authorization", "Bearer " + token);
        }
        HttpEntity<User> request = new HttpEntity<>(null, headers);
        ResponseEntity<User> response = restTemplate
                .exchange("https://api.github.com/users/" + username, HttpMethod.GET, request, User.class);
        return response.getBody().getName();
    }

}
