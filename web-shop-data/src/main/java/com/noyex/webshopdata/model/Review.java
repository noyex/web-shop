package com.noyex.webshopdata.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private int rating;

    @ManyToOne
    private User user;

    private String author;

    private LocalDateTime date;
}
