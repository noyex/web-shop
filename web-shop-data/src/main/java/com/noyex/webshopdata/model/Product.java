package com.noyex.webshopdata.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotNull(message = "Title cannot be null")
    @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters")
    private String name;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = true, message = "Price must be a positive value")
    private double price;

    @DecimalMin(value = "0.0", inclusive = true, message = "Discount cannot be negative")
    private double discount;

    @NotNull(message = "Image is required")
    private String image;

    @Min(value = 0, message = "Quantity can't be negative")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotNull(message = "Category is required")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    @NotNull(message = "Brand is required")
    private Brand brand;

    @Min(value = 0, message = "Rating must be at least 0")
    @Max(value = 5, message = "Rating should not exceed 5")
    private int rating;
    
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @NotNull(message = "AddedAt date is required")
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

//    public void setOnSale() {
//        this.isOnSale = discount > 0;
//    }
//
//    public void setBestseller() {
//        this.isBestseller = rating >= 4;
//    }
//
//    public void setRating(Product product) {
//        List<Review> reviews = product.getReviews();
//        if (reviews.isEmpty()) {
//            this.rating = 0;
//            return;
//        }
//        int sum = 0;
//        for (Review review : reviews) {
//            sum += review.getRating();
//        }
//        this.rating = sum / reviews.size();
//    }
//
//    public void setPrice(Product product) {
//        this.price = product.getPrice() - product.getPrice() * product.getDiscount();
//    }
//
//    public void setNew() {
//        this.isNew = LocalDateTime.now().isBefore(addedAt.plusDays(30));
//    }
//
//    public void setRecommended() {
//        this.isRecommended = rating >= 4;
//    }
//
//    public void setPopular() {
//        this.isPopular = rating >= 4 && reviews.size() >= 10;
//    }
//
//    public void setLimited() {
//        this.isLimited = quantity <= 10;
//    }
//
//    public void setSoldOut() {
//        this.isSoldOut = quantity == 0;
//    }
//
//    public void setComingSoon() {
//        this.isComingSoon = LocalDateTime.now().isBefore(addedAt);
//    }
//
//    public void setDiscounted() {
//        this.isDiscounted = discount > 0;
//    }
}
