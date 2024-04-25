package com.BookHaul.bookHaul.Controller;

import com.BookHaul.bookHaul.Exception.ResourceNotFoundException;
import com.BookHaul.bookHaul.Model.Author;
import com.BookHaul.bookHaul.Service.AuthorService;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @PostMapping("/")
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable(value = "id") Long authorId) throws ResourceNotFoundException {
        return authorService.getAuthorById(authorId);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable(value = "id") Long authorId,
                               @RequestBody Author authorDetails) throws ResourceNotFoundException {
        return authorService.updateAuthor(authorId, authorDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable(value = "id") Long authorId) throws ResourceNotFoundException {
        authorService.deleteAuthor(authorId);
    }
}
