package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QuicksortHoare {
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
            quicksorthoare(arr, 0, arr.length - 1);
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void quicksorthoare(int[] arr, int l, int h) {
        if (l < h) {
            int q;
            q = partition(arr, l, h);
            quicksorthoare(arr, l, q);
            quicksorthoare(arr, q + 1, h);
        }

    }

    private static int partition(int[] arr, int l, int h) {
        int i, j, pivot;
        i = l;
        j = h;
        pivot = arr[l];
        while (true) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (j > i) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } else {
                return j;
            }

        }
    }
}
