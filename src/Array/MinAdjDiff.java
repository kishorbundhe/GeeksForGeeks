package Array;
/*Given an array Arr of N integers arranged in a circular fashion. Your task is to
 find the minimum absolute difference between adjacent elements.*/

import java.util.Scanner;

public class MinAdjDiff {
    public static void main(String[] args) {
        System.out.println("Size of the array");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int i = 0;
        int[] arr = new int[size];
        System.out.println("Enter the value for the array");
        while (i < size) {
            arr[i] = sc.nextInt();
            i++;
        }
        minAdjDiff(arr, size);
    }

    public static void minAdjDiff(int[] arr, int size) {
        int i = 0, result, min = Integer.MAX_VALUE;
        while (i < size - 1) {
            result = arr[i] - arr[i + 1];
            result = result >= 0 ? result : -result;
            if (min > result) {
                min = result;
            }
            i++;
        }
        result = arr[i] - arr[(i + 1) % size];
        result = result >= 0 ? result : -result;
        if (min > result) {
            min = result;
        }
        System.out.println("min=" + min);

    }
}
