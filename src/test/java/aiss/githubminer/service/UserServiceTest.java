package aiss.githubminer.service;


import aiss.githubminer.model.User;
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
    @DisplayName("Get user by username")
    void getUserByUsername() {
        String username = "octocat";
        User user = service.getUserByUsername(username);
        assertTrue(!user.equals(""), "user is empty");
        System.out.println(user);
    }

}
