package com.pjatk.hello;

import java.util.Scanner;

public class HelloApplication {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        String name = input.nextLine();

        System.out.println("Hello World, " + name);
    }
}
