package Strings;

import java.util.Scanner;

/*
Given a number 'N'. The task is to find the Nth number whose each digit is a prime number i.e 2, 3, 5, 7.
In other words you have to find nth number of this sequence : 2, 3, 5, 7, 22, 23 ,.. and so on.*/
public class NthNumberPrimeDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int number = sc.nextInt();
            System.out.println(findNthNumberInSeries(number));
        }
    }

    private static String findNthNumberInSeries(int number) {
        String[] mapping = new String[]{"", "2", "3", "5", "7"};
        StringBuilder temp = new StringBuilder();
        int quotient = 0, remainder;
        do {
            if (number % 4 == 0) {
                quotient = (number / 4) - 1;
                remainder = 4;
                temp.append(mapping[remainder]);
                number = quotient;
                continue;
            }
            quotient = number / 4;
            remainder = number % 4;
            temp.append(mapping[remainder]);
            number = quotient;
        } while (quotient >= 4);
        temp.append(mapping[quotient]);

        return temp.reverse().toString();
    }
}