package com.example;

import java.time.LocalDate;

abstract class PersonBase {
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private Gender gender;

    public PersonBase(String n, String sn, LocalDate birth, Gender g){
        this.name = n;
        this.surname = sn;
        this.dateOfBirth = birth;
        this.gender = g;
    }

    //getters
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    protected abstract void printPersonDetails();

    public void printPersonBase(){
        System.out.println("Dane: " + getName() + " " + getSurname() + ". Data urodzenia: " + getDateOfBirth()
                + ". Płeć: " + getGender() + ". ");
        printPersonDetails();
    };
}
