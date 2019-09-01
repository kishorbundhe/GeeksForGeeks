/* package codechef , EIDI gift problem*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class EID2 {

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = 6;
            int arr[] = new int[n];
            for (int i = 0; i < 6; i++) {
                arr[i] = Integer.parseInt(br.readLine().trim());
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
        for (i = 0; i < 6; i++) {
            System.out.println(arr[i]);
        }
        /* logic*/

        for (i = 2; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                if (arr[i + 3] > arr[i - 1 + 3]) {
                    continue;
                } else {
                    flag = 0;
                    break;
                }
            }
            if (arr[i] == arr[i - 1]) {
                if (arr[i + 3] == arr[i - 1 + 3]) {
                    continue;
                } else {
                    flag = 0;
                    break;
                }

            }
        }


        if (flag == 1) return "FAIR";
        else return "NOT FAIR";
    }
}

