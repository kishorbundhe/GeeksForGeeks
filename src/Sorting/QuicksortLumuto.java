package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QuicksortLumuto {
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
            quicksortlumuto(arr, 0, arr.length - 1);
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void quicksortlumuto(int[] arr, int l, int h) {

        if (l < h) {
            int q;
            q = partition(arr, l, h);
            quicksortlumuto(arr, l, q - 1);
            quicksortlumuto(arr, q + 1, h);
        }
    }

    private static int partition(int[] arr, int l, int h) {
        int i = -1, j, pivot;
        pivot = arr[h];
        j = l;
        while (j < h) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            j++;
        }
        i++;
        int temp = arr[j];
        arr[i] = arr[j];
        arr[j] = temp;
        return i;
    }

}
