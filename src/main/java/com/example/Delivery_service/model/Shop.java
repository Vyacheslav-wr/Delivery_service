package com.example.Delivery_service.model;
import java.util.HashMap;
import java.util.Map;

public class Shop {
    private Integer id;

    private String shopName;

    private String shopAddress;

    private Map<Integer, Product> products;

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public Integer getId() {
        return id;
    }

    public void setProduct(Product product){
        products = new HashMap<>();
        this.products.put(product.getId(), product);
    }

    public void setProducts(Map<Integer, Product> products) {
        this.products = products;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Shop(){

    }

    public Shop(Integer id, String ShopName, String ShopAddress){
        this.id = id;
        this.shopAddress = ShopAddress;
        this.shopName = ShopName;
    }

    public String toString(){
        return id + " " + shopAddress;
    }
}
