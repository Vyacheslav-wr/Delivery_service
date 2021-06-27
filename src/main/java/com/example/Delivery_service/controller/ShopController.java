package com.example.Delivery_service.controller;
import com.example.Delivery_service.Console.ConsoleInput;
import com.example.Delivery_service.Interface.CustomerFunctions;
import com.example.Delivery_service.Interface.ShopFunctions;
import com.example.Delivery_service.JSON.jsonReader;
import com.example.Delivery_service.JSON.jsonWriter;
import com.example.Delivery_service.model.Customer;
import com.example.Delivery_service.model.Order;
import com.example.Delivery_service.model.Product;
import com.example.Delivery_service.model.Shop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShopController implements ShopFunctions {
    static Map<Integer, Shop> all = new HashMap();
    static String str = "shop.json";

    //creates list of all shops
    public ShopController(){
        all = jsonReader.ReadShop(str);
    }

    //add new shop to the list
    public Shop create(){
        Shop shop = new Shop(ConsoleInput.enterID(), ConsoleInput.enterName(), ConsoleInput.enterAddress());
        all.putIfAbsent(shop.getId(), shop);
        jsonWriter.WriteShop(all,str);
        return shop;
    }

    //delete existing shop from the list
    public void delete(){
        Integer id = ConsoleInput.enterID();
        all.remove(id);
        jsonWriter.WriteShop(all,str);
    }

    //changes information about shop
    public void edit(){
        Integer id = ConsoleInput.enterID();
        try{
        Shop edited = (Shop) all.get(id);
        edited.setId(ConsoleInput.enterID());
        edited.setShopAddress(ConsoleInput.enterAddress());
        edited.setShopName(ConsoleInput.enterName());
        all.put(id, edited);
        jsonWriter.WriteShop(all,str);}
        catch (NullPointerException ex){
            System.out.println("!!!!!!!!!!Shop doesnt exist");
        }
    }

    //returns list of all shops
    public Map<Integer, Shop> getList() {
        return all;
    }

    //add new product to the shop
    public void addProduct(Product product){
        for(Map.Entry<Integer, Shop> entry : all.entrySet()){
            Shop val = entry.getValue();
            val.setProduct(product);
        }
    }


    //update info about product in the shop
    public void updateProductInList(){
        Integer id = ConsoleInput.enterID();
        Integer shopID = ConsoleInput.enterShopID();
        Shop shop = all.get(shopID);
        Map<Integer, Product> products = shop.getProducts();
        Product edited = products.get(id);
        edited.setQuantity(ConsoleInput.enterQuantity());
        edited.setPrice(ConsoleInput.enterPrice());
        shop.setProduct(edited);
        all.put(shop.getId(), shop);
        jsonWriter.WriteShop(all,str);
    }


    //creates order
    public void createOrder(){
        Integer id = ConsoleInput.enterCustomerID();
        CustomerFunctions customerFunc = new CustomerController();
        Map<Integer, Customer> customers = customerFunc.getList();
        Customer customer = customers.get(id);

        Integer shopID = ConsoleInput.enterShopID();
        Shop shop = all.get(shopID);

        Map<Integer, Product> allProducts = shop.getProducts();
        ArrayList<Integer> productID = ConsoleInput.enterProductID();
        ArrayList<Product> orderProducts = new ArrayList<>();
        Double totalPrice = 0.0;
        for(int i = 0; i < productID.size(); i++){
            orderProducts.add(allProducts.get(productID.get(i)));
            totalPrice += allProducts.get(productID.get(i)).getPrice();
        }

        Order order = new Order(customer.getFirstName(), customer.getAddress(),
                shop.getShopName(), shop.getShopAddress(), totalPrice, orderProducts);

        Map<String, Order> finalOrder = new HashMap<>();
        finalOrder.put("order", order);
        jsonWriter.WriteOrder(finalOrder,customer.getFirstName() + "Order"+ ".json");
    }
}

