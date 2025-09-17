package io.github.akshaya.blogapp.post;

import io.github.akshaya.blogapp.author.Author;
import io.github.akshaya.blogapp.author.AuthorRepository; // FIX: Import AuthorRepository
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final AuthorRepository authorRepository; // FIX: Inject AuthorRepository, not AuthorService

    public PostService(PostRepository postRepository, AuthorRepository authorRepository) {
        this.postRepository = postRepository;
        this.authorRepository = authorRepository;
    }

    public Post createPost(Post post, Long authorId) {
        // FIX: Use findById for safety and a clear error message
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + authorId));

        post.setAuthor(author);
        return postRepository.save(post);
    }

    public List<Post> getPostsByAuthor(Long id)
    {
       return postRepository.findAllByAuthorId(id);
    }

    public Post updatePostByAuthorID(Long authorID, Long postID, Post requestPost)
    {
        Post post = postRepository.findByIdAndAuthorId(postID, authorID).orElseThrow(() -> new RuntimeException("Post not found with id"));
        post.setContent(requestPost.getContent());
        post.setTitle(requestPost.getTitle());
        return postRepository.save(post);
    }
}