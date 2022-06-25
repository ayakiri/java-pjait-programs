package com.example;

public class MainProgram {

    public static void main(String[] args){

        /**
         * Utwórz klase Polynomial (wielomian)
         * z konstruktorem przyjmującym tablicę liczb typu int (współczynniki wielomianu)
         * np. {1,2,3} --> 3x^2 + 2x + 1
         */
        Polynomial w1 = new Polynomial(new int[]{1, 2, 1});

        /**
         * Dodaj gettery i settery do pola które przetrzymuje tablicę współczynników
         */
        w1.setCoeficients(new int[] {2,3});
        int[] w1_coef = w1.getCoeficients();

        if(w1_coef[0]!=2 || w1_coef[1]!=3){
            System.out.println("Gettery lub settery nie działają poprawnie");
            return;
        }

        /**
         * Dodaj metodę coeficientAt, która zwróci współczynnik przy konkretnym wyrazie wielomianu
         * np.
         * wielomian: 2x^2 + 3x + 4
         * w.coeficientAt(2) zwróci to co stoi przy x^2 czyli 2
         * w.coeficientAt(5) zwróci to co stoi przy x^5 czyli 0
         * w.coeficientAt(0) zwróci to co stoi przy x^0 (wyraz wolny) czyli 4
         */

        int a = w1.coeficientAt(1);
        int b = w1.coeficientAt(0);

        if(a!=3 ||b!=2){
            System.out.println("Wybieranie konkretnych współczynników nie działa poprawnie");
            return;
        }

        /**
         * Dodaj metodę w klasie Polynomial o nazwie 'add',
         * która pozwoli na dodoawanie do siebie wielomianów
         * oraz zwróci wynik w nowym obiekcie
         */

        Polynomial w2 = new Polynomial(new int []{2,3,4});
        Polynomial w3 = w1.add(w2);

        if(w3.coeficientAt(0)!=4 || w3.coeficientAt(1) != 6 || w3.coeficientAt(2) !=4){
            System.out.println("Dodawanie wielomianów nie działa poprawnie");
            return;
        }


        /**
         * Nadpisz metodę toString w klasie Polynomial tak aby zwracała napis pokazujący wielomian
         * np.
         * w3.toString() powinno zwrócic  "4x^2+6x+4"
         */

        if(!w3.toString().equals("4x^2+6x+4")){
            System.out.println("Nie wyświetli dobrze wilomianu na konsoli "+ w3.toString());
            return;
        }

        /**
         * Nadpisz metodę equals, dzięki której będziemy mogli porównywaćobiekty wielomianów po współczynikach
         */
        if(!w3.equals(new Polynomial(new int[] {4,6,4}))){
            System.out.println("Porównywanie wielomianów nie działa poprawnie");
            return;
        }


        /**
         * Dodaj nową klasę PolynomialHelper, z metodą o nazwie derrivative,
         * która wyliczy pochdną wielomianu
         */

//        Polynomial w3_pochodna = PolynomialHelper.derrivative(w3);
//
//        if(!w3_pochodna.equals(new Polynomial(new int[] {6, 8}))){
//            System.out.println("Pochodna wielomianu nie została poprawnie wyliczona");
//            return;
//        }
//
//        System.out.println("koniec");
    }
}
