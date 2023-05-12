package aiss.githubminer.service;

import aiss.githubminer.model.comment.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceTest {

    @Autowired
    CommentService service;
    @Test
    @DisplayName("Get all comments")
    void findAllComment() {
        // octocat Hello-World
        String owner = "octocat";
        String repo = "Hello-World";
        String issueNumber = "7";
        List<Comment> comments = service.findAllComment(owner,repo,issueNumber);
        assertTrue(!comments.isEmpty(), "list of comment is empty");
        for(Comment c:comments){
            System.out.println(c);
        }
    }
}