package com.example.foodorder;

import java.io.Serializable;

public class Foods implements Serializable {
    private String title;
    private String picture;
    private String description;
    private Double fee;
    private int cash;

    public Foods(String title, String picture, String description, Double fee) {
        this.title = title;
        this.picture = picture;
        this.description = description;
        this.fee = fee;
    }

    public Foods(String title, String picture, String description, Double fee, int cash) {
        this.title = title;
        this.picture = picture;
        this.description = description;
        this.fee = fee;
        this.cash = cash;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
}
