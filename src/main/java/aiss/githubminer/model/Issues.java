package aiss.githubminer.model;

import java.util.List;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)

@JsonIgnoreProperties(ignoreUnknown = true)
public class Issues {

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
    @JsonProperty("labels")
    private List<String> labels;
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

    @JsonProperty("node_id")
    public String getNodeId() {
        return ref_id;
    }
    @JsonProperty("node_id")
    public void setNodeId(String ref_id) {
        this.ref_id = ref_id;
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

    @JsonProperty("body")
    public String getBody() {
        return description;
    }

    @JsonProperty("body")
    public void setBody(String description) {
        this.description = description;
    }

    @JsonProperty("labels")
    public List<String> getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(List<String> labels) {
        this.labels = labels;
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

}