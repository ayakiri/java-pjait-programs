package com.example;

import java.time.LocalDate;

public class Student extends PersonBase {
    private String indexNumber;

    public Student(String name, String surname, LocalDate birth, Gender gender) {
        super(name, surname, birth, gender);
    }

    @Override
    protected void printPersonDetails() {
        System.out.println("Index: " + getIndex());
    }

    //getters
    public String getIndex() {
        return indexNumber;
    }

    //setters
    public void setIndex(String indexNumber) {
        this.indexNumber = indexNumber;
    }
}
