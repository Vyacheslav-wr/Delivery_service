package com.example.Delivery_service.controller;
import com.example.Delivery_service.Console.ConsoleInput;
import com.example.Delivery_service.Interface.ProductFunctions;
import com.example.Delivery_service.Interface.ShopFunctions;
import com.example.Delivery_service.JSON.jsonReader;
import com.example.Delivery_service.JSON.jsonWriter;
import com.example.Delivery_service.model.Customer;
import com.example.Delivery_service.model.Product;
import java.util.*;

public class ProductController implements ProductFunctions {
    static Map<Integer, Product> all = new HashMap();

    //Creates list of products
    public ProductController(){
        all = jsonReader.ReadProduct("product.json");
    }
    //add new product to he list
    public Product create(){
        Product product = new Product(ConsoleInput.enterID(), ConsoleInput.enterName(),
                ConsoleInput.enterQuantity(), ConsoleInput.enterPrice(), ConsoleInput.enterCategory());
        all.putIfAbsent(product.getId(), product);
        jsonWriter.WriteProduct(all,"product.json");
        ShopFunctions func = new ShopController();
        func.addProduct(product);
        return product;
    }

    //remove existing products
    public void delete(){
        Integer id = ConsoleInput.enterID();
        all.remove(id);
        jsonWriter.WriteProduct(all,"product.json");
    }

    //changes information about product
    public void edit(){
        Integer id = ConsoleInput.enterID();
        try{Product edited = all.get(id);
        edited.setId(ConsoleInput.enterID());
        edited.setName(ConsoleInput.enterName());
        edited.setQuantity(ConsoleInput.enterQuantity());
        edited.setCategory(ConsoleInput.enterCategory());
        edited.setPrice(ConsoleInput.enterPrice());
        all.put(id, edited);
        jsonWriter.WriteProduct(all,"product.json");}
        catch (NullPointerException ex){
            System.out.println("!!!!!!!!!!Product doesnt exist");
        }
    }

    //find products by their categories
    public ArrayList<Product> findByCategory(){
        ArrayList<Product> filter = new ArrayList<>();
        String str = ConsoleInput.enterOneCategory();
        for(Map.Entry<Integer, Product> entry : all.entrySet()){
            Product val = entry.getValue();
            if(val.getCategory().contains(str)){
                filter.add(val);
            }
        }
        return filter;
    }

    //find products by their attributes
    public ArrayList<Product> findByAttribute(){
        ArrayList<Product> filter = new ArrayList<>();
        String choice;
        switch(ConsoleInput.enterAttribute()){
            case 1: choice = ConsoleInput.enterOneCategory();
            case 2: choice = ConsoleInput.enterOneCategory();
            default: choice = ConsoleInput.enterOneCategory();
        }
        for(Map.Entry<Integer, Product> entry : all.entrySet()){
            Product val = entry.getValue();
            if(val.getCategory().contains(choice)){
                filter.add(val);
            }
        }
        return filter;
    }

    //returns list of all products
    public Map<Integer, Product> getList() {
        return all;
    }

    //sorts all products by price
    public ArrayList<Product> sortByPrice(){
        ArrayList<Product> filter = new ArrayList<>();
        for(Map.Entry<Integer, Product> entry : all.entrySet()){
            Product val = entry.getValue();
            filter.add(val);
        }
        Collections.sort(filter, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice() > o2.getPrice() ? -1 : (o1.getPrice() < o2.getPrice()) ? 1 : 0;
            }
        });
        return filter;
    }
}
