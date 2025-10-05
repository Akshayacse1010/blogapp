package io.github.akshaya.blogapp.post.dto;

import io.github.akshaya.blogapp.author.dto.AuthorDTO;

public class PostDTO {
    private Long id;
    private String title;
    private String content;
    private AuthorDTO author;

    // No-argument constructor
    public PostDTO() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
}