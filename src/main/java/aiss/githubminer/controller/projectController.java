package aiss.githubminer.controller;

import aiss.githubminer.model.Comment;
import aiss.githubminer.model.Issue.Issue;
import aiss.githubminer.model.Project;
import aiss.githubminer.model.commit.Commit;
import aiss.githubminer.model.parse.CommentParse;
import aiss.githubminer.model.parse.IssueParse;
import aiss.githubminer.model.parse.ProjectParse;
import aiss.githubminer.model.parse.UserParse;
import aiss.githubminer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@RestController
public class projectController {

        @Autowired
        RestTemplate restTemplate;

        @Autowired
        CommentService commentService;

        @Autowired
        CommitService commitService;

        @Autowired
        IssueService issueService;

        @Autowired
        ProjectService projectService;

        @Autowired
        UserService userService;

        @GetMapping("/gitHubMiner/project/{owner}/{repoName}")
        public ProjectParse getByOwnerRepo(@PathVariable String owner, String repository, @RequestParam(name = "sinceCommits") Integer sinceCommits, @RequestParam(name = "sinceIssues") Integer sinceIssues, @RequestParam(name = "maxPages") Integer maxPages) {
            ProjectParse result;
            List<IssueParse> issueParses = new ArrayList<>();

            Project project = projectService.getProjectByUserRepo(owner,repository);
            List<Issue> issueList = issueService.findAllIssueByOwnerAndRepository(owner, repository);
            List<Commit> commitList = commitService.findAllCommit(owner,repository,sinceCommits,maxPages);
            /*for (int i = 0; i < issueList.size(); i++) {
                UserParse author = new UserParse(issueList.get(i).);
                UserParse assignee = new UserParse(issueList.get(i).getAssignee());
                List<Comment> commentList = commentService.findAllComment(id, issueList.get(i).getId());
                List<CommentParse> commentParses = new ArrayList<>();
                for (int j = 0; j < commentList.size(); j++) {
                    UserParse commentAuthor = new UserParse(commentList.get(j).getAuthor());
                    CommentParse commentParse = new CommentParse(commentList.get(j), commentAuthor);
                    commentParses.add(commentParse);
                }
                IssueParse issueParse = new IssueParse(issueList.get(i), author, assignee, commentParses);
                issueParses.add(issueParse);
            }*/

            for (int i = 0; i < issueList.size(); i++) {
                issueParses.add(new IssueParse(issueList.get(i),))
            }
            result =  new ProjectParse(project,commitList,issueParses);
                    //ProjectParse(project.getId(), project.getName(), project.getWebUrl(), commitList, issueParses);
            return result;
        }


        @PostMapping("/gitHubMiner/project/{owner}/{repoName}")
        public ProjectParse postByOwnerRepo(@PathVariable String owner, String repository, @RequestParam(name = "sinceCommits") Integer sinceCommits, @RequestParam(name = "sinceIssues") Integer sinceIssues, @RequestParam(name = "maxPages") Integer maxPages) {
            ProjectParse result;
            List<IssueParse> issueParses = new ArrayList<>();

            Project project = projectService.getProjectById(id);
            List<Issue> issueList = issueService.findAllIssue(id, sinceIssues, maxPages);
            List<Commit> commitList = commitService.findAllCommit(id, sinceCommits, maxPages);

            for(int i = 0; i < issueList.size(); i++){
                UserParse author = new UserParse(issueList.get(i).getAuthor());
                UserParse assignee = new UserParse(issueList.get(i).getAssignee());
                List<Comment> commentList = commentService.findAllComment(id, issueList.get(i).getId());
                List<CommentParse> commentParses = new ArrayList<>();
                for(int j = 0; j < commentList.size(); j++){
                    UserParse commentAuthor = new UserParse(commentList.get(j).getAuthor());
                    CommentParse commentParse = new CommentParse(commentList.get(j), commentAuthor);
                    commentParses.add(commentParse);
                }
                IssueParse issueParse = new IssueParse(issueList.get(i), author, assignee, commentParses);
                issueParses.add(issueParse);
            }

            result = new ProjectParse(project.getId(), project.getName(), project.getWebUrl(), commitList, issueParses);

            return restTemplate.postForObject("http://localhost:8080/gitminer/projects", result, ProjectParse.class);
        }



    }
