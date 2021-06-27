package com.example.Delivery_service.Interface;
import com.example.Delivery_service.controller.CustomerController;
import com.example.Delivery_service.model.Customer;

import java.util.Map;

public interface CustomerFunctions {
    Customer create();
    void delete();
    void edit();
    Map<Integer, Customer> getList();
}
