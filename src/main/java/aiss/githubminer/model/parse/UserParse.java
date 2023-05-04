package aiss.githubminer.model.parse;

import aiss.githubminer.model.Comment;

import java.util.List;

public class UserParse {
    private String id;
    private String username;
    private String name;
    private String avatar_url;
    private String web_url;
    private List<IssueParse> issuesAsign;
    private List<IssueParse> issuesAuthor;
    private List<Comment> comments;

    public UserParse(String id, String username, String name, String avatar_url, String web_url, List<IssueParse> issuesAsign, List<IssueParse> issuesAuthor, List<Comment> comments) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.avatar_url = avatar_url;
        this.web_url = web_url;
        this.issuesAsign = issuesAsign;
        this.issuesAuthor = issuesAuthor;
        this.comments = comments;
    }



}
