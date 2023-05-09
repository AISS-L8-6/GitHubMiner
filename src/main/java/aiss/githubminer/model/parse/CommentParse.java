package aiss.githubminer.model.parse;



import aiss.githubminer.model.Comment;

public class CommentParse {
    //TODO: necesita un User
        private String id;
        private String body;

        private String created_at;
        private String updated_at;

        // TODO: añadir autor del comentario

        public CommentParse(String id, String body   , String created_at, String updated_at) {
            this.id = id;
            this.body = body;
            this.created_at = created_at;
            this.updated_at = updated_at;
        }


    public CommentParse(Comment comment) {
            this.id = comment.getId();
            this.body = comment.getBody();
            this.created_at = comment.getCreatedAt();
            this.updated_at = comment.getUpdatedAt();


        }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
