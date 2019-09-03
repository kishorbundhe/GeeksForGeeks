/* package codechef , EIDI gift problem*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class EID2 {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = 6;
            int arr[] = new int[n];
            for (int i = 0; i < 6; i++) {
                arr[i] = input.nextInt();
            }

            System.out.println(eidi(arr));
        }
    }

    public static String eidi(int arr[]) {
        int flag = 1, i;
        for (i = 0; i < 3; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = temp;
                temp = arr[i + 1 + 3];
                arr[i + 1 + 3] = arr[i + 3];
                arr[i + 3] = temp;
            }
        }
        /*Logic to sort */
//        for (i = 0; i < 6; i++) {
//            System.out.println(arr[i]);
//        }
        /* logic*/

        /* Logic to check eidi is fair or not
         */
        if ((arr[5] > arr[4]) && (arr[4] > arr[3]))
            return "FAIR";
        else return "NOT FAIR";
    }
}

