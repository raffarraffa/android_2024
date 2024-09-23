package com.rafalopez.examen3.entity;

import java.io.Serializable;

public class Product implements Serializable, Comparable<Product>{
    private String code;
    private String desciption;
    private int stock;
    private double price;

    public Product(String code, String desciption, int stock, double price) {
        this.code = code;
        this.desciption = desciption;
        this.stock = stock;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", desciption='" + desciption + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        return 0;
    }
}
