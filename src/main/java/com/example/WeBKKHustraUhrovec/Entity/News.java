package com.example.WeBKKHustraUhrovec.Entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="news")
public class News {
    @Id
    @Column(name = "news_id", length = 40)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int newsID;

    @Column(name = "text")
    @NotEmpty(message = "Text must not be empty")
    @Size(max = 255, message = "Comment must have less than 255 characters")
    private String text;

    @Column(name = "subject")
    @NotEmpty(message = "Subject must not be empty")
    @Size(max = 255, message = "Subject must have less than 255 characters")
    private String subject;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;

    @Column(name = "date")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime date;
}
