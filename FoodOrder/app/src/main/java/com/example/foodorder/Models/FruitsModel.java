package com.example.foodorder.Models;

public class FruitsModel {
    int image;
    String name, price, description, count;

    public FruitsModel(int image, String name, String price, String description, String count) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.description = description;
        this.count = count;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
