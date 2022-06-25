package com.example;

import java.time.LocalDate;

public class MainProgram {

    public static void main(String[] args){

        /**
         * Utwórz klasę 'Student' z polami :
         * ->name
         * ->surname
         * ->dateOfBirth
         * ->gender
         *
         * oraz
         *
         * -> indexNumber
         */

        Student janekKowalski = new Student("janeczek", "kowalski", LocalDate.of(1999, 01, 03), Gender.MALE);

        /**
         * dodaj gettery oraz setter do wszystkich pól w klasie Student
         */

        janekKowalski.setName("Jan");
        janekKowalski.setSurname("Kowalski");
        janekKowalski.setIndex("s00001");
        System.out.println(janekKowalski.getName()
                +" " + janekKowalski.getSurname()
        +" " +janekKowalski.getDateOfBirth()
        +" " +janekKowalski.getGender()
        +" " +janekKowalski.getIndex());


        /**
         * Utwórz klasę 'Lecturer' z polami :
         * ->name
         * ->surname
         * ->dateOfBirth
         * ->gender
         *
         * oraz
         * -> title
         *
         * oraz gettery i settery
         */

        Lecturer aniaNowak = new Lecturer("ania", "nowak", LocalDate.of(1980, 05, 10), Gender.FEMALE);
        aniaNowak.setName("Anna");
        aniaNowak.setSurname("Nowak");
        aniaNowak.setTitle("Phd");

        System.out.println(aniaNowak.getName()
                +" " + aniaNowak.getSurname()
                +" " +aniaNowak.getDateOfBirth()
                +" " +aniaNowak.getGender()
                +" " +aniaNowak.getTitle());

        /**
         * Utwórz klasę 'Scholar' z polami :
         * ->name
         * ->surname
         * ->dateOfBirth
         * ->gender

         * -> indexNumber
         *
         * oraz
         *
         * -> scholarship (kwota stypendium)
         */

        Scholar fryderykNowak = new Scholar("fryderyk", "nowak", LocalDate.of(1997, 05, 15), Gender.MALE);

        fryderykNowak.setName("Fryderyk");
        fryderykNowak.setSurname("Nowak");
        fryderykNowak.setIndex("s00001");
        fryderykNowak.setScholarship(500.00);
        System.out.println(fryderykNowak.getName()
                +" " + fryderykNowak.getSurname()
                +" " +fryderykNowak.getDateOfBirth()
                +" " +fryderykNowak.getGender()
                +" " +fryderykNowak.getIndex()
                +" " +fryderykNowak.getScholarship());

        /**
         * Zauważ, że klasy które zostały stworzone są bardzo do siebie podobne
         * tzn. posiadają identyczne konstruktory, wspólne pola, oraz gettery i settery
         *
         * Utwórz nową klasę 'PersonBase', która będzie klasą bazową dla powyższych klas
         */

        PersonBase janeczek = janekKowalski;
        PersonBase aniusia = aniaNowak;
        PersonBase fredek = fryderykNowak;

        /**
         * wspólne pola, konstruktory, oraz gettery i settery
         * wydziel z klas Student, Lecturer, Scholar
         * do klasy PersonBase
         */


        fredek.setName("Fryderyk");
        fredek.setSurname("Nowak");
        System.out.println(fredek.getName()
                +" " + fredek.getSurname()
                +" " +fredek.getDateOfBirth()
                +" " +fredek.getGender());


        aniusia.setName("Anna");
        aniusia.setSurname("Nowak");
        System.out.println(aniusia.getName()
                +" " + aniusia.getSurname()
                +" " +aniusia.getDateOfBirth()
                +" " +aniusia.getGender());


        janeczek.setName("Jan");
        janeczek.setSurname("Kowalski");
        System.out.println(janeczek.getName()
                +" " + janeczek.getSurname()
                +" " +janeczek.getDateOfBirth()
                +" " +janeczek.getGender());
        /**
         * klasa PersonBase powinna być klasą abstrakcyjną,
         * nie powinno się dać utworzyć instancji tej klasy
         */

        //PersonBase osoba =
                //new PersonBase("name", "surname", LocalDate.of(2000, 05, 15), Gender.MALE);
        //-> powyższa linijka powinna zwracać błąd kompilacji - jeśli tak jest zakomentuj ją (ta linijka ma NIE działać).

        /**
         * Zadeklaruj abstrakcyjną metodę 'printPersonDetails' w klasie PersonBase.
         * Klasy potomne t.j. Student, Lecturer, Scholar powinny ją implementować
         * tak aby na ekranie konsoli były wyświetlone wszystkie informacje
         * o danej osobie
         */

        fredek.printPersonBase();
        aniusia.printPersonBase();
        janeczek.printPersonBase();

        /**
         * Spróbuj zaimplementować (poprawić kod) według zasady
         * 'DRY - DO NOT REPEAT YOURSELF - '
         * tzn. jeśli kod w implementacjach metody się powtarza
         * to spróbuj część wspólną wydzielić do klasy nadrzędnej 'PersonBase'
         */

        System.out.println("KONIEC");

    }
}
