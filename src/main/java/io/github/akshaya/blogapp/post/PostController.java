package io.github.akshaya.blogapp.post;

import io.github.akshaya.blogapp.post.dto.PostDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/authors/{id}/posts")
    public PostDTO createPost(@PathVariable Long id, @RequestBody PostDTO postDTO)
    {
        return postService.createPost(postDTO , id);
    }
    @GetMapping("/authors/{id}/posts")
    public List<PostDTO> getAllPostByAuthorID(@PathVariable Long id)
    {
        return postService.getPostsByAuthor(id);
    }
    @PutMapping("/authors/{authorId}/posts/{postId}")
    public PostDTO updatePostByAuthorID(@PathVariable Long authorId, @PathVariable Long postId, @RequestBody PostDTO postDTO)
    {
        return postService.updatePostByAuthorID(authorId, postId, postDTO);
    }
    @DeleteMapping("/authors/{authorId}/posts/{postId}")
    public void DeletePostByID(@PathVariable Long authorId, @PathVariable Long postId)
    {
        postService.deletePostById(authorId, postId);
    }
}
