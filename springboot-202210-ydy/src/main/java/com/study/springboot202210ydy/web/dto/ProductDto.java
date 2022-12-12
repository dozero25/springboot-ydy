package com.study.springboot202210ydy.web.dto;

import lombok.Data;

@Data
public class ProductDto {
    private String productCode;
    private String productName;
    private String price;
    private String stock;
}
