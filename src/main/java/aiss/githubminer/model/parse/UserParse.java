package aiss.githubminer.model.parse;

import aiss.githubminer.model.Issue.Assignee;
import aiss.githubminer.model.User;
import aiss.githubminer.model.comment.Author;
import aiss.githubminer.service.UserService;

public class UserParse {

    private String id;
    private String username;
    private String name;
    private String avatar_url;
    private String web_url;

    public UserParse(String id, String username, String name, String avatar_url, String web_url) {
        this.id = id ;
        this.username = username ;
        this.name = name ;
        this.avatar_url = avatar_url ;
        this.web_url = web_url ;
    }

    public UserParse(User user){
        this.id = user.getId().toString();
        this.username = user.getUsername();
        this.name = user.getName();
        this.avatar_url = user.getAvatarUrl();
        this.web_url = user.getWeb_url();
    }

    public UserParse(Author author){ //author de comment
        this.id = author.getId().toString();
        this.username = author.getUsername();
        this.name = null;
        this.avatar_url = author.getAvatarUrl();
        this.web_url = author.getWeb_url();
    }

    public UserParse(aiss.githubminer.model.Issue.Author author){ //author de issue
        this.id = author.getId().toString();
        this.username = author.getUsername();
        this.name = null;
        this.avatar_url = author.getAvatarUrl();
        this.web_url = author.getWeb_url();
    }
    public UserParse(Assignee assignee){
        this.id = assignee.getId().toString();
        this.username = assignee.getUsername();
        this.name = null;
        this.avatar_url = assignee.getAvatarUrl();
        this.web_url = assignee.getWeb_url();
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

}
