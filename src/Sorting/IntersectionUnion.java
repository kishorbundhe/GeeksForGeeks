package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Sorted Arrays Intersection and Union */
public class IntersectionUnion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            int[] arr1 = new int[n];
            int[] arr2 = new int[m];
            String[] string1 = br.readLine().split(" ");
            String[] string2 = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(string1[i]);
            }
            // for  second array
            for (int i = 0; i < m; i++) {
                arr2[i] = Integer.parseInt(string2[i]);
            }
            findUnion(arr1, arr2, n, m);
            findIntersection(arr1, arr2, n, m);
            /* cyclesorting(arr);*/
            /*insertionSort(arr, n);*/

        }
    }

    private static void findIntersection(int[] arr1, int[] arr2, int n, int m) {
        StringBuilder finallist = new StringBuilder();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (i > 0 && arr1[i] == arr1[i - 1]) {
                i++;
                continue;
            } else if (j > 0 && arr2[j] == arr2[j - 1]) {
                j++;
                continue;
            }
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] == arr2[j]) {
                finallist.append(arr1[i]);
                i++;
                j++;
            } else {
                j++;
            }
        }
        System.out.println(finallist);

    }

    private static void findUnion(int[] arr1, int[] arr2, int n, int m) {
        StringBuilder finallist = new StringBuilder();
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (i > 0 && arr1[i] == arr1[i - 1]) {
                i++;
                continue;
            } else if (j > 0 && arr2[j] == arr2[j - 1]) {
                j++;
                continue;
            }
            if (arr1[i] < arr2[j]) {
                finallist.append(arr1[i]);
                i++;
            } else if (arr1[i] == arr2[j]) {
                finallist.append(arr1[i]);
                i++;
                j++;
            } else {
                finallist.append(arr2[j]);
                j++;
            }
        }
        while (i < n) {
            if (i == 0 || arr1[i] != arr1[i - 1])
                finallist.append(arr1[i]);
            i++;
        }
        while (j < m) {
            if (j == 0 || arr2[j] != arr2[j - 1])
                finallist.append(arr2[j]);
            j++;
        }
        System.out.println(finallist);
    }

    /*static void insertionSort(int arr[], int n) {
        int i;
        for (i = 1; i < n; i++)
            insert(arr, i);
    }

    static void insert(int arr[], int j) {
        int temp, key, i = j - 1;
        key = arr[j];
        while (i >= 0) {
            if (arr[i] > key) {
                arr[i + 1] = arr[i];
            } else {
                break;
            }
            i--;
        }
        arr[i + 1] = key;

    }*/

    private static void cyclesorting(int[] arr) {

    }
}
