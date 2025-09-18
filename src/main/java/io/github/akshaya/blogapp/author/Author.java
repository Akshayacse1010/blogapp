package io.github.akshaya.blogapp.author;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.akshaya.blogapp.post.Post;
import jakarta.persistence.*; // Import more from here
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;

    // This tells JPA: "The other side of this relationship is
    // managed by the 'author' field in the Post class."

    /*The rule of thumb is to place @JsonIgnore on the @OneToMany (the "many" side) of the relationship. You've already done this correctly.*/
    @JsonIgnore
    @OneToMany(mappedBy = "author" , cascade = CascadeType.ALL)
    private List<Post> posts;

    public Author() {
    }

    // Getters and Setters...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<Post> getPosts() { return posts; }
    public void setPosts(List<Post> posts) { this.posts = posts; }
}