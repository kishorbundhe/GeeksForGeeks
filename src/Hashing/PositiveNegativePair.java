package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/*Given an array arr[] of N positive and negative integer pairs, may not be in sorted order.
The task is to pair the positive and negative element in such a way that a positive element is paired with
a negative element of same absolute value. If a pair element is not present for an element, then ignore it.
The output should contain all pairs in increasing order of absolute values.
To print a pair, positive value should be printed before its corresponding negative value.
Note: The elements in array are distinct.*/
public class PositiveNegativePair {
    public static void main(String[] args) throws IOException {
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            posNeg(arr, n);
        }
    }

    private static void posNeg(int[] arr, int n) {
        HashSet<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        int absValue;
        for (int i = 0; i < n; i++) {
            absValue = Math.abs(arr[i]);
            if (set.contains(absValue)) {
                list.add(absValue);
            } else {
                set.add(absValue);
            }
        }
        if (list.isEmpty()) {
            System.out.println(0);
            return;
        }
        Collections.sort(list);
        for (int x : list) {
            sb.append(x + " " + (-x) + " ");
        }
        System.out.println(sb.toString().trim());
    }
}
