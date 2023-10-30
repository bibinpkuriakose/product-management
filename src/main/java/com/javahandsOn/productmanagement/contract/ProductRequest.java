package com.javahandsOn.productmanagement.contract;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private String category;
    private Long price;
    private Long stock;
    public ProductRequest(String name, String category, Long price, Long stock){
        this.category = category;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public ProductRequest() {

    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Long getPrice() {
        return price;
    }

    public Long getStock() {
        return stock;
    }
}
