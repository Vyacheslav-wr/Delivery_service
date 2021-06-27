package com.example.Delivery_service.model;

import java.util.ArrayList;

public class Product {
    private Integer id;

    private String name;

    private Integer quantity;

    private Float price;

    private ArrayList<String> category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public ArrayList<String> getCategory() {
        return category;
    }

    public void setCategory(ArrayList<String> category) {
        this.category = category;
    }

    public Product(){

    }

    public Product(Integer ID, String Name, Integer quantity, Float price, ArrayList<String> Category){
        this.id = ID;
        this.name = Name;
        this.quantity = quantity;
        this.price = price;
        this.category = Category;
    }

    @Override
    public String toString(){
        return id + " " + " " + name + " " + price;
    }
}
