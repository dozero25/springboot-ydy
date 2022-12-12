package com.study.springbootydy.web.dto;

import lombok.*;


@Data
public class ProductDto {
    private String productCode;
    private String productName;
    private String price;
    private String stock;
}
