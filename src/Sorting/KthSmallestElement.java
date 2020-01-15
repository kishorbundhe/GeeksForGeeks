package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KthSmallestElement {
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
            System.out.println(" Enter the k value ");
            int k = Integer.parseInt(br.readLine().trim());
            kthsmallest(arr, 0, arr.length - 1, k);
            System.out.println(Arrays.toString(arr));

        }

    }// using lumuto partition algorithm

    private static void kthsmallest(int[] arr, int l, int h, int k) {
        /*if (p <= r) {
            int q = partition(arr, p, r);
            if (q == k - 1) {
                System.out.println(" The Kth smallest element is = " + arr[q]);
                return;
            }
            kthsmallest(arr, p, q - 1, k);
            kthsmallest(arr, q + 1, r, k);
        }*/
        // Improvement
        int q;
        while (l <= h) {
            q = partition(arr, l, h);
            if (q == k - 1) {
                System.out.println(" The Kth smallest element is = " + arr[q]);
                return;
            } else if (q < (k - 1)) {
                l = q + 1;
            } else {
                h = q - 1;
            }
        }
    }

    private static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p - 1;
        int j = p;
        while (j < r) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
            j++;
        }
        i++;
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        return i;

    }
}