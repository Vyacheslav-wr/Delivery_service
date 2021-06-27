package com.example.Delivery_service.model;

import java.util.ArrayList;

public class Order {
    private String orderOwner;

    private String ownerAddress;

    private String shopName;

    private String shopAddress;

    public String getOrderOwner() {
        return orderOwner;
    }

    public void setOrderOwner(String orderOwner) {
        this.orderOwner = orderOwner;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    private ArrayList<Product> products;

    private Double totalPrice;

    public Order(String orderOwner, String ownerAddress, String shopName, String shopAddress, Double totalPrice,
                 ArrayList<Product> products){
        this.orderOwner = orderOwner;
        this.ownerAddress = ownerAddress;
        this.shopName = shopName;
        this.shopAddress = shopAddress;
        this.totalPrice = totalPrice;
        this.products = products;
    }
}
