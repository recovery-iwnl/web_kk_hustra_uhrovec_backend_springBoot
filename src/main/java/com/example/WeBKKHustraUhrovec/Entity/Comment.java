package com.example.WeBKKHustraUhrovec.Entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name="comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "text")
    @NotEmpty(message = "Text must not be empty")
    @Size(max = 255, message = "Comment must have less than 255 characters")
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "likes", length = 255)
    @PositiveOrZero(message = "Likes must be greater than or equal to 0")
    private int likes;

    @Column(name = "date")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime date;

    public Comment(String text, User user, int likes, LocalDateTime date) {
        this.text = text;
        this.user = user;
        this.likes = likes;
        this.date = date;
    }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
