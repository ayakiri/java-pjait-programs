package org.pjatk.products;

import java.util.ArrayList;
import org.pjatk.products.DiscountCalculator;

public class ProductsHelperApplication {

    public static void main(String[] args){
        System.out.println("działam");

        ArrayList<String> names = new ArrayList<String>();

        names.add("Jan");
        names.add("Adam");
        names.add("Ola");
        names.add("Ania");
        names.add("Maciej");
        names.add("Krzysztof");

        System.out.println("Ola znajduje się na indeksie: " + names.indexOf("Ola"));

        names.remove("Jan");
                //Adam, Ola, Ania, Maciej, Krzysztof

        names.remove(2);
                // usunie Anię, bo nastąpi przeindeksowanie - Jan już jest usunięty, więc na indeksie będzie Ania
                //Adam, Ola, Maciej, Krzysztof
        names.add(3, "Mateusz");
                // wstawi Mateusza przed Krzysztofa
                //Adam, Ola, Maciej, Mateusz, Krzysztof

        System.out.println("Ilość imion: "+ names.size()+"\noto one:");

        for (String name : names) {
            System.out.println(name);
        }

        System.out.println("Na indeksie 2 jest "+ names.get(2));
        if(names.size()>0)
            System.out.println("Ostatni na liście jest "+ names.get(names.size()-1));

        // PRACA NA ZAJĘCIACH

        System.out.println("\nPraca na zajeciach: ");

        ArrayList<Product> products = new ArrayList<Product>();

        Product p1 = new Product();
        p1.name = "Koszulka";
        p1.price = 45.99;

        Product p2 = new Product();
        p2.name = "Breloczek";
        p2.price = 9.99;

        Product p3 = new Product();
        p3.name = "Czapka";
        p3.price = 15.49;

        Product p4 = new Product();
        p4.name = "Torba";
        p4.price = 99.99;

        Product p5 = new Product();
        p5.name = "Złoto";
        p5.price = 999.99;

        Product p6 = new Product();
        p6.name = "Bluza";
        p6.price = 199.99;

        Product p7 = new Product();
        p7.name = "Buty";
        p7.price = 399.99;

        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p6);
        products.add(p7);

        DiscountCalculator calculator = new DiscountCalculator();

        calculator.products = products;

        calculator.discountByPercentage(300, 0.1);
        calculator.addFreeCompanyGlass(200);
        calculator.threeForPriceOfTwo();
    }
}
