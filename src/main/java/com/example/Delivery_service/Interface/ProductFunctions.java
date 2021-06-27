package com.example.Delivery_service.Interface;
import com.example.Delivery_service.model.Customer;
import com.example.Delivery_service.model.Product;

import java.util.ArrayList;
import java.util.Map;

public interface ProductFunctions {
    Product create();
    void delete();
    void edit();
    ArrayList<Product> findByCategory();
    ArrayList<Product> sortByPrice();
    ArrayList<Product> findByAttribute();
    Map<Integer, Product> getList();
}
