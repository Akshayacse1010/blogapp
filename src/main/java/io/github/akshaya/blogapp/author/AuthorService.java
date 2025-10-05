package io.github.akshaya.blogapp.author;
/*Part 1: Create the AuthorService

Create a new Java class named AuthorService.java.

Mark it with the @Service annotation. This tells Spring that this class is a service component.

Inject the AuthorRepository into this service using constructor injection.

Create a public method createAuthor(Author author) inside the service. This method should contain the logic that was previously in your controller: it should call authorRepository.save(author).*/

import io.github.akshaya.blogapp.author.dto.AuthorDTO;
import io.github.akshaya.blogapp.mapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorDTO createAuthor(AuthorDTO authorDTO)
    {
        Author author = ModelMapper.toAuthor(authorDTO);
        return ModelMapper.toAuthorDTO(authorRepository.save(author));
    }


    /*
    * The method getReferenceById is a bit tricky. It's a "lazy-loaded" method. It doesn't actually hit the database to check if the author exists. Instead, it just creates a "proxy" or a fake Author object in memory with the ID you provided.

The error happens later, when the JSON converter tries to read the name and email from this fake object. At that point, it finally goes to the database, finds that no author with that ID exists, and the system throws an exception, resulting in the generic 500 Internal Server Error.*/
    public AuthorDTO getAuthor(Long id)
    {
        return ModelMapper.toAuthorDTO(authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found with id: " + id)));
    }

    public List<AuthorDTO> getAllAuthors()
    {
        List<Author> authorList = authorRepository.findAll();
        List<AuthorDTO> dtos = new java.util.ArrayList<>();
        for (Author author : authorList)
        {
            dtos.add(ModelMapper.toAuthorDTO(author));
        }
        return dtos;
    }

    public AuthorDTO updateAuthorById(Long authorId, AuthorDTO authorDetails)
    {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException("no data for id author"));
        if (author != null)
        {
            author.setName(authorDetails.getName());
            author.setEmail(authorDetails.getEmail());
        }
        assert author != null;
        return ModelMapper.toAuthorDTO(authorRepository.save(author));
    }

    public void deleteAuthorById(Long authorId)
    {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException("no data for id author"));
        authorRepository.delete(author);
    }
}
