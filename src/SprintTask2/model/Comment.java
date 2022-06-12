package SprintTask2.model;

import java.sql.Timestamp;

public class Comment {
    Long id;
    User user;
    News news;
    String comment;
    Timestamp post_date;
    boolean verified;

    public Comment() {

    }

    public Comment(Long id, User user, News news, String comment, Timestamp post_date, boolean verified) {
        this.id = id;
        this.user = user;
        this.news = news;
        this.comment = comment;
        this.post_date = post_date;
        this.verified = verified;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getPost_date() {
        return post_date;
    }

    public void setPost_date(Timestamp post_date) {
        this.post_date = post_date;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}