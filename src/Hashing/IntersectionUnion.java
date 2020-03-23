package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

/* Union, Intersection, also whether two array are equal or not*/
/*Given two arrays A and B of equal size N, the task is to find if given arrays are equal or not. Two arrays are said to be equal if both of them contain same set of elements, arrangements (or permutation) of elements may be different though.
Note : If there are repetitions, then counts of repeated elements must also be same for two array to be equal.*/
public class IntersectionUnion {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] str, str1;
            str = read.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            long[] arr = new long[n];
            long[] arr1 = new long[m];

            str = read.readLine().split(" ");
            str1 = read.readLine().split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Long.parseLong(str[i]);
            for (int i = 0; i < m; i++)
                arr1[i] = Long.parseLong(str1[i]);
          /*  System.out.println(intersection(arr, arr1, n, m));
            System.out.println(union(arr, arr1, n, m));*/
            System.out.println(equal(arr, arr1, n, m));
        }
    }

    private static boolean equal(long[] arr, long[] arr1, int n, int m) {
        int i;
        HashMap<Long, Integer> frequencyMap = new HashMap<>();
        // traversing the array a
        for (i = 0; i < n; i++) {
            if (!frequencyMap.containsKey(arr[i])) {
                frequencyMap.put(arr[i], 1);
            } else {
                frequencyMap.put(arr[i], frequencyMap.get(arr[i]) + 1);
            }
        }
        // while traversing the array b
        for (i = 0; i < m; i++) {
            if (!frequencyMap.containsKey(arr1[i])) {
                return false;
            } else {
                frequencyMap.put(arr1[i], frequencyMap.get(arr1[i]) - 1);
                if (frequencyMap.get(arr1[i]) == 0) {
                    frequencyMap.remove(arr1[i]);
                }
            }
        }
        return frequencyMap.size() == 0;
    }

    private static int union(int[] a, int[] b, int n, int m) {
        int i = 0, j = 0, count = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for (; i < n; i++) {
            set.add(a[i]);
        }
        for (; j < m; j++) {
            set.add(b[j]);
        }

        return set.size();
    }

    private static int intersection(int[] a, int[] b, int n, int m) {
        int i = 0, j = 0, count = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for (; i < n; i++) {
            set.add(a[i]);
        }
        for (; j < m; j++) {
            if (set.contains(b[j])) {
                set.remove(b[j]);
                count++;
            }
        }

        return count;
    }


}
