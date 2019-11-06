package Array;

import java.util.Scanner;

/*
Given a sorted array arr[] of distinct integers. Sort the array into a wave-like array and return it. In other words,
arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5..... (considering the increasing lexicographical order).
*/
public class WaveArray {
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
            convertToWaveArray(arr, size);
        }

    }

    public static void convertToWaveArray(int[] arr, int size) {
        int numberOfTime, i = 0, temp;
        numberOfTime = size / 2;
        while (numberOfTime > 0) {
            temp = arr[i + 1];
            arr[i + 1] = arr[i];
            arr[i] = temp;
            i = i + 2;
            numberOfTime--;
        }
        for (int a :
                arr) {
            System.out.print(a + " ");
        }
    }

}
