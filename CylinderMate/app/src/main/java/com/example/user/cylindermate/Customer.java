package com.example.user.cylindermate;

/**
 * Created by User on 21/02/2019.
 */

public class Customer {
    private String name;
    private String address;
    private String city;
    private String phone;
    private String type;

    public Customer(String name, String address, String city, String phone, String type) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public String getType() {
        return type;
    }
}
