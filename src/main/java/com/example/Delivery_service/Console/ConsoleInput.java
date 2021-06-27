package com.example.Delivery_service.Console;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class ConsoleInput {
    static Scanner in = new Scanner(System.in);
    public static Integer enterID(){
        System.out.println("Enter id: ");
        Integer id = parseInt(in.nextLine());
        return id;
    }

    public static Integer enterCustomerID(){
        System.out.println("Enter customer id: ");
        Integer id = parseInt(in.nextLine());
        return id;
    }

    public static String enterFName(){
        System.out.println("Enter customer first Name: ");
        String fName = in.nextLine();
        return fName;
    }

    public static String enterLName(){
        System.out.println("Enter customer last Name: ");
        String lName = in.nextLine();
        return lName;
    }

    public static String enterAddress(){
        System.out.println("Enter address: ");
        String address = in.nextLine();
        return address;
    }

    public static Long enterNumber(){
        System.out.println("Enter customer contact number: ");
        Long contactNumber = Long.parseLong(in.nextLine());
        return contactNumber;
    }

    public static String enterName(){
        System.out.println("Enter Name: ");
        String shopName = in.nextLine();
        return shopName;
    }

    public static Integer enterShopID(){
        System.out.println("Enter shop id: ");
        Integer id = parseInt(in.nextLine());
        return id;
    }

    public static Integer enterQuantity(){
        System.out.println("Enter quantity: ");
        Integer quantity = parseInt(in.nextLine());
        return quantity;
    }

    public static Float enterPrice(){
        System.out.println("Enter price: ");
        Float quantity = Float.parseFloat(in.nextLine());
        return quantity;
    }

    public static ArrayList<String> enterCategory(){
        ArrayList<String> categories = new ArrayList<>();
        System.out.println("Enter '0' to stop input");
        String category = null;
        while(true){
            category = in.nextLine();
            if(category.equals("0")){
                break;
            }
            categories.add(category);
        }
        return categories;
    }

    public static String enterOneCategory(){
        System.out.println("Enter category");
        String category = in.nextLine();
        return category;
    }

    public static Integer enterAttribute(){
        System.out.println("Choose attribute for search:\n1.Name\n2.Price");
        Integer choice = parseInt(in.nextLine());
        return choice;
    }

    public static ArrayList<Integer> enterProductID(){
        ArrayList<Integer> products = new ArrayList<>();
        Integer product;
        System.out.println("Enter '0' to stop input");
        while(true){
            product = parseInt(in.nextLine());
            if(product.equals(0)){
                break;
            }
            products.add(product);
        }
        return products;
    }
}
