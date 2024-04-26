package com.BookHaul.bookHaul.Repository;

import com.BookHaul.bookHaul.Model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

//    @Query(value = "SELECT * FROM rental WHERE bookId = :bookId" ,nativeQuery = true)
//    Rental IsBookAvailable(Long bookId);
}