package com.example.Delivery_service.model;

public class Customer {
    private Integer id;

    private String firstName;

    private String lastName;

    private String address;

    private Long contactNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Customer(){

    }

    public Customer(Integer ID, String fName, String lName, String Address, Long contactNumber){
        this.id = ID;
        this.firstName = fName;
        this.lastName = lName;
        this.address = Address;
        this.contactNumber = contactNumber;
    }
}
