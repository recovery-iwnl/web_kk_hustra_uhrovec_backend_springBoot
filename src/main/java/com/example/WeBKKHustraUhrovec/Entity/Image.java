package com.example.WeBKKHustraUhrovec.Entity;


import jakarta.persistence.*;

import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 40)
    private Long id;

    @Column(name = "url", length = 255)
    @NotEmpty(message = "Url must not be empty")
    private String url;

    @Column(name = "name", length = 255)
    @NotEmpty(message = "Name must not be empty")
    private String name;

    public Image(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
