package aiss.githubminer.service;

import aiss.githubminer.model.Issue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IssueServiceTest {

    @Autowired
    IssueService service;

    @Test
    @DisplayName("Find all issue")
    void findAllIssue(){
        List<Issue> issues = service.findAllIssue();
        assertTrue(!issues.isEmpty(), "list of issue is empty");
        for(Issue i:issues){
            System.out.println(i);
        }
    }

    @Test
    @DisplayName("Get all issue by owner and repository")
    void findAllIssueByOwnerAndRepository() {
        String owner = "";
        String repository = "";
        List<Issue> issues = service.findAllIssueByOwnerAndRepository(owner, repository);
        assertTrue(!issues.isEmpty(), "list of issue is empty");
        for(Issue i:issues){
            System.out.println(i);
        }
    }

    @Test
    @DisplayName("Find one issue")
    void getIssueById() {
        String owner = "";
        String repository = "";
        String issueId = "41";
        Issue issue = service.getIssueById(owner, repository, issueId);
        assertTrue(!issue.equals(null), "issue is empty");
        System.out.println(issue);
    }

    @Test
    void getIssueByProjectAndState() {
        String owner = "";
        String repository = "";
        String state = "closed";
        List<Issue> issues = service.getIssueByProjectAndState(owner, repository, state);
        assertTrue(!issues.isEmpty(), "list of issue is empty");
        for (Issue i : issues) {
            System.out.println(i);
        }
    }
}