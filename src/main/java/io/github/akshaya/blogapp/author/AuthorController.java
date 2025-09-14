package io.github.akshaya.blogapp.author;

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

}
