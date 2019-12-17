package Search;
/*Given an array A of N elements. Find the majority element in the array.
A majority element in an array A of size N is an element that appears more than N/2 times in the array.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MajorityElement {
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
            findMajority(arr, n);
        }
    }

    public static void findMajority(int[] arr, int size) {
        int candidate, count = 0, i;
        candidate = arr[0];
        count++;
        for (i = 1; i < size; i++) {
            if (arr[i] == candidate) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                candidate = arr[i];
                count++;
            }

        }
        count = 0;
        for (i = 0; i < size; i++) {
            if (arr[i] == candidate) {
                count++;
            }
        }

        if (count > (size / 2)) {
            System.out.println("Majority found =" + candidate);
        } else {
            System.out.println(" No Majority found ");
        }
    }
}
