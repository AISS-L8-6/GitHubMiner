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
/*
    @Test
    @DisplayName("Get all issue by owner and repository")
    void findAllIssueByOwnerAndRepository() {
        String owner = "ytdl-org";
        String repository = "youtube-dl";
        List<Issue> issues = service.findAllIssueByOwnerAndRepository(owner, repository);
        assertTrue(!issues.isEmpty(), "list of issue is empty");
        for(Issue i:issues){
            System.out.println(i);
        }
    }
*/

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
/*
    @Test
    void getIssueByProjectAndState() {
        String owner = "ytdl-org";
        String repository = "youtube-dl";
        String state = "closed";
        List<Issue> issues = service.getIssueByProjectAndState(owner, repository, state);
        assertTrue(!issues.isEmpty(), "list of issue is empty");
        for (Issue i : issues) {
            System.out.println(i);
        }
    }
     */
}