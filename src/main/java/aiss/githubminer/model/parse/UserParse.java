package aiss.githubminer.model.parse;

import aiss.githubminer.model.Comment;

import java.util.List;

public class UserParse {

    private String id;
    private String username;
    private String name;
    private String avatar_url;
    private String web_url;
    private List<IssueParse> issuesAsigns;
    private List<IssueParse> issuesAuthor;
    private List<Comment> comments;

    public UserParse(String id, String username, String name, String avatar_url, String web_url, List<IssueParse> issuesAsigns , List<IssueParse> issuesAuthor, List<Comment> comments) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.avatar_url = avatar_url;
        this.web_url = web_url;
        this.issuesAsigns = issuesAsigns;
        this.issuesAuthor = issuesAuthor;
        this.comments = comments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public List<IssueParse> getIssuesAsigns() {
        return issuesAsigns;
    }

    public void setIssuesAsigns(List<IssueParse> issuesAsigns) {
        this.issuesAsigns = issuesAsigns;
    }

    public List<IssueParse> getIssuesAuthor() {
        return issuesAuthor;
    }

    public void setIssuesAuthor(List<IssueParse> issuesAuthor) {
        this.issuesAuthor = issuesAuthor;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
