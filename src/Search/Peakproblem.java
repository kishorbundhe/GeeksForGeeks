package Search;
/*Given an array A of N integers. The task is to find a peak element in it.
An array element is peak if it is not smaller than its neighbours. For corner elements, we need to consider only one neighbour.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Peakproblem {
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
            /*findpeak(arr, n);*/
            int x = Integer.parseInt(br.readLine().trim());
            floor(arr, n, x);
        }
    }


    private static void floor(int[] arr, int size, int x) {
        /*Given a sorted array arr[] of size N without duplicates, and given a value x. Find the floor of x in given array.
        Floor of x is defined as the largest element K in arr[] such that K is smaller than or equal to x.*/
        int mid, high, low;
        low = 0;
        mid = 0;
        high = size - 1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] <= x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(low - 1);


    }

    private static void findpeak(int[] arr, int size) {
        int mid, high, low;
        low = 0;
        high = size - 1;
        if (size == 1) {
            System.out.println(0);
            return;
        } else if (arr[0] >= arr[1]) {
            System.out.println(0);
            return;
        } else if (arr[high] >= arr[high - 1]) {
            System.out.println(high);
            return;
        }

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (mid == 0 || mid == size - 1) {
                break;
            } else if (arr[mid] >= arr[mid - 1] && arr[mid] >= arr[mid + 1]) {
                System.out.println(mid);
                return;
            } else if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else if (arr[mid] > arr[mid - 1]) {
                high = mid - 1;
            }
        }

    }
    }

