package com.BookHaul.bookHaul.Controller;

import com.BookHaul.bookHaul.Exception.ResourceNotFoundException;
import com.BookHaul.bookHaul.Model.Author;
import com.BookHaul.bookHaul.Service.AuthorService;
import com.BookHaul.bookHaul.Service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public ResponseEntity<?> getAllAuthors() {

        return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> createAuthor(@RequestBody Author author) {

        return new ResponseEntity<>(authorService.createAuthor(author),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable(value = "id") Long authorId) throws ResourceNotFoundException {
        return new ResponseEntity<>(authorService.getAuthorById(authorId),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable(value = "id") Long authorId,
                               @RequestBody Author authorDetails) throws ResourceNotFoundException {
        return new ResponseEntity<>(authorService.updateAuthor(authorId, authorDetails),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable(value = "id") Long authorId) throws ResourceNotFoundException {
        authorService.deleteAuthor(authorId);
       return new ResponseEntity<>( "Author Deleted Successfully!..", HttpStatus.OK);
    }
}
