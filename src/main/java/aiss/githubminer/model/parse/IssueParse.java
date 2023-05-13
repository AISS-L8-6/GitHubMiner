package aiss.githubminer.model.parse;

import aiss.githubminer.model.Issue.Issue;

import java.util.List;
import java.util.stream.Collectors;

public class IssueParse {
    private String id;
    private String ref_id;
    private String title;
    private String description;
    private String state;
    private String created_at;
    private String updated_at;
    private String closed_at;
    private List<String> labels;
    private Integer upvotes;
    private Integer downvotes;
    private List<CommentParse> comments;
    private UserParse author;
    private UserParse assignee;


    public IssueParse(Issue issue, UserParse author, UserParse assignee, List<CommentParse> comments, Integer upvotes, Integer downvotes){
        this.id = issue.getId();
        this.ref_id = issue.getRefId();
        this.title = issue.getTitle();
        this.description = issue.getDescription();
        this.state = issue.getState();
        this.created_at = issue.getCreated_at();
        this.updated_at = issue.getUpdatedAt();
        this.closed_at = issue.getClosed_At();
        this.labels = issue.getLabels().stream().map(x -> x.getId().toString() + x.getName().toString()).toList();
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.comments = comments;
        this.author = author;
        this.assignee = assignee;

    }

    public IssueParse(String id, String ref_id, String title, String description, String state, String created_at, String update_at, String closed_at, List<String> labels, Integer upvotes, Integer downvotes, List<CommentParse> comments, UserParse author, UserParse assignee) {
        this.id = id;
        this.ref_id = ref_id;
        this.title = title;
        this.description = description;
        this.state = state;
        this.created_at = created_at;
        this.updated_at = update_at;
        this.closed_at = closed_at;
        this.labels = labels;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.comments = comments;
        this.author = author;
        this.assignee = assignee;
    }

    public IssueParse(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRef_id() {
        return ref_id;
    }

    public void setRef_id(String ref_id) {
        this.ref_id = ref_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String update_at) {
        this.updated_at = update_at;
    }

    public String getClosed_at() {
        return closed_at;
    }

    public void setClosed_at(String closed_at) {
        this.closed_at = closed_at;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Integer upvotes) {
        this.upvotes = upvotes;
    }

    public Integer getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(Integer downvotes) {
        this.downvotes = downvotes;
    }

    public List<CommentParse> getComments() {
        return comments;
    }

    public void setComments(List<CommentParse> comments) {
        this.comments = comments;
    }

    public UserParse getAuthor() {
        return author;
    }

    public void setAuthor(UserParse author) {
        this.author = author;
    }

    public UserParse getAssignee() {
        return assignee;
    }

    public void setAssignee(UserParse assignee) {
        this.assignee = assignee;
    }
}
