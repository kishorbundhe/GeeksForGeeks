package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * Given an array A[] of N elements.
 *  The task is to complete the function which returns true
 * if triplets exists in array A whose sum is zero else returns false.
 * */
public class FindTriplets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            String[] string = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(string[i]);
            }
            findTriplet(arr, n);
            System.out.println(Arrays.toString(arr));

        }
    }


    private static void findTriplet(int[] arr, int n) {
        Arrays.sort(arr);
        for (int i = 0; i < n - 2; i++) {
            if (isPair(arr, i + 1, n - 1, 0 - arr[i])) {
                System.out.println("TRUE");
                return;
            }

        }
        System.out.println("FALSE");

    }

    private static boolean isPair(int[] arr, int l, int h, int sum) {
        while (l < h) {
            if (arr[l] + arr[h] == sum) {
                return true;
            } else if (arr[l] + arr[h] > sum) {
                h--;
            } else {
                l++;
            }
        }
        return false;
    }
}
