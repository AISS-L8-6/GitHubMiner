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
    private String nodeId;
    @JsonProperty("state")
    private String state;
    @JsonProperty("title")
    private String title;
    @JsonProperty("body")
    private String description;
    @JsonProperty("user")
    private Author author;
    @JsonProperty("labels")
    private List<Label> labels;
    @JsonProperty("assignee")
    private Assignee assignee;
    @JsonProperty("closed_at")
    private String closed_at;
    @JsonProperty("created_at")
    private String created_at;
    @JsonProperty("updated_at")
    private String updated_at;
    @JsonProperty("number")
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("nodeId")
    public String getRefId() {
        return nodeId;
    }

    @JsonProperty("nodeId")
    public void setRefId(String nodeId) {
        this.nodeId = nodeId;
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

    @JsonProperty("closed_at")
    public String getClosed_At() {
        return closed_at;
    }

    @JsonProperty("closed_at")
    public void setClosed_at(String closed_at) {
        this.closed_at = closed_at;
    }

    @JsonProperty("created_at")
    public String getCreated_at() {
        return created_at;
    }

    @JsonProperty("created_at")
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @JsonProperty("updatedAt")
    public String getUpdatedAt() {
        return updated_at;
    }

    @JsonProperty("updatedAt")
    public void setUpdatedAt(String updatedAt) {
        this.updated_at = updatedAt;
    }

    @JsonProperty("assignee")
    public Assignee getAssignee() {
        return assignee;
    }

    @JsonProperty("assignee")
    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
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
        sb.append(((this.nodeId == null)?"<null>":this.nodeId));
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