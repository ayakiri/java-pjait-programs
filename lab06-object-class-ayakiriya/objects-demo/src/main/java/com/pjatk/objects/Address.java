package com.pjatk.objects;

import java.util.ArrayList;

public class Address {
    private Integer id;
    private String city;
    private String postalCode;
    private ArrayList<String> addressLines = new ArrayList<String>();

    public Address(Integer id, String city, String postalCode){
        this.id = id;
        this.city = city;
        this.postalCode = postalCode;
    }

    // gettery i settery

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public ArrayList<String> getAddressLines() {
        return addressLines;
    }

    // comparing

    public boolean compareAddress(Address a, Address b){
        return ((a.getId() == b.getId()) && (a.getCity() == b.getCity()) && (a.getPostalCode() == b.getPostalCode()) && a.getAddressLines().equals(b.getAddressLines()));
    }
}
