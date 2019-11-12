package Array;
/*Given an array A[] of N positive integers which can contain integers from 1 to N where elements can be repeated or can be absent from the array. Your task is to count frequency of all elements from 1 to N.

Note: Expected time complexity is O(n) with O(1) extra space.*/

import java.util.Scanner;

public class FrequencyOfElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0, t = sc.nextInt();
        while (t-- > 0) {
            System.out.println("Enter the size of the Array");
            int size = sc.nextInt();
            int[] arr = new int[size];
            System.out.println("Enter the value for the array");
            while (i < size) {
                arr[i] = sc.nextInt();
                i++;
            }
            printFrequency(arr, size);
        }
    }

    public static void printFrequency(int[] arr, int n) {
        int i = 0;

        for (i = 0; i < n; i++) {
            arr[(arr[i] % (n + 1)) - 1] += (n + 1);
        }
        for (i = 0; i < n; i++) {
            System.out.print(arr[i] / (n + 1) + " ");
        }

    }

}
