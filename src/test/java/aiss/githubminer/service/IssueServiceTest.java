package aiss.githubminer.service;

import aiss.githubminer.model.Issue.Issue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IssueServiceTest {

    @Autowired
    IssueService service;

    @Test
    @DisplayName("Find one issue")
    void getAllIssueByOwnerAndRepository() {
        String owner = "ytdl-org";
        String repository = "youtube-dl";
        Integer sinceCommits = 10;
        Integer maxPages = 2;
        List<Issue> issues = service.findAllIssueByOwnerAndRepository(owner, repository, sinceCommits, maxPages);
        assertTrue(!issues.equals(null), "issue is empty");
        for(int i = 0; i < issues.size(); i++){
            System.out.println(issues.get(i));
        }
    }

    @Test
    @DisplayName("Upvotes")
    void getUpvotes(){
        String owner = "octocat";
        String repository = "Hello-World";
        String isuue_ref = "1";
        Integer result = service.findUpvotesByIssue(owner, repository, isuue_ref);
        assertTrue(!result.equals(null), "upvotes is empty");
        System.out.println(result);
    }

    @Test
    @DisplayName("Downvotes")
    void getDownvotes(){
        String owner = "octocat";
        String repository = "Hello-World";
        String issue_ref = "1347";
        Integer result = service.findUpvotesByIssue(owner, repository, issue_ref);
        assertTrue(!result.equals(null), "upvotes is empty");
        System.out.println(result);
    }

}