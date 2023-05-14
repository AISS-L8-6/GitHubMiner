package aiss.githubminer.controller;

import aiss.githubminer.model.Issue.Issue;
import aiss.githubminer.model.Project;
import aiss.githubminer.model.comment.Comment;
import aiss.githubminer.model.commit.Commit;
import aiss.githubminer.model.parse.*;
import aiss.githubminer.service.*;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
@Tag(name = "Github Project", description = "Github project management API")
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


    @Operation(
            summary = "Retrieve a project",
            description = "Find one project by specifying its owner and repository name",
            tags = {"get"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Success", content = { @Content(schema = @Schema(implementation = projectController.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Not Found", content = { @Content(schema = @Schema())})
    })
        @GetMapping("/apipath/project/{owner}/{repoName}")
        public ProjectParse getByOwnerAndRepo(@Parameter(description = "Owner of the project to be sent")@PathVariable String owner,
                                              @Parameter(description = "Repository of the project to be sent") @PathVariable String repoName,
                                              @RequestParam(name = "sinceCommits", required = false, defaultValue = "2") Integer sinceCommits,
                                              @RequestParam(name = "sinceIssues", required = false, defaultValue ="20") Integer sinceIssues,
                                              @RequestParam(name = "maxPages", required = false, defaultValue ="1") Integer maxPages) {
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
                   String[] titleAndMessage = commitList.get(i).getCommit().getMessage().split("\n\n");     //podria separarse con \n pero en la practica nos indicaron de hacerlo con \n\n
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


    @Operation(
            summary = "Insert a project",
            description = "Add a new project whose data is built from the GitHub API",
            tags = {"post"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Success", content = { @Content(schema = @Schema(implementation = projectController.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = { @Content(schema = @Schema())})
    })
        @ResponseStatus(HttpStatus.CREATED)
        @PostMapping("/apipath/project/{owner}/{repoName}")
        public ProjectParse postByOwnerAndRepo(@Parameter(description = "Owner of the project to be sent") @PathVariable String owner,
                                               @Parameter(description = "Repository of the project to be sent") @PathVariable String repoName,
                                                @RequestParam(name = "sinceCommits", required = false, defaultValue = "2") Integer sinceCommits, @RequestParam(name = "sinceIssues", required = false, defaultValue = "20") Integer sinceIssues, @RequestParam(name = "maxPages", required = false, defaultValue = "1") Integer maxPages) {
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
