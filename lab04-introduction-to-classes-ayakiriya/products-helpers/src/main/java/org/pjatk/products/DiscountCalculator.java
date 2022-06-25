package org.pjatk.products;

import java.util.ArrayList;

public class DiscountCalculator {

    public ArrayList<Product> products;

    /*
        minimumPrice - cena minimalna, od której zaczyna się naliczanie rabatu
        percentage - liczba od 0 do 1, określająca jaki procent rabatu jest przyznany, np 0.1 to 10%
     */
    public void discountByPercentage(double minimumPrice, double percentage){
        double sum = 0;
        // zsumuj wartosc produktow do sum
        for(Product product : products){
            sum += product.price;
        }
        // porownaj czy sum >= minimumPrice
        if(sum >= minimumPrice) {
            // obniz cene kazdego produktu o percentage, jesli ^true
            for(Product product : products){
                product.price = Math.round((product.price - (product.price  * percentage)) * 100.0) / 100.0;
            }
        }

        System.out.println("Nowe ceny: ");
        for(Product product : products){
            System.out.println(product.name + ": " + product.price);
        }
    }

    public void addFreeCompanyGlass(double minimumPrice){
        double sum = 0;
        for(Product product : products){
            sum += product.price;
        }
        if(sum >= minimumPrice){
            Product kubek = new Product();
            kubek.name = "Firmowy kubek gratis";
            kubek.price = 0;

            products.add(kubek);
        }
    }

    public void threeForPriceOfTwo(){
        int howManyTimesSale = products.size()/3;

        for(int i = 1; i <= howManyTimesSale; i++) {
            int indexOfCheapest = 0;
            for (Product product : products) {
                if (product.price < products.get(indexOfCheapest).price && product.price != 0.0) {
                    indexOfCheapest = products.indexOf(product);
                }
            }
            products.get(indexOfCheapest).price = 0;
        }

        System.out.println("Ceny po przecenie: ");
        for(Product product : products){
            System.out.println(product.name + ": " + product.price);
        }
    }

}
