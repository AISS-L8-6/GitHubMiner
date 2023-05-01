package aiss.githubminer.model.Issue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

@JsonIgnoreProperties(ignoreUnknown = true)
public class Label {

        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
}
