package com.BookHaul.bookHaul.Service;

import com.BookHaul.bookHaul.Exception.ResourceNotFoundException;
import com.BookHaul.bookHaul.Model.Rental;
import com.BookHaul.bookHaul.Repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Rental createRental(Rental rental) {
        return rentalRepository.save(rental);
    }

    public Rental getRentalById(Long id)  throws ResourceNotFoundException {
        return rentalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rental", "id", id));
    }

    public Rental updateRental(Long id, Rental rentalDetails) throws ResourceNotFoundException  {
        Rental rental = rentalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rental", "id", id));

        rental.setBookId(rentalDetails.getBookId());
        rental.setRenterName(rentalDetails.getRenterName());
        rental.setRentalDate(rentalDetails.getRentalDate());
        rental.setReturnDate(rentalDetails.getReturnDate());

        return rentalRepository.save(rental);
    }

    public void deleteRental(Long id)  throws ResourceNotFoundException {
        Rental rental = rentalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rental", "id", id));

        rentalRepository.delete(rental);
    }
}
