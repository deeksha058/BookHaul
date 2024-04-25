package com.BookHaul.bookHaul.Model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long bookId;

    @Column(nullable = false)
    private String renterName;

    @Column(nullable = false)
    private Date rentalDate;

    @Column(nullable = false)
    private Date returnDate;

}