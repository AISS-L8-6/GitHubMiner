package aiss.githubminer.service;


import aiss.githubminer.model.Author;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService service;
    @Test
    @DisplayName("Get user by project owner + repo")
    void getUsersByOwnerRepo() {
        String owner = "ytdl-org";
        String repo = "youtube-dl";
        List<Author> users = service.getUsersByOwnerRepo(owner,repo);
        assertTrue(!users.isEmpty(), "list of users is empty");
        for(Author p:users){
            System.out.println(p);
        }
    }
}
