package Sorting;
/*Given an array arr[] consisting of N positive integers. The task is to find inversion count of array.

Inversion Count : For an array, inversion count indicates how far (or close) the array is from being sorted.
If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum.
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.*/

import java.util.Scanner;

public class InversionArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while (t-- > 0) {
            long n = sc.nextLong();
            long[] arr = new long[(int) n];

            for (long i = 0; i < n; i++)
                arr[(int) i] = sc.nextLong();

            System.out.println(new Inversion_of_Array().inversionCount(arr, n));

        }
    }

}

class Inversion_of_Array {
    // Function to count the number of inversions
    // arr[]: input array
    // n: size of array

    static long inversionCount(long[] arr, long n) {
        long noOfInversion = countInversion(arr, 0, (int) (n - 1));
        return noOfInversion;
    }

    private static long countInversion(long[] arr, int l, int h) {
        long noOfInversion = 0;
        int q;
        if (l < h) {
            q = l + (h - l) / 2;
            noOfInversion += countInversion(arr, l, q);
            noOfInversion += countInversion(arr, q + 1, h);
            noOfInversion += count(arr, l, q, h);
        }
        return noOfInversion;
    }

    private static long count(long[] arr, int l, int q, int h) {
        long noOfInversion = 0;
        int leftsize, rightsize, i, j, k;
        leftsize = q - l + 1;
        rightsize = h - q;
        long[] left = new long[leftsize];
        long[] right = new long[rightsize];
        for (i = l, j = 0; i <= q; i++, j++) {
            left[j] = arr[i];
        }
        for (i = q + 1, j = 0; i <= h; i++, j++) {
            right[j] = arr[i];
        }
        //copied now will merge
        i = 0;
        j = 0;
        k = l;
        while (i < leftsize && j < rightsize) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];

            } else if (right[j] < left[i]) {
                arr[k++] = right[j++];
                noOfInversion += leftsize - i;
            }
        }
        while (i < leftsize) {
            arr[k++] = left[i++];

        }
        while (j < rightsize) {
            arr[k++] = right[j++];


        }
        return noOfInversion;
    }


}




/*// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{

}
// } Driver Code Ends
//User function Template for Java
class Inversion_of_Array
{
    // Fucntion to count the number of inversions
    // arr[]: input array
    // n: size of array
    static long inversionCount(long arr[], long n)
    {
        // add your code here
    }
}*/
