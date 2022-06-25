package com.pjatk.pesel.model;

public class PeselValidator {
    public static boolean isValid(String pesel){

        /* Algorytm sprawdzający czy nr pesel jest prawidłowym numerem PESEL
        (sprawdzić poprzez wyrażenie regularne oraz sumę kontrolną) */

        if(isValidRegex(pesel) && isSum(pesel)){
            return true;
        }

        return false;
    }

    private static boolean isValidRegex(String pesel){
        return pesel.matches("^\\d{11}$");
    }

    private static boolean isSum(String pesel){
        int[] numbers = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};

        //pomnoz cyfry peselu
        for(int i = 0; i <= 9; i++){
            numbers[i] = numbers[i] * Integer.valueOf(pesel.substring(i, i+1));
            if(numbers[i] >= 10){
                numbers[i] = numbers[i]%10;
            }
        }

        int sum = 0;
        //dodaj wartosci
        for(int i = 0; i < 10; i++){
            sum += numbers[i];
        }

        //wez jednosci z sumy
        if(sum >= 10){
            sum = sum%10;
        }

        if(10 - sum == Integer.valueOf(pesel.substring(10,11))){
            return true;
        } else {
            return false;
        }
    }
}
