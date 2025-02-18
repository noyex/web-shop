package com.noyex.webshopdata.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageDTO {
    private String imageUrl;
    private String altText;
    private Long productId;
}
