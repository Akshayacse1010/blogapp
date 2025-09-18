package io.github.akshaya.blogapp.author;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController
{
    private final AuthorService authorService;
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/authors")
    public Author createAuthor(@RequestBody Author author)
    {
        return authorService.createAuthor(author);
    }

    @GetMapping("/authors/{id}")
    public Author getAuthor(@PathVariable Long id)
    {
        return authorService.getAuthor(id);
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors()
    {
        return authorService.getAllAuthors();
    }
    @PutMapping("/authors/{authorId}")
    public Author updateAuthor(@PathVariable  Long authorId,@RequestBody Author authorDetails)
    {
        return authorService.updateAuthorById(authorId, authorDetails);
    }
    @DeleteMapping("/authors/{authorId}")
    public void deleteAuthor(@PathVariable Long authorId){
         authorService.deleteAuthorById(authorId);
    }
}
