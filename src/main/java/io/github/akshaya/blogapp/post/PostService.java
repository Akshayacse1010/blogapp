package io.github.akshaya.blogapp.post;

import io.github.akshaya.blogapp.author.Author;
import io.github.akshaya.blogapp.author.AuthorRepository; // FIX: Import AuthorRepository
import io.github.akshaya.blogapp.mapper.ModelMapper;
import io.github.akshaya.blogapp.post.dto.PostDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public PostDTO createPost(PostDTO postDTO, Long authorId) {
        // FIX: Use findById for safety and a clear error message
        Post post = ModelMapper.toPost(postDTO);
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + authorId));

        post.setAuthor(author);
        return ModelMapper.toPostDTO(postRepository.save(post));
    }

    public List<PostDTO> getPostsByAuthor(Long id)
    {
       List<Post> postList = postRepository.findAllByAuthorId(id);
       List<PostDTO> postDTOList = new ArrayList<>();
       for(Post post : postList)
       {
           PostDTO postDTO = ModelMapper.toPostDTO(post);
           postDTOList.add(postDTO);
       }
        return postDTOList;
    }

    public PostDTO updatePostByAuthorID(Long authorID, Long postID, PostDTO requestPostDTO)
    {
        Post post = postRepository.findByIdAndAuthorId(postID, authorID).orElseThrow(() -> new RuntimeException("Post not found with id"));
        post.setContent(requestPostDTO.getContent());
        post.setTitle(requestPostDTO.getTitle());
        return ModelMapper.toPostDTO(postRepository.save(post));
    }

    public void deletePostById(Long authorId, Long postId)
    {
        Post post = postRepository.findByIdAndAuthorId(postId ,authorId ).orElseThrow(() -> new RuntimeException("Post not found"));
        postRepository.delete(post);
    }
}