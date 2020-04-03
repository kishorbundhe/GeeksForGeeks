package Hashing;

import java.util.HashMap;
import java.util.Scanner;

/* Given an array arr[] of positive integers.
Find the length of the longest sub-sequence such that elements
in the subsequence are consecutive integers, the consecutive numbers can be in any order.
*/
public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            System.out.println(findLongestConseqSubseq(a, n));
            t--;
        }
    }

    static int findLongestConseqSubseq(int[] arr, int n) {
        int i, temp, count = 0, longestSublength = 0;
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (i = 0; i < n; i++) {
            temp = arr[i];
            if (frequencyMap.containsKey(temp)) {
                frequencyMap.put(temp, frequencyMap.get(temp) + 1);
            } else {
                frequencyMap.put(temp, 1);
            }
        }

        for (i = 0; i < n; i++) {
            temp = arr[i] - 1;
            count = 0;
            if (!frequencyMap.containsKey(temp)) {
                while (frequencyMap.containsKey(++temp)) {
                    count++;
                }
                longestSublength = Math.max(longestSublength, count);
            }
        }
        return longestSublength;
    }
}
