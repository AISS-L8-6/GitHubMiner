package aiss.githubminer.service;
import java.util.List;

import aiss.githubminer.model.Project;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
public class ProjectServiceTest {

    @Autowired
    ProjectService service;

    /*
    @Test
    @DisplayName("Get all projects")
    void findAllProjects() {
        List<Project> projects = service.findAllProjects();
        assertTrue(!projects.isEmpty(), "list of projects is empty");
        for(Project p:projects){
            System.out.println(p);
        }
    }
  */
    @Test
    @DisplayName("Get project by user and repo")
    void getProjectByUserAndRepo() {
        String owner = "octocat";
        String repo = "Hello-World";
        Project project = service.getProjectByUserRepo(owner, repo);
        assertTrue(!project.equals(null), "project is empty");
        System.out.println(project);
    }
}

