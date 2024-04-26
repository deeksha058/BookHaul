package com.BookHaul.bookHaul.Controller;

import com.BookHaul.bookHaul.Exception.ResourceNotFoundException;
import com.BookHaul.bookHaul.Model.Book;
import com.BookHaul.bookHaul.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public ResponseEntity<?> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> createBook(@RequestBody Book book) {

        return new ResponseEntity<>( bookService.createBook(book), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable(value = "id") Long bookId)  throws ResourceNotFoundException {
        return new ResponseEntity<>(bookService.getBookById(bookId), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable(value = "id") Long bookId,
                           @RequestBody Book bookDetails)  throws ResourceNotFoundException {
        return new ResponseEntity<>(bookService.updateBook(bookId, bookDetails), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long bookId)  throws ResourceNotFoundException {
        bookService.deleteBook(bookId);
        return new ResponseEntity<>("Book Deleted Successfully!...", HttpStatus.OK);
    }
}

