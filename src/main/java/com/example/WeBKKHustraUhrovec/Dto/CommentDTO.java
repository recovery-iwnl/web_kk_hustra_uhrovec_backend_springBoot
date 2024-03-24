package com.example.WeBKKHustraUhrovec.Dto;

import com.example.WeBKKHustraUhrovec.Enum.UserRole;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class CommentDTO {

    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String text;
    @Getter
    @Setter
    private String subject;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private UserRole role;
    @Getter
    @Setter
    private int likes;
    @Getter
    @Setter
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime date;

    public CommentDTO(Long id, String text, String subject, String username, UserRole role, int likes, LocalDateTime date) {
        this.id = id;
        this.text = text;
        this.subject = subject;
        this.username = username;
        this.role = role;
        this.likes = likes;
        this.date = date;
    }

    public CommentDTO() {
    }
}
