package com.example;

import java.time.LocalDate;
import java.util.List;

public class MainProgram {

    static List<CarOffer> cars = List.of(
            new CarOffer(150000, 2000, LocalDate.now().minusDays(5), "Sprzedam Alfe", 5000.00),
            new CarOffer(250000, 1999, LocalDate.now().minusDays(0), "Sprzedam Opla", 25000.00),
            new CarOffer(110000, 2004, LocalDate.now().minusDays(5), "Sprzedam Opla", 12000.00),
            new CarOffer(350000, 2019, LocalDate.now().minusDays(9), "Sprzedam Opla", 15000.00),
            new CarOffer(140000, 2000, LocalDate.now().minusDays(11), "Opel", 14000.00)
    );

    public static void main(String[] args){

        /**
         * Utwórz klase SearchSettings,
         * która będzie przetrzymywać kryteria wyszukiwania ogłoszeń
         * z odpowiednimi getterami i setterami dla pól:
         * rocznik: od - do
         * przebieg: od - do
         * cena: od - do
         * słowo w tytule
         * data ogłoszenia: od - do
         */
        SearchSettings searchSettings = new SearchSettings();

        /**
         * np. szukamy ogłoszeń samochodów z ostatnich 10 dni,
         * którysh przebieg nie jest wiekszy niz 200000 km
         * cena mieści się w granica 10-16 tyś zł
         * posiada słowo Sprzedam w tytule
         * a i rocznik samochodu nie może być przed rokiem 2000
         */
        searchSettings.setDateFrom(LocalDate.now().minusDays(10));
        searchSettings.setMilleageTo(200000);
        searchSettings.setPriceFrom(10000.0);
        searchSettings.setPriceTo(16000.0);
        searchSettings.setWord("Sprzedam");
        searchSettings.setYearFrom(2000);

        /**
         * Utwórz klasę SearchByYearFilter,
         * która będzie filtrować liste po roczniku auta
         */

        SearchByYearFilter yearFilter = new SearchByYearFilter();

        /**
         * Tej klasie przekazemy obiekt z kreteriami wyszukiwania,
         * oraz listę ogłoszen samochodowych
         */

        yearFilter.setCarOffers(cars);
        yearFilter.setSearchSettings(searchSettings);

        /**
         * dodaj metody:
         * canFilter - ma zbadać, czy w settingsach do wyszukiwania są ustawione ramy dla rocznika
         * filter - ma zwrócić nową listę ogłoszeń spełniających kryteria
         */

        if(yearFilter.canFilter()){
            List<CarOffer> filteredByYearCarsOffers = yearFilter.filter();
            if(filteredByYearCarsOffers.size()>4)
            {
                System.out.println("filtrowanie po roczniku nie działa poprawnie");
                return;
            }
        }

        /**
         * Utwórz pozostałe klasy obiektów, które będę służyły do filtrowania kolekcji:
         *  - SearchByPriceFilter
         *  - SearchByWordFilter
         *  - SearchByMillageFilter
         *  - SearchByDateFilter
         *
         * Utwórz interface o nazwie 'Filter' oraz zadeklaruj go w definicji klas odpowiadających za filtrowanie kolekcji
         * Interface ma być wyciągniety z klasy 'SearchByYearFilter' 
         * tzn. mają być w nim zadeklarowane wszystkie publiczne metody z klasy 'SearchByYearFilter':
         *  - setCarOffers, 
         *  - setSearchSettings, 
         *  - canFilter, 
         *  - filter
         */

        Filter priceFilter = new SearchByPriceFilter();
        Filter wordFilter = new SearchByWordFilter();
        Filter milleageFilter = new SearchByMillageFilter();
        Filter dateFilter = new SearchByDateFilter();

        /**
         * tak jak przy filtrze z rocznikiem wypełnij te obiekty danymi wyszukiwania i kolekcją ogłoszeń do przefiltrowania
         */

        priceFilter.setCarOffers(cars);
        priceFilter.setSearchSettings(searchSettings);

        if(priceFilter.canFilter()){
            List<CarOffer> filteredCarsOffers = priceFilter.filter();
            if(filteredCarsOffers.size()>3)
            {
                System.out.println("filtrowanie po cenie nie działa poprawnie");
                return;
            }
        }

        wordFilter.setCarOffers(cars);
        wordFilter.setSearchSettings(searchSettings);

        if(wordFilter.canFilter()){
            List<CarOffer> filteredCarsOffers = wordFilter.filter();
            if(filteredCarsOffers.size()>4)
            {
                System.out.println("filtrowanie po słowie nie działa poprawnie");
                return;
            }
        }


        milleageFilter.setCarOffers(cars);
        milleageFilter.setSearchSettings(searchSettings);
        if(milleageFilter.canFilter()){
            List<CarOffer> filteredCarsOffers = milleageFilter.filter();
            if(filteredCarsOffers.size()>3)
            {
                System.out.println("filtrowanie po słowie nie działa poprawnie");
                return;
            }
        }
        dateFilter.setCarOffers(cars);
        dateFilter.setSearchSettings(searchSettings);
        if(dateFilter.canFilter()){
            List<CarOffer> filteredCarsOffers = dateFilter.filter();
            if(filteredCarsOffers.size()>4)
            {
                System.out.println("filtrowanie po dacie nie działa poprawnie");
                return;
            }
        }

        /**
         * Utwórz nową klasę Searcher, która będzie zbierać wszystkie filtry w sobiei wykonywać
         * filtrowanie po wszystkich polach
         */

        Searcher searcher = new Searcher();

        /**
         * tutaj należy tak zrobić aby metoda addFilter była zadeklarowana tylko raz w klasie
         * oraz aby moglą przyjmować rózne rodzaje filtrów w parametrze.
         * Wykorzystaj interfejsy
         */
        searcher.addFilter(wordFilter);
        searcher.addFilter(priceFilter);
        searcher.addFilter(milleageFilter);
        searcher.addFilter(dateFilter);

        List<CarOffer> filteredCarsOffers = searcher.filter(cars, searchSettings);

        if(filteredCarsOffers.size()!=1){
            System.out.println("filtrowanie nie działa");
        }

        System.out.println("Koniec");
    }
}
