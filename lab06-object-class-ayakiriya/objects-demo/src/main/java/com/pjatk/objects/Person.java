package com.pjatk.objects;

import java.time.LocalDate;
import java.util.ArrayList;

public class Person {
    private Integer id;
    private String name;
    private LocalDate birthday;
    private ArrayList<Address> addresses = new ArrayList<Address>();

    public Person(Integer id, String name, LocalDate birthday){
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    //gettery i settery

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDateOfBirth(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getDateOfBirth() {
        return birthday;
    }

    // kopia

    public Person copy(){
        Person p = new Person(this.id, this.name, this.birthday);
        return p;
    }



    //compare

    public boolean equals(Person p){
        return (comparePerson(p) && compareAddresses(p));
    }

    private boolean comparePerson(Person p){
        return ((this.id == p.id) && (this.name == p.name) && (this.birthday == p.birthday));
    }

    private boolean compareAddresses(Person p){
        Boolean isTheSame = true;

        for(int i = 0; i < getAddresses().size(); i++){
            if(!this.getAddresses().get(i).compareAddress(this.getAddresses().get(i), p.getAddresses().get(i))){
                isTheSame = false;
            };
        }

        return isTheSame;
    }

    // adresy

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    // drukowanie


    @Override
    public String toString() {
        return "(" +
                id +
                ", " + name  +
                ", " + birthday +
                ", " + getAddresses().get(0).getId() +
                ", " + getAddresses().get(0).getCity() +
                ", " + getAddresses().get(0).getPostalCode() +
                ", " + getAddresses().get(0).getAddressLines().get(0) +
                ')' ;
    }
}
