package com.example.Delivery_service.JSON;
import com.example.Delivery_service.model.Customer;
import com.example.Delivery_service.model.Order;
import com.example.Delivery_service.model.Product;
import com.example.Delivery_service.model.Shop;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class jsonWriter {

    //JSON file writers
    public static void WriteCustomer(Map<Integer, Customer> map, String filename){
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(filename), map);
        } catch (IOException ex) {}

    }
    public static void WriteProduct(Map<Integer, Product> map, String filename){
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(filename), map);
        } catch (IOException ex) {}

    }

    public static void WriteShop(Map<Integer, Shop> map, String filename){
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(filename), map);
        } catch (IOException ex) {}

    }

    public static void WriteOrder(Map<String, Order> map, String filename){
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(filename), map);
        } catch (IOException ex) {}

    }
}
