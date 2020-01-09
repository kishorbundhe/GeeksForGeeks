package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSorting {
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
            mergesort(arr, 0, arr.length - 1);
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void mergesort(int[] tobeSorted, int p, int r) {
        int q;
        if (p < r) {
            q = p + (r - p) / 2;
            mergesort(tobeSorted, p, q);
            mergesort(tobeSorted, q + 1, r);
            mergeprocedure(tobeSorted, p, q, r);
        }
    }

    public static void mergeprocedure(int[] tobeSorted, int p, int q, int r) {
        int leftsize, rightsize, i, j, k;
        leftsize = q - p + 1;
        rightsize = r - q;
        int[] left = new int[leftsize];
        int[] right = new int[rightsize];
        for (i = p, j = 0; i <= q; i++, j++) {
            left[j] = tobeSorted[i];
        }
        for (i = q + 1, j = 0; i <= r; i++, j++) {
            right[j] = tobeSorted[i];
        }
        //copied now will merge
        i = 0;
        j = 0;
        k = p;
        while (i < leftsize && j < rightsize) {
            if (left[i] <= right[j]) {
                tobeSorted[k++] = left[i++];
                    /*k++;
                    i++;*/
            } else if (right[j] < left[i]) {
                tobeSorted[k++] = right[j++];
                   /* k++;
                    j++;*/
            }
        }
        while (i < leftsize) {
            tobeSorted[k++] = left[i++];
                /*k++;
                i++;*/
        }
        while (j < rightsize) {
            tobeSorted[k++] = right[j++];
                /*k++;
                j++;*/
        }

    }
}
