package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*Given a string S consisting of lowercase latin letters, arrange all its letters in lexographical
order using Counting Sort.*/
public class CountSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            char[] arr = new char[n];
            String string = br.readLine();
            for (int i = 0; i < n; i++) {
                arr[i] = string.charAt(i);
            }
            Countsort(arr, n);
            System.out.println(Arrays.toString(arr));

        }
    }

    private static void Countsort(char[] arr, int n) {
        int i;
        int[] count = new int[26];
        char[] output = new char[n];
        for (i = 0; i < 26; i++) {
            count[i] = 0;
        }
        for (i = 0; i < n; i++) {
            count[arr[i] - 'a']++;
        }
        System.out.println(Arrays.toString(count));
        for (i = 1; i < 26; i++) {
            count[i] += count[i - 1];
        }
        System.out.println(Arrays.toString(count));

        for (i = n - 1; i >= 0; i--) {
            output[count[arr[i] - 'a'] - 1] = arr[i];
            count[arr[i] - 'a']--;
        }
        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }

    }
}
