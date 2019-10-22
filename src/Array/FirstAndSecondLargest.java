package Array;

import java.util.Scanner;

/*Given an array arr[] of size N of positive integers which may have duplicates.
The task is to find maximum and second maximum from the array,
which must be distinct. If no second max exists, then second max will be -1.*/
public class FirstAndSecondLargest {
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

        ArrayMax obj = new ArrayMax();
        ArrayMax.largestAndSecondLargest(size, arr);

    }
}

class ArrayMax {
    // Function to find largest and second largest element in the array
    static void largestAndSecondLargest(int sizeOfArray, int[] arr) {

        int max = -1;
        int max2 = -1;
        for (int i = 0; i < sizeOfArray; i++) {
            if (arr[i] > max) {
                max2 = max;
                max = arr[i];
            }
            if (max2 < arr[i] && arr[i] < max) {
                max2 = arr[i];
            }
        }
        System.out.println("max =" + max + "max2=" + max2);
    }

}

