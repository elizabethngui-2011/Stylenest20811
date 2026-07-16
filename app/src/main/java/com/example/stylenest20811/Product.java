package com.example.stylenest20811;

public class Product {
    private String name;
    private String price;
    private int imageResource;
    private String description;

    public Product(String name, String price, int imageResource, String description) {
        this.name = name;
        this.price = price;
        this.imageResource = imageResource;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getDescription() {
        return description;
    }
}
