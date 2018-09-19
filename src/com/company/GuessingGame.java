package com.company;

import java.io.Console;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        int num;
        int j = 0;
        Random rand = new Random();
        num = rand.nextInt(10) + 1;


        while (j <= 10) {
            j++;
            System.out.println("I have chosen a number between 1 and 10. Try to guess it.");

            Scanner scan = new Scanner(System.in);
            int i = scan.nextInt();
            scan.nextLine();
            System.out.println("Your guess:" + i);
            if (num == i) {
            } else {
                System.out.println("That's is incorrect. Guess again");
            }
        }
    }
}

