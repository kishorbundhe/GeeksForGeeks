package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Given an array arr of N integers.
Find the contiguous sub-array with maximum sum.*/
public class KadaneAlgo {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }
            maxSubArray(arr, n);
        }
    }

    public static void maxSubArray(int[] arr, int n) {
        int currentMax, globalMax;
        currentMax = arr[n - 1];
        globalMax = arr[n - 1];
        int i = 0;
        while (i != (n - 1)) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            globalMax = Math.max(currentMax, globalMax);
            i = (i + 1) % n;
        }
        System.out.println("GlobalMax =" + globalMax);
    }
}
