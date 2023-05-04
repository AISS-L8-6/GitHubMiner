package aiss.githubminer.model.parse;

import aiss.githubminer.model.Issue.Issue;
import aiss.githubminer.model.Issue.Label;

import java.util.List;
import java.util.stream.Collectors;

public class IssueParse {
    private String id;
    private String ref_id;
    private String title;
    private String description;
    private String state;
    private String created_at;
    private String update_at;
    private String closed_at;
    private List<String> labels;
    private Integer upvotes;
    private Integer downvotes;

    public IssueParse(Issue issue){
        this.id = issue.getId();
        this.ref_id = issue.getRefId();
        this.title = issue.getTitle();
        this.description = issue.getDescription();
        this.state = issue.getState();
        this.created_at = issue.getCreatedAt();
        this.update_at = issue.getUpdatedAt();
        this.closed_at = issue.getClosedAt();
        this.labels = issue.getLabels().stream().map(x -> x.toString()).collect(Collectors.toList());
        this.upvotes = null;
        this.downvotes = null;
    }

    public IssueParse(String id, String ref_id, String title, String description, String state, String created_at, String update_at, String closed_at, List<String> labels, Integer upvotes, Integer downvotes) {
        this.id = id;
        this.ref_id = ref_id;
        this.title = title;
        this.description = description;
        this.state = state;
        this.created_at = created_at;
        this.update_at = update_at;
        this.closed_at = closed_at;
        this.labels = labels;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
    }
}
