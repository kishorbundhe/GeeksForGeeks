package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Given a binary sorted non-increasing array arr of size N.
 *  You need to print the count of 1's in the binary array.*/
public class Countbinary {
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

            countOnes(arr, n);
        }
    }

    private static void countOnes(int[] arr, int n) {
        int mid, low, high;
        high = n - 1;
        low = 0;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] > arr[mid + 1]) {
                System.out.println(mid + 1);
            } else if (arr[mid] == 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(0);

    }
}
