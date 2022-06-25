package com.example;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class MainProgram {

    public static void main(String[] args){

        /**
         * Utwórz klasę "DictionaryValue"
         * która posiada pola:
         * - id
         * - intKey
         * - stringKey
         * - name
         * - value
         * Do wszystkich pola nalezy utworzyć gettery i settery, oraz odpowiednie zestawy konstruktorów
         */
        DictionaryValue dictionaryValue = new DictionaryValue(1,2,"tst","nazwa slownika", "wartosc slownika");

        /**
         * Utwórz klasę "DictionaryFileReader"
         * której zadaniem będzie odczytanie danych z pliku
         * 'resources/dictionaries.csv'
         */
        DictionaryFileReader reader = new DictionaryFileReader("src/main/resources/dictionaries.csv");

        /**
         * dodaj metodę getRawFileData() która
         * zwróci w postaci Stringa wartość pliku z danymi.
         * zapoznaj się z https://www.baeldung.com/reading-file-in-java
         * rozdział 3.2 (drugi przykład korzystając z klasy FileInputStream)
         * lub rozdziały kolejne (4,5,6)
         */

        System.out.println(reader.getRawFileData());

        /**
         * Do klasy 'DictionaryFileReader' dodaj metodę
         * o nazwie 'getDictionaryValues()',
         * która zwróci w postaci listy
         * wszystkie dane słownikowe zapisane w pliku
         */


        List<DictionaryValue> dictionaryValues = reader.getDictionaryValues();

        /**
         * Utwórz klasę 'DictionaryCache'
         * która będzie zaimplementowana według wzorca Singleton (przykład poniżej)
         * i będzie przechowywać dane z pliku w pamięci procesu
         */
        DictionaryCache dictionaryCache = DictionaryCache.getInstance();
        dictionaryCache.setItems(dictionaryValues);

        /**
         * tutaj jest prosty przykład użycia wątków,
         * proszę zapoznaj się z nim.
         * Poniżej masz też zaimplementowaną
         * klasę 'ThreadExample', która w losowym odstępie czasu wypisuje na ekran liczbę od 1 do 10.
         * Poniższa metoda 'useSampleThreads' odpala 4 wątki równocześnie
         */
        useSampleThreads();

        /**
         * Napisz klasę "DictionaryCacheRefresher",
         * która będzie dziedziczyć po klasie Thread,
         * któa w metodzie 'run' co jakiś odstęp czasu (np. 1 minutę)
         * odświeży dane w Cachu i wypisze na konsoli ilość danych załadowanych z pliku.
         * Spróbuj podczas działania programu zmienić dane w pliku (np usuwając/dodając jeden wiersz)
         */

//        DictionaryCacheRefresher refresher = new DictionaryCacheRefresher();
//        refresher.start();

    }

    private static void useSampleThreads(){
        /**
         * wywołanie metody na wielu wątkach
         * wykonuje się przez wywołanie metody 'start'
         * (ta metoda jest odziedziczona po klasie Thread)
         */
        new ThreadExample().start();
        new ThreadExample().start();
        new ThreadExample().start();
        new ThreadExample().start();

    }

}

/**
 * wzorzec singleton służy do tego aby zapewnic aplikacji tylko jeden obiekt danego typu.
 *
 */
class SingletonExample{

    /**
     * nalezy 'udaremnić' tworzenie obiektów tego typu poza definicją klasy.
     * W tym celu należy użyć modyfikator private przy konstruktorze
     */
    private SingletonExample(){
    }

    /**
     * Tworzymy pole statyczne w klasie
     * -> obiekt przechowywany w tym polu będzie tzw. singletonem
     */
    private static SingletonExample instance;

    /**
     * Tworzymy statyczną metodę, która za pierwszym użyciem zainicjalizuje obiekt,
     * a potem już będzie go tylko zwracać.
     * Teoretycznie, w aplikacjach wielowątkowych, wiele wątków może w tym samym czasie
     * wywołać metodę co może spowodować utworzenie więcej niż jednego obiektu.
     * Aby się przed tym zabezpieczyć użyto słówko 'synchronized',
     * które powoduje to, że tylko jeden wątek może wywołać tę metodę,
     * a pozostałe muszą czekać, aż on zakończy jej wywoływanie
     */
    public static synchronized SingletonExample getInstance(){
        if(instance==null) instance = new SingletonExample();
        return instance;
    }

}

class ThreadExample extends Thread{

    @Override
    public void run() {
        for (int i=1;i<=10;i++){
            try {
                Thread.sleep(new Random().nextInt(10)*500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }

    }
}