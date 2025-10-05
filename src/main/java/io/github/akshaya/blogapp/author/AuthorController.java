package io.github.akshaya.blogapp.author;
import java.util.List;

import io.github.akshaya.blogapp.author.dto.AuthorDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController
{
    private final AuthorService authorService;
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/authors")
    public AuthorDTO createAuthor(@RequestBody AuthorDTO authorDTO)
    {
        return authorService.createAuthor(authorDTO);
    }

    @GetMapping("/authors/{id}")
    public AuthorDTO getAuthor(@PathVariable Long id)
    {
        return authorService.getAuthor(id);
    }

    @GetMapping("/authors")
    public List<AuthorDTO> getAllAuthors()
    {
        return authorService.getAllAuthors();
    }
    @PutMapping("/authors/{authorId}")
    public AuthorDTO updateAuthor(@PathVariable  Long authorId,@RequestBody AuthorDTO authorDetails)
    {
        return authorService.updateAuthorById(authorId, authorDetails);
    }
    @DeleteMapping("/authors/{authorId}")
    public void deleteAuthor(@PathVariable Long authorId){
         authorService.deleteAuthorById(authorId);
    }
}
