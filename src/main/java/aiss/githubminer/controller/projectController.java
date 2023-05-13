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
        public ProjectParse getByOwnerAndRepo(@PathVariable String owner,@PathVariable String repoName, @RequestParam(name = "sinceCommits", required = false, defaultValue = "2") Integer sinceCommits, @RequestParam(name = "sinceIssues", required = false, defaultValue ="20") Integer sinceIssues, @RequestParam(name = "maxPages", required = false, defaultValue ="2") Integer maxPages) {
            ProjectParse result;
            List<IssueParse> issueParses = new ArrayList<>();
            List<CommitParse> commitParses = new ArrayList<>();

            Project project = projectService.getProjectByUserRepo(owner, repoName);
            List<Issue> issueList = issueService.findAllIssueByOwnerAndRepository(owner, repoName, sinceIssues, maxPages);
            List<Commit> commitList = commitService.findAllCommit(owner, repoName, sinceCommits, maxPages);
            for (int i = 0; i < issueList.size(); i++) {
                String authorIssueUsername = issueList.get(i).getAuthor().getUsername();
                Integer upvotes = issueService.findUpvotesByIssue(owner, repoName, issueList.get(i).getNumber());
                Integer downvotes = issueService.findDownvotesByIssue(owner, repoName, issueList.get(i).getNumber());
                UserParse assignee = null;
                if (issueList.get(i).getAssignee() != null) {
                    String assigneeIssueUsername = issueList.get(i).getAssignee().getUsername();
                    assignee = new UserParse(userService.getUserByUsername(assigneeIssueUsername));
                }
                UserParse author = new UserParse(userService.getUserByUsername(authorIssueUsername));
                List<Comment> commentList = commentService.findAllComment(owner, repoName, issueList.get(i).getNumber());
                List<CommentParse> commentParses = new ArrayList<>();
                for (int j = 0; j < commentList.size(); j++) {
                    String authorComment = commentList.get(j).getAuthor().getUsername();
                    UserParse commentAuthor = new UserParse(userService.getUserByUsername(authorComment));
                    CommentParse commentParse = new CommentParse(commentList.get(j),commentAuthor);
                    commentParses.add(commentParse);
                }

                IssueParse issueParse = new IssueParse(issueList.get(i), author, assignee, commentParses, upvotes, downvotes);
                issueParses.add(issueParse);
            }
            for (int i = 0; i < commitList.size(); i++) {
                CommitParse commitParse = null;
               if(commitList.get(i).getCommit().getMessage() != null){
                   String[] titleAndMessage = commitList.get(i).getCommit().getMessage().split("/n/n");
                   if (titleAndMessage.length == 1){
                       commitParse = new CommitParse(commitList.get(i).getCommit().getAuthor(),commitList.get(i),commitList.get(i).getCommit().getCommitter(),titleAndMessage[0],null);
                   }else {
                       commitParse = new CommitParse(commitList.get(i).getCommit().getAuthor(), commitList.get(i), commitList.get(i).getCommit().getCommitter(), titleAndMessage[0], titleAndMessage[1]);
                   }
               }else {
                   commitParse = new CommitParse(commitList.get(i).getCommit().getAuthor(), commitList.get(i), commitList.get(i).getCommit().getCommitter(),null,null);
               }
               commitParses.add(commitParse);
            }
            result =  new ProjectParse(project,commitParses,issueParses);
            return result;
        }

        @PostMapping("/apipath/project/{owner}/{repoName}")
        public ProjectParse postByOwnerAndRepo(@PathVariable String owner,@PathVariable String repoName, @RequestParam(name = "sinceCommits", required = false, defaultValue = "2") Integer sinceCommits, @RequestParam(name = "sinceIssues", required = false, defaultValue = "20") Integer sinceIssues, @RequestParam(name = "maxPages", required = false, defaultValue = "2") Integer maxPages) {
            ProjectParse result;
            List<IssueParse> issueParses = new ArrayList<>();
            List<CommitParse> commitParses = new ArrayList<>();

            Project project = projectService.getProjectByUserRepo(owner, repoName);
            List<Issue> issueList = issueService.findAllIssueByOwnerAndRepository(owner, repoName, sinceIssues, maxPages);
            List<Commit> commitList = commitService.findAllCommit(owner, repoName, sinceCommits, maxPages);
            for (int i = 0; i < issueList.size(); i++) {
                String authorIssueUsername = issueList.get(i).getAuthor().getUsername();
                Integer upvotes = issueService.findUpvotesByIssue(owner, repoName, issueList.get(i).getNumber());
                Integer downvotes = issueService.findDownvotesByIssue(owner, repoName, issueList.get(i).getNumber());
                UserParse assignee = null;
                if (issueList.get(i).getAssignee() != null) {
                    String assigneeIssueUsername = issueList.get(i).getAssignee().getUsername();
                    assignee = new UserParse(userService.getUserByUsername(assigneeIssueUsername));
                }
                UserParse author = new UserParse(userService.getUserByUsername(authorIssueUsername));
                List<Comment> commentList = commentService.findAllComment(owner, repoName, issueList.get(i).getNumber());
                List<CommentParse> commentParses = new ArrayList<>();
                for (int j = 0; j < commentList.size(); j++) {
                    String authorComment = commentList.get(j).getAuthor().getUsername();
                    UserParse commentAuthor = new UserParse(userService.getUserByUsername(authorComment));
                    CommentParse commentParse = new CommentParse(commentList.get(j),commentAuthor);
                    commentParses.add(commentParse);
                }

                IssueParse issueParse = new IssueParse(issueList.get(i), author, assignee, commentParses, upvotes, downvotes);
                issueParses.add(issueParse);
            }
            for (int i = 0; i < commitList.size(); i++) {
                CommitParse commitParse = null;
                if(commitList.get(i).getCommit().getMessage() != null){
                    String[] titleAndMessage = commitList.get(i).getCommit().getMessage().split("/n/n");
                    if (titleAndMessage.length == 1){
                        commitParse = new CommitParse(commitList.get(i).getCommit().getAuthor(),commitList.get(i),commitList.get(i).getCommit().getCommitter(),titleAndMessage[0],null);
                    }else {
                        commitParse = new CommitParse(commitList.get(i).getCommit().getAuthor(), commitList.get(i), commitList.get(i).getCommit().getCommitter(), titleAndMessage[0], titleAndMessage[1]);
                    }
                }else {
                    commitParse = new CommitParse(commitList.get(i).getCommit().getAuthor(), commitList.get(i), commitList.get(i).getCommit().getCommitter(),null,null);
                }
                commitParses.add(commitParse);
            }
            result =  new ProjectParse(project,commitParses,issueParses);
            return restTemplate.postForObject("http://localhost:8080/gitminer/projects", result, ProjectParse.class);
        }

    }
