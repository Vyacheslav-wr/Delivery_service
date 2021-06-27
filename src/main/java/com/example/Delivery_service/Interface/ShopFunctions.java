package com.example.Delivery_service.Interface;
import com.example.Delivery_service.model.Customer;
import com.example.Delivery_service.model.Product;
import com.example.Delivery_service.model.Shop;

import java.util.Map;

public interface ShopFunctions {
    Shop create();
    void delete();
    void edit();
    Map<Integer, Shop> getList();
    void addProduct(Product product);
    void updateProductInList();
    void createOrder();
}
