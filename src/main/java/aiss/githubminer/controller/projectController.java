package aiss.githubminer.controller;

import aiss.githubminer.model.Issue.Issue;
import aiss.githubminer.model.Project;
import aiss.githubminer.model.comment.Comment;
import aiss.githubminer.model.commit.Commit;
import aiss.githubminer.model.parse.*;
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



        @GetMapping("/apipath/project/{owner}/{repoName}")
        public ProjectParse getByOwnerAndRepo(@PathVariable String owner,@PathVariable String repoName, @RequestParam(name = "sinceCommits", required = false) Integer sinceCommits, @RequestParam(name = "sinceIssues", required = false) Integer sinceIssues, @RequestParam(name = "maxPages", required = false) Integer maxPages) {
            ProjectParse result;
            List<IssueParse> issueParses = new ArrayList<>();
            List<CommitParse> commitParses = new ArrayList<>();
            Project project = projectService.getProjectByUserRepo(owner, repoName);
            List<Issue> issueList = issueService.findAllIssueByOwnerAndRepository(owner, repoName, sinceIssues, maxPages);
            List<Commit> commitList = commitService.findAllCommit(owner, repoName, sinceCommits, maxPages);
            for (int i = 0; i < issueList.size(); i++) {
                    UserParse author = new UserParse(issueList.get(i).getAuthor());
                    UserParse assignee = new UserParse(issueList.get(i).getAssignee());
                    List<Comment> commentList = commentService.findAllComment(owner, repoName, issueList.get(i).getId());
                    List<CommentParse> commentParses = new ArrayList<>();
                    for (int j = 0; j < commentList.size(); j++) {
                            UserParse commentAuthor = new UserParse(commentList.get(j).getAuthor());
                            CommentParse commentParse = new CommentParse(commentList.get(j));
                            commentParses.add(commentParse);
                    }

                    IssueParse issueParse = new IssueParse(issueList.get(i), commentParses);
                    issueParses.add(issueParse);
            }
            for (int i = 0; i < commitList.size(); i++) {
                CommitParse commitParse = new CommitParse(commitList.get(i).getAuthor(),commitList.get(i),commitList.get(i).getCommitter());
                commitParses.add(commitParse);
            }
            result =  new ProjectParse(project,commitParses,issueParses);
            return result;
        }
/*

        @PostMapping("/apipath/project/{owner}/{repoName}")
        public ProjectParse postByOwnerRepo(@PathVariable String owner,@PathVariable String repoName, @RequestParam(name = "sinceCommits") Integer sinceCommits, @RequestParam(name = "sinceIssues") Integer sinceIssues, @RequestParam(name = "maxPages") Integer maxPages) {
                ProjectParse result;
                List<IssueParse> issueParses = new ArrayList<>();
                List<CommitParse> commitParses = new ArrayList<>();
                Project project = projectService.getProjectByUserRepo(owner, repoName);
                List<Issue> issueList = issueService.findAllIssueByOwnerAndRepository(owner, repoName);
                List<Commit> commitList = commitService.findAllCommit(owner, repoName,sinceCommits,maxPages);
                for (int i = 0; i < issueList.size(); i++) {
                        UserParse author = new UserParse(issueList.get(i).getAuthor());
                        UserParse assignee = new UserParse(issueList.get(i).getAssignee());
                        List<Comment> commentList = commentService.findAllComment(owner, repoName, issueList.get(i).getId());
                        List<CommentParse> commentParses = new ArrayList<>();
                        for (int j = 0; j < commentList.size(); j++) {
                                UserParse commentAuthor = new UserParse(commentList.get(j).getAuthor());
                                CommentParse commentParse = new CommentParse(commentList.get(j));
                                commentParses.add(commentParse);
                        }

                        IssueParse issueParse = new IssueParse(issueList.get(i), commentParses);
                        issueParses.add(issueParse);
                }
                for (int i = 0; i < commitList.size(); i++) {
                        CommitParse commitParse = new CommitParse(commitList.get(i).getAuthor(),commitList.get(i),commitList.get(i).getCommitter());
                        commitParses.add(commitParse);
                }
                result =  new ProjectParse(project,commitParses,issueParses);

            return restTemplate.postForObject("http://localhost:8080/gitminer/projects", result, ProjectParse.class);
        }

*/

    }
