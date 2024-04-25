package com.BookHaul.bookHaul.Repository;

import com.BookHaul.bookHaul.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}