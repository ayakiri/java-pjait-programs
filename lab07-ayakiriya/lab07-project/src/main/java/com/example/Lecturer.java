package com.example;

import java.time.LocalDate;

public class Lecturer extends PersonBase{
    private String title;

    public Lecturer(String name, String surname, LocalDate birth, Gender gender) {
        super(name, surname, birth, gender);
    }

    @Override
    protected void printPersonDetails() {
        System.out.println("Tytuł: " + getTitle());
    }

    //getters
    public String getTitle() {
        return title;
    }

    //setters
    public void setTitle(String title) {
        this.title = title;
    }
}
