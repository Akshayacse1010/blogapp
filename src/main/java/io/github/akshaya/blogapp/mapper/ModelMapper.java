package io.github.akshaya.blogapp.mapper;

import io.github.akshaya.blogapp.author.Author;
import io.github.akshaya.blogapp.author.dto.AuthorDTO;
import io.github.akshaya.blogapp.post.Post;
import io.github.akshaya.blogapp.post.dto.PostDTO;

public class ModelMapper
{

    public static AuthorDTO toAuthorDTO(Author author)
    {
        // Create a new, empty DTO object
        AuthorDTO authorDTO = new AuthorDTO();

        // Manually copy the data from the entity to the DTO
        authorDTO.setId(author.getId());
        authorDTO.setName(author.getName());
        authorDTO.setEmail(author.getEmail());

        // Return the completed DTO
        return authorDTO;
    }

    public static PostDTO toPostDTO(Post post)
    {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setContent(post.getContent());
        AuthorDTO authorDTO = toAuthorDTO(post.getAuthor());
        postDTO.setAuthor(authorDTO);
        return postDTO;
    }

    public static Author toAuthor(AuthorDTO authorDTO)
    {
        Author author = new Author();
        author.setName(authorDTO.getName());
        author.setEmail(authorDTO.getEmail());
        author.setId(authorDTO.getId());
        return author;
    }

    public static Post toPost(PostDTO postDTO)
    {
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        if(postDTO.getAuthor() != null) post.setAuthor(toAuthor(postDTO.getAuthor()));
        post.setContent(postDTO.getContent());
        post.setId(postDTO.getId());
        return post;
    }
}