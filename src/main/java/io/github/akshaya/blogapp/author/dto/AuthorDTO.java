package io.github.akshaya.blogapp.author.dto;

import io.github.akshaya.blogapp.post.Post;

public class AuthorDTO {
    private Long id;
    private String name;
    private String email;

    // No-argument constructor
    public AuthorDTO() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}