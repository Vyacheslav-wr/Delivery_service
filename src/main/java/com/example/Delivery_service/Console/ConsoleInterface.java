package com.example.Delivery_service.Console;

import com.example.Delivery_service.Interface.CustomerFunctions;
import com.example.Delivery_service.Interface.ProductFunctions;
import com.example.Delivery_service.Interface.ShopFunctions;
import com.example.Delivery_service.controller.CustomerController;
import com.example.Delivery_service.controller.ProductController;
import com.example.Delivery_service.controller.ShopController;
import com.example.Delivery_service.model.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleInterface {
    public static void Program(){
        Scanner in = new Scanner(System.in);
        ShopFunctions shop = new ShopController();
        CustomerFunctions customer = new CustomerController();
        ProductFunctions product = new ProductController();
        while(true){
        System.out.println("1. Add/delete/edit client");
        System.out.println("2. Add/delete/edit shop");
        System.out.println("3. Add/delete/edit product");
        System.out.println("4. Find product by attribute");
        System.out.println("5. Update product info in shop");
        System.out.println("6. Sort products by price");
        System.out.println("7. Show products in category");
        System.out.println("8. Make an order");
        System.out.println("Enter your choice: ");
        Integer choice = Integer.parseInt(in.nextLine());
        switch (choice) {
            case 1: System.out.println("1. Add client");
                System.out.println("2. Delete client");
                System.out.println("3. Edit client");
                System.out.println("Enter your choice: ");
                Integer choice2 = Integer.parseInt(in.nextLine());
                switch (choice2){
                    case 1:
                        customer.create();
                        break;
                    case 2:
                        customer.delete();
                        break;
                    case 3:
                        customer.edit();
                        break;
                    default:
                        break;

                }
                break;
            case 2:
                System.out.println("1. Add shop");
                System.out.println("2. Delete shop");
                System.out.println("3. Edit shop");
                System.out.println("Enter your choice: ");
                Integer choice3 = Integer.parseInt(in.nextLine());
                switch (choice3){
                    case 1:
                        shop.create();
                        break;
                    case 2:
                        shop.delete();
                        break;
                    case 3:
                        shop.edit();
                        break;
                    default:
                        break;

                }
                break;
            case 3:
                System.out.println("1. Add product");
                System.out.println("2. Delete product");
                System.out.println("3. Edit product");
                System.out.println("Enter your choice: ");
                Integer choice4 = Integer.parseInt(in.nextLine());
                switch (choice4){
                    case 1:
                        product.create();
                        break;
                    case 2:
                        product.delete();
                        break;
                    case 3:
                        product.edit();
                        break;
                    default:
                        break;

                }
                break;
            case 4:
                ArrayList<Product> all = product.findByAttribute();
                for(int i=0; i < all.size(); i++){
                    System.out.println(all.get(i));
                }
                break;
            case 5:
                shop.updateProductInList();
                break;
            case 6:
                ArrayList<Product>sorted = product.sortByPrice();
                for(int i=0; i < sorted.size(); i++){
                    System.out.println(sorted.get(i));
                }
                break;
            case 7:
                ArrayList<Product> list = product.findByCategory();
                for(int i=0; i < list.size(); i++){
                    System.out.println(list.get(i));
                }
                break;
            case 8:
                shop.createOrder();
                break;
        }
        }
    }
}
