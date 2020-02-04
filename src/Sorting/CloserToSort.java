package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*Given an array arr[] of N integers which is closer sorted (defined below) and an element x.
        The task is to find index of the element x if it is present. If not present, then print -1.*/
public class CloserToSort {
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
            long X = Long.parseLong(br.readLine().trim());
            System.out.println(closerSort(arr, n, X));

        }
    }

    private static int closerSort(int[] arr, int n, long x) {
        int l, h, mid;
        l = 0;
        h = n - 1;
        // Corner cases done
        if (arr[0] == x) {
            return 0;
        } else if (arr[h] == x) {
            return h;
        }
        l = 1;
        h = h - 1;
        while (l < h) {
            mid = l + (h - l) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid + 1] == x) {
                return mid + 1;
            } else if (arr[mid - 1] == x) {
                return mid - 1;
            } else if (arr[mid] > x) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
