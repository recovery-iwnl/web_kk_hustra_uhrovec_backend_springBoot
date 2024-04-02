package com.example.WeBKKHustraUhrovec.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="comment_liked")
public class CommentLiked {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;


    public CommentLiked(User user, Comment comment) {
        this.user = user;
        this.comment = comment;
    }

    public CommentLiked() {
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

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
