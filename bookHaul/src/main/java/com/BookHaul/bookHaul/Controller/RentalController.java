package com.BookHaul.bookHaul.Controller;

import com.BookHaul.bookHaul.Exception.ResourceNotFoundException;
import com.BookHaul.bookHaul.Model.Book;
import com.BookHaul.bookHaul.Model.Rental;
import com.BookHaul.bookHaul.Service.BookService;
import com.BookHaul.bookHaul.Service.RentalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    @PostMapping("/renting")
    public ResponseEntity<?> createRental(@RequestBody Rental rental) throws ResourceNotFoundException {

        Book book = bookService.getBookById(rental.getBookId());
        Rental rental1 = rental;
        rental1.setRentalDate(LocalDate.now());
        rental1.setReturnDate(LocalDate.now().plusDays(14));
        if(book == null){

            return new ResponseEntity<>("Book Is Not Present In the haul", HttpStatus.OK);
        }
        if(book.isRented() == true){

            Book book1 = bookService.updateBookByAvailability(rental.getBookId(), false);
            return new ResponseEntity<>(rentalService.createRental(rental), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("bookIs Currently Occupied By Someone Else", HttpStatus.OK);
        }
    }

    @GetMapping("/returning/{id}")
    public ResponseEntity<?> returnBook(@PathVariable Long id) throws ResourceNotFoundException {

        Rental rental = rentalService.getRentalById(id);

        Book book1 = bookService.updateBookByAvailability(rental.getBookId(), true);
        LocalDate todayDate = LocalDate.now();
        LocalDate expectedReturnDate =  rental.getReturnDate();

        int comparison = todayDate.compareTo(expectedReturnDate);

        if (comparison <= 0) {

            return new ResponseEntity<>("Book Returned on time!...", HttpStatus.OK);
        } else{

            return new ResponseEntity<>("overdue rentals",HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public Rental getRentalById(@PathVariable(value = "id") Long rentalId)  throws ResourceNotFoundException {
        return rentalService.getRentalById(rentalId);
    }

    @PutMapping("/{id}")
    public Rental updateRental(@PathVariable(value = "id") Long rentalId,
                               @RequestBody Rental rentalDetails)  throws ResourceNotFoundException {
        return rentalService.updateRental(rentalId, rentalDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteRental(@PathVariable(value = "id") Long rentalId)  throws ResourceNotFoundException {
        rentalService.deleteRental(rentalId);
    }
}
