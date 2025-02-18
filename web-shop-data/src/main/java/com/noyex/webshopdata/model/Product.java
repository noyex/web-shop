package com.noyex.webshopdata.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters")
    private String name;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;
    
    private double price;

    private double discount;
    
    private String image;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Brand brand;
    
    private int rating;
    
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    private LocalDateTime addedAt;

    private boolean isAvailable;

    private boolean isOnSale;

    private boolean isBestseller;

    private boolean isNew;

    private boolean isRecommended;

    private boolean isPopular;

    private boolean isLimited;

    private boolean isSoldOut;

    private boolean isComingSoon;

    private boolean isDiscounted;

    public void setOnSale() {
        this.isOnSale = discount > 0;
    }

    public void setBestseller() {
        this.isBestseller = rating >= 4;
    }

    public void setRating(Product product) {
        List<Review> reviews = product.getReviews();
        int sum = 0;
        for (Review review : reviews) {
            sum += review.getRating();
        }
        this.rating = sum / reviews.size();
    }

    public void setPrice(Product product) {
        this.price = product.getPrice() - product.getPrice() * product.getDiscount();
    }

    public void setNew() {
        this.isNew = LocalDateTime.now().isBefore(addedAt.plusDays(30));
    }

    public void setRecommended() {
        this.isRecommended = rating >= 4;
    }

    public void setPopular() {
        this.isPopular = rating >= 4 && reviews.size() >= 10;
    }

    public void setLimited() {
        this.isLimited = quantity <= 10;
    }

    public void setSoldOut() {
        this.isSoldOut = quantity == 0;
    }

    public void setComingSoon() {
        this.isComingSoon = LocalDateTime.now().isBefore(addedAt);
    }

    public void setDiscounted() {
        this.isDiscounted = discount > 0;
    }
}
