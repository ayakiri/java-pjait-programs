package com.example;

import java.time.LocalDate;

public class Scholar extends Student {
    private Double scholarship;

    public Scholar(String name, String surname, LocalDate birth, Gender gender) {
        super(name, surname, birth, gender);
    }

    @Override
    protected void printPersonDetails() {
        super.printPersonDetails();
        System.out.println("Stypendium: " + getScholarship() + "zł.");
    }


    //getters
    public Double getScholarship() {
        return scholarship;
    }

    //setters
    public void setScholarship(Double scholarship) {
        this.scholarship = scholarship;
    }
}
