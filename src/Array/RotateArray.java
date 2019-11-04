package Array;

import PublicFunctions.PublicFunctions;

import java.util.Scanner;

/*Given an unsorted array arr[] of size N, rotate it by D elements (counter-clockwise). */
public class RotateArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        System.out.println("Enter the size of the Array");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the value for the array");
        while (i < size) {
            arr[i] = sc.nextInt();
            i++;
        }
        System.out.println("Enter the no of time to rotate counter clockwise");
        int d = sc.nextInt();
        rotateArray(arr, size, d);
    }

    public static void rotateArray(int[] arr, int size, int d) {
        if (d > size) {
            return;
        }
        int store, gcd, current, noOfTimeInnerLoop, noOfTimeOuterLoop, temp, outerPointer;
        current = size - 1;
        gcd = PublicFunctions.gcd(size, d);
        outerPointer = size - gcd;
        noOfTimeOuterLoop = gcd;
        while (noOfTimeOuterLoop > 0) {
            store = arr[outerPointer];
            current = outerPointer;
            noOfTimeInnerLoop = (size / gcd);
            while (noOfTimeInnerLoop > 0) {
                temp = store;
                store = arr[(current - d + size) % size];
                arr[(current - d + size) % size] = temp;
                current = (current - d + size) % size;
                noOfTimeInnerLoop--;
            }
            outerPointer++;
            noOfTimeOuterLoop--;
        }
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}
