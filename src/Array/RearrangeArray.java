package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Given an array arr[] of size N where every element is in range from 0 to n-1.
 Rearrange the given array so that arr[i] becomes arr[arr[i]]. This should be done with O(1) extra space.
 */
public class RearrangeArray {
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
            rearrange(arr, n);
        }
    }

    private static void rearrange(int[] arr, int n) {
        int i;
        for (i = 0; i < n; i++) {
            arr[i] += (arr[arr[i]] % n) * n;
        }
        for (int y :
                arr) {
            System.out.print(y / n + " ");
        }
    }
}