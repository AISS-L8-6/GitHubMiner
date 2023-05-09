package aiss.githubminer.model.Issue;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

@JsonIgnoreProperties(ignoreUnknown = true)
public class Issue {

    @JsonProperty("id")
    private String id;
    @JsonProperty("nodeId")
    private String ref_id;
    @JsonProperty("state")
    private String state;
    @JsonProperty("title")
    private String title;
    @JsonProperty("body")
    private String description;
    @JsonProperty("user")
    private Author author;
    @JsonProperty("reactions")
    private Reactions reactions;
    @JsonProperty("labels")
    private List<Label> labels;

    @JsonProperty("assignee")
    private Assignee assignee;
    @JsonProperty("closedAt")
    private String closed_at;
    @JsonProperty("createdAt")
    private String created_at;
    @JsonProperty("updatedAt")
    private String updated_at;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("refId")
    public String getRefId() {
        return ref_id;
    }

    @JsonProperty("refId")
    public void setRefId(String refId) {
        this.ref_id = refId;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("user")
    public Author getAuthor() {
        return author;
    }
    @JsonProperty("user")
    public void setAuthor(Author author) {
        this.author = author;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("labels")
    public List<Label> getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    @JsonProperty("reactions")
    public Reactions getReactions() {
        return reactions;
    }

    @JsonProperty("reactions")
    public void setReactions(Reactions reactions) {
        this.reactions = reactions;
    }

    @JsonProperty("closed_at")
    public String getClosedAt() {
        return closed_at;
    }

    @JsonProperty("closed_at")
    public void setClosedAt(String closed_at) {
        this.closed_at = closed_at;
    }

    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return created_at;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(String created_at) {
        this.created_at = created_at;
    }

    @JsonProperty("updatedAt")
    public String getUpdatedAt() {
        return updated_at;
    }

    @JsonProperty("updatedAt")
    public void setUpdatedAt(String updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Issue.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("nodeId");
        sb.append('=');
        sb.append(((this.ref_id == null)?"<null>":this.ref_id));
        sb.append(',');
        sb.append("state");
        sb.append('=');
        sb.append(((this.state == null)?"<null>":this.state));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("body");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("user");
        sb.append('=');
        sb.append(((this.author == null)?"<null>":this.author));
        sb.append(',');
        sb.append("reactions");
        sb.append('=');
        sb.append(((this.reactions == null)?"<null>":this.reactions));
        sb.append("labels");
        sb.append('=');
        sb.append(((this.labels == null)?"<null>":this.labels));
        sb.append(',');
        sb.append("closedAt");
        sb.append('=');
        sb.append(((this.closed_at == null)?"<null>":this.closed_at));
        sb.append(',');
        sb.append("createdAt");
        sb.append('=');
        sb.append(((this.created_at == null)?"<null>":this.created_at));
        sb.append(',');
        sb.append("updatedAt");
        sb.append('=');
        sb.append(((this.updated_at == null)?"<null>":this.updated_at));
        sb.append(',');

        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }
}