package com.example.Delivery_service.controller;
import com.example.Delivery_service.Console.ConsoleInput;
import com.example.Delivery_service.Interface.CustomerFunctions;
import com.example.Delivery_service.JSON.jsonReader;
import com.example.Delivery_service.JSON.jsonWriter;
import com.example.Delivery_service.model.Customer;
import java.util.HashMap;
import java.util.Map;

import static com.example.Delivery_service.Console.ConsoleInput.*;

public class CustomerController implements CustomerFunctions {
    private static CustomerController instance;
    private static Map<Integer, Customer> all = new HashMap<>();

    //Create list of customers
    public CustomerController(){
        all = jsonReader.ReadCustomer("customer.json");
    }

    //Add new customer to the list
    public Customer create(){
        Customer customer = new Customer(enterID(),enterFName(),enterLName(),enterAddress(),enterNumber());
        all.putIfAbsent(customer.getId(), customer);
        jsonWriter.WriteCustomer(all,"customer.json");
        return customer;
    }

    //delete existing customer
    public void delete(){
        Integer id = ConsoleInput.enterID();
        all.remove(id);
        jsonWriter.WriteCustomer(all,"customer.json");
    }

    //changing information about customer
    public void edit(){
        try{
        Integer id = ConsoleInput.enterID();
        Customer edited = all.get(id);
        edited.setId(ConsoleInput.enterID());
        edited.setFirstName(ConsoleInput.enterFName());
        edited.setLastName(ConsoleInput.enterLName());
        edited.setAddress(ConsoleInput.enterAddress());
        edited.setContactNumber(ConsoleInput.enterNumber());
        all.put(id, edited);
        jsonWriter.WriteCustomer(all,"customer.json");}
        catch(NullPointerException ex){
            System.out.println("!!!!!!!!!!!Customer doesnt exist");
        }
    }

    //returns list of customers
    public Map<Integer, Customer> getList() {
        return all;
    }
}
