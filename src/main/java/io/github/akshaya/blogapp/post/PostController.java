package io.github.akshaya.blogapp.post;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/authors/{id}/posts")
    public Post createPost(@PathVariable Long id, @RequestBody Post post)
    {
        return postService.createPost(post , id);
    }
    @GetMapping("/authors/{id}/posts")
    public List<Post> getAllPostByAuthorID(@PathVariable Long id)
    {
        return postService.getPostsByAuthor(id);
    }

}
