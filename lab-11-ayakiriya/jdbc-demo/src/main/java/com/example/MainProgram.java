package com.example;

import java.sql.SQLOutput;
import java.util.List;

public class MainProgram {
    public static void main(String[] args){

        Person janusz = new Person();

        PersonRepository repo = new PersonRepository();

        repo.createTable();

        janusz.setName("Janusz");
        janusz.setSurname("Kowalski");
        janusz.setAge(30);

        repo.save(janusz);

        repo.delete(2);
        repo.delete(6);
        repo.delete(7);
        repo.delete(8);
        repo.delete(9);

        Person ania = new Person();

        ania.setName("Ania");
        ania.setSurname("Nowak");
        ania.setAge(22);

        repo.update(ania);

        List<Person> people = repo.getAll();

        for (Person person : people){
            System.out.println("Dane: "
                    + person.getId() + " "
                    + person.getName() + " "
                    + person.getSurname() + " "
                    + person.getAge() + "."
            );
        }
    }
}
