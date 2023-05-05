package aiss.githubminer.service;

import  aiss.githubminer.model.commit.Commit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommitServiceTest {

    @Autowired
    CommitService service;

    @Test
    @DisplayName("find all commits (no param)")
    void findAllCommit() {

        String owner = "octocat";
        String repo = "Hello-World";
        Integer sinceCommits = 2;
        Integer maxPages     = 2;
        List<Commit> commits = service.findAllCommit(owner, repo, sinceCommits, maxPages);
        assertTrue(!commits.isEmpty(), "list of commits is empty");
        for(Commit c:commits){
            System.out.println(c);
        }
    }
}