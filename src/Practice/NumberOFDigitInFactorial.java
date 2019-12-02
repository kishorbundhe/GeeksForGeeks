package Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.*;

public class NumberOFDigitInFactorial {
    public static void main(String[] args) {
        System.out.println("Please enter the value of n");
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        int B = input.nextInt();
        int C = input.nextInt();
        NthTerm(A, B, C);
        //numberOfDigit(n);
    }

    public static void numberOfDigit(double N) {
        int numberOfDigit;
        double sum = 0;
        System.out.println("hkdallll" + Math.log10(2.0));
        for (double i = 2.0; i <= N; i++) {
            System.out.println(Math.log10(i));
            sum += (log10(N));
        }
        System.out.println(sum);
        numberOfDigit = (int) floor(sum) + 1;
        System.out.println(numberOfDigit);
    }

    public static void NthTerm(int A, int B, int N) {

        double r = (double) B / A;
        System.out.println(A + "------" + B + "---------");
        System.out.println(pow(r, N));
        // double NthTerm=*pow(r,N-1);
        // System.out.println(NthTerm);
    }
}
