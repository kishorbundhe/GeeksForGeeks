
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

public class PossibleWords {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();


        while (t-- > 0) {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed

            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            new PhoneDigit().possibleWords(arr, n);
            System.out.println();

        }
    }
}


/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
class PhoneDigit {
    static String[] key = {null, null, "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    static void possibleWords(int a[], int N) {
        String str = key[a[0]];
        for (int i = 0; i < key[a[0]].length(); i++) {

            printPatterns(" " + str.charAt(i), 0, a);
        }

    }

    static void printPatterns(String Current, int index, int a[]) {
        String temp = "";
        if (index == a.length - 1) {
            System.out.print(Current + "");
            return;
        }
        temp = key[a[index + 1]];
        for (int i = 0; i < temp.length(); i++) {
            printPatterns(Current + temp.charAt(i), index + 1, a);
        }
    }

}
