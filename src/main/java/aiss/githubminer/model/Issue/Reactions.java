
package aiss.githubminer.model.Issue;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

@JsonIgnoreProperties(ignoreUnknown = true)
public class Reactions {

    @JsonProperty("id")
    private Integer id;

}
