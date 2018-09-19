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
            System.out.println("I have chosen a number. Try to guess it.");

            Scanner scan = new Scanner(System.in);
            int i = scan.nextInt();
            scan.nextLine();
            System.out.println("Your guess:" + i);
            if(i <=1)
            {
                System.out.println("The number you entered is very low please, try again");
            }
            else if( i >=18) 
            {
                System.out.println("The number you entered is very high, try again");
            }
            else if(num == i)
            {
                System.out.println("That's is Correct. You are a good guesser");
            }else
            {
                System.out.println("That is incorrect. Guess again");
            }
        }
    }
}

