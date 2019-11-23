package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*You are given an array arr[] of N integers including 0. The task is to find the smallest positive number missing from
the array.
Note: Expected solution in O(n) time using constant extra space.*/
public class SmallestMissingWholeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            String[] inputline = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputline[i]);
            }
            Missing obj = new Missing();
            Missing.missingNumber(arr, n);

        }

    }
}

class Missing {

    // function to find first positive missing number
    static int missingNumber(int[] arr, int size) {
        int i = 0, max = arr[0], temp, j = 0;
        // Eliminating all negative numbers and calculating max ;
        for (i = 0; i < size; i++) {
            if (arr[i] < 0 || arr[i] > size) {
                arr[i] = 0;
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }
        // Calculating the smallest number missing .
        for (i = 0; i < size; i++) {
            j = i;
            while (arr[j] > 0) {
                if (arr[arr[j] - 1] == -1) {
                    arr[j] = 0;
                    break;
                }
                temp = arr[arr[j] - 1];

                if (j == (arr[j] - 1)) {
                    arr[arr[j] - 1] = -1;
                } else {
                    arr[arr[j] - 1] = -1;
                    arr[j] = temp;
                }


            }
        }
        for (i = 0; i < size; i++) {
            if (arr[i] != -1) {
                break;
            }
        }
        System.out.println(i + 1);
        return 0;
    }

}
