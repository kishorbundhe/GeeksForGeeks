package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t, max = 0;
        t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            String[] string = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(string[i]);
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            radixSort(arr, n, max);
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void radixSort(int[] arr, int n, int max) {
        int noOfDigit, exp = 1;
        noOfDigit = (int) Math.log10(max) + 1;

        for (int i = 0; i < noOfDigit; i++) {
            countSort(arr, n, exp);
            exp *= 10;
        }

    }

    private static void countSort(int[] arr, int n, int exp) {
        int[] count, output;
        int i;

        count = new int[10];
        output = new int[n];
        for (i = 0; i < 10; i++) {
            count[i] = 0;
        }
        for (i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        int temp, pos;
        for (i = n - 1; i >= 0; i--) {
            temp = (arr[i] / exp) % 10;
            pos = count[temp];
            output[pos - 1] = arr[i];
            count[temp]--;

        }
        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
}
