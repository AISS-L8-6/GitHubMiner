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

        @JsonProperty("id")
        public String getId() {
                return id;
        }
        @JsonProperty("id")
        public void setId(String id) {
                this.id = id;
        }

        @JsonProperty("name")
        public String getName() {
                return name;
        }
        @JsonProperty("name")
        public void setName(String name) {
                this.name = name;
        }
}
