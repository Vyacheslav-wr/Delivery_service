package com.example.Delivery_service.JSON;
import com.example.Delivery_service.model.Customer;
import com.example.Delivery_service.model.Product;
import com.example.Delivery_service.model.Shop;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class jsonReader {

    //JSON file readers
    public static Map<Integer, Customer> ReadCustomer(String filename){
    ObjectMapper mapper = new ObjectMapper();
    try {
        Map<Integer, Customer> map = mapper.readValue(new File(filename),
                new TypeReference<HashMap<Integer, Customer>>(){});
        return map;
    } catch (IOException ex) {
    }
    return null;
    }

    public static Map<Integer, Product> ReadProduct(String filename){
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<Integer, Product> map = mapper.readValue(new File(filename),
                    new TypeReference<HashMap<Integer, Product>>(){});
            return map;
        } catch (IOException ex) {
        }
        return null;
    }

    public static Map<Integer, Shop> ReadShop(String filename){
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<Integer, Shop> map = mapper.readValue(new File(filename),
                    new TypeReference<HashMap<Integer, Shop>>(){});
            return map;
        } catch (IOException ex) {
        }
        return null;
    }
}