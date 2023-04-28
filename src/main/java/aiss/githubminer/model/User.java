package aiss.githubminer.model;

import javax.annotation.Generated;

import aiss.githubminer.model.commit.Author;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)

@JsonIgnoreProperties(ignoreUnknown = true)

public class User {

    @JsonProperty("login")
    private String username;
    @JsonProperty("id")
    private String id;
    @JsonProperty("avatarUrl")
    private String avatar_url;
    @JsonProperty("url")
    private String web_url;
    @JsonProperty("name")
    private String name;


    @JsonProperty("login")
    public String getUsername() {
        return username;
    }

    @JsonProperty("login")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("avatarUrl")
    public String getAvatarUrl() {
        return avatar_url;
    }

    @JsonProperty("avatarUrl")
    public void setAvatarUrl(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    @JsonProperty("url")
    public String getUrl() {
        return web_url;
    }

    @JsonProperty("url")
    public void setUrl(String web_url) {
        this.web_url = web_url;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Author.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("username");
        sb.append('=');
        sb.append(((this.username == null)?"<null>":this.username));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("avatar_url");
        sb.append('=');
        sb.append(((this.avatar_url == null)?"<null>":this.avatar_url));
        sb.append(',');
        sb.append("web_url");
        sb.append('=');
        sb.append(((this.web_url == null)?"<null>":this.web_url));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}