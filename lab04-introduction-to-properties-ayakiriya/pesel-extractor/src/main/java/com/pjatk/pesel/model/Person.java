package com.pjatk.pesel.model;

import java.time.LocalDate;
import java.util.Scanner;

public class Person {
    String name;
    String surname;
    String peselNumber;
    String gender;
    LocalDate dateOfBirth;

    public Person (String pesel) {
        this.peselNumber = pesel;

        extractGender();
        extractDateOfBirth();
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPeselNumber() {
        return peselNumber;
    }

    private void extractGender() {
        Integer gen = Integer.valueOf(peselNumber.substring(9, 10));
        if(gen%2 == 0) {
            this.gender = "Kobieta";
        } else {
            this.gender = "Mężczyzna";
        }
    }

    public String getGender() {
        return gender;
    }

    private void extractDateOfBirth() {
        Integer year = Integer.valueOf(peselNumber.substring(0, 2));
        Integer month = Integer.valueOf(peselNumber.substring(2, 4));
        Integer day = Integer.valueOf(peselNumber.substring(4, 6));

        if(month > 12){
            year = year + 2000;
            month = month - 20;
        } else {
            year = year + 1900;
        }

        LocalDate date = LocalDate.of(year, month, day);

        this.dateOfBirth = date;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
