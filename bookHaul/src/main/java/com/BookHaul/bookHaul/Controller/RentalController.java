package com.BookHaul.bookHaul.Controller;

import com.BookHaul.bookHaul.Exception.ResourceNotFoundException;
import com.BookHaul.bookHaul.Model.Rental;
import com.BookHaul.bookHaul.Service.RentalService;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @GetMapping("/")
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    @PostMapping("/")
    public Rental createRental(@RequestBody Rental rental) {
        return rentalService.createRental(rental);
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
