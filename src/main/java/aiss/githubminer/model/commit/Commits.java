
package aiss.githubminer.model.commit;

import java.util.List;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//FALTA TITLE
//URL SE PUEDE OBTENER EN COMMITS Y EN COMMIT
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "url",
    "node_id",
    "commit"
})

@JsonIgnoreProperties(ignoreUnknown = true)
public class Commits {

    @JsonProperty("url")
    private String web_url;

    @JsonProperty("node_id")
    private String id;

    @JsonProperty("commit")
    private Commit commit;


    @JsonProperty("url")
    public String getUrl() {
        return web_url;
    }

    @JsonProperty("url")
    public void setUrl(String web_url) {
        this.web_url = web_url;
    }

    @JsonProperty("node_id")
    public String getNodeId() {
        return id;
    }

    @JsonProperty("node_id")
    public void setNodeId(String id) {
        this.id = id;
    }

    @JsonProperty("commit")
    public Commit getCommit() {
        return commit;
    }

    @JsonProperty("commit")
    public void setCommit(Commit commit) {
        this.commit = commit;
    }

}
