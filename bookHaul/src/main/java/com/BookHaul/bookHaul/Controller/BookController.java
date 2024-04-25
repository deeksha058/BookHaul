package com.BookHaul.bookHaul.Controller;

import com.BookHaul.bookHaul.Exception.ResourceNotFoundException;
import com.BookHaul.bookHaul.Model.Book;
import com.BookHaul.bookHaul.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/")
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable(value = "id") Long bookId)  throws ResourceNotFoundException {
        return bookService.getBookById(bookId);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable(value = "id") Long bookId,
                           @RequestBody Book bookDetails)  throws ResourceNotFoundException {
        return bookService.updateBook(bookId, bookDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable(value = "id") Long bookId)  throws ResourceNotFoundException {
        bookService.deleteBook(bookId);
    }
}

