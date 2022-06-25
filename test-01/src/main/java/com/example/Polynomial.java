package com.example;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Polynomial {
    private int[] coeficients;

    public Polynomial(int[] x){
        this.coeficients = x;
    }

    public int[] getCoeficients() {
        return coeficients;
    }

    public void setCoeficients(int[] coeficients) {
        this.coeficients = coeficients;
    }

    public int coeficientAt(int a){
        return coeficients[a];
    }

    public Polynomial add(Polynomial w){
        //co jest dluzsze
        int len;
        if(coeficients.length >= w.coeficients.length){
            len = coeficients.length;
        } else{
            len = w.coeficients.length;
        }
        Polynomial sum = new Polynomial(new int []{0, 0, 0});
        for(int i = 0; i < len; i++){
            int a = 0;
            int b = 0;
            if(i < coeficients.length){
                a = coeficients[i];
            }
            if(i < w.coeficients.length){
                b = w.coeficients[i];
            }
            sum.coeficients[i] = a + b;
        }
        return sum;
    }

    @Override
    public String toString() {
        return coeficients[2] + "x^2+" + coeficients[1] + "x+" + coeficients[0];
    }

    public boolean equals(Polynomial p) {
        boolean areEqual = true;

        if(coeficients.length != p.coeficients.length){
            areEqual = false;
        }else{
            for(int i = 0; i < coeficients.length; i++){
                if(!(coeficients[i] == p.coeficients[i])){
                    areEqual = false;
                }
            }
        }

        return areEqual;
    }


}
