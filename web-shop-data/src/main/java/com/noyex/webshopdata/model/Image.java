package com.noyex.webshopdata.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    private String altText;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
