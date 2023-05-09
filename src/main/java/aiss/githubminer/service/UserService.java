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


    //TODO: Añadir: https://docs.github.com/en/rest/users/users?apiVersion=2022-11-28#get-a-user para poder obtener todos los datos que falten
}
