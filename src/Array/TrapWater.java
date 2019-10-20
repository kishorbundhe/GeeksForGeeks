package Array;

import java.util.Scanner;

public class TrapWater {
    public static void main(String[] args) {
        int t;
        int i = 0;
        int[] arr;
        int size;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t-- > 0) {
            size = sc.nextInt();
            arr = new int[size];
            while (i < size) {
                arr[i] = sc.nextInt();
                i++;
            }

            catchWater(arr, size);
        }
    }

    public static int catchWater(int[] arr, int size) {
        int[] leftmax = new int[size];
        int[] rightmax = new int[size];
        int i = 0, max = 0, sum = 0, temp = 0;
        // Calculating the Right Max .

        while (size > 0) {
            if (arr[size - 1] > max) {
                max = arr[size - 1];
                rightmax[size - 1] = max;
            } else {
                rightmax[size - 1] = max;
            }
            size--;
        }
        size = rightmax.length;
        System.out.println("Right Max");
        while (i < size) {
            System.out.print(rightmax[i] + " ");
            i++;
        }
        i = 0;
        max = arr[0];
        //Calculating the Left Max

        while (i < size) {
            if (arr[i] > max) {
                max = arr[i];
                leftmax[i] = max;
            } else {
                leftmax[i] = max;
            }
            i++;
        }
        size = leftmax.length;
        i = 0;
        System.out.println("Left Max");
        while (i < size) {
            System.out.print(leftmax[i] + " ");
            i++;
        }
        // Calculating logic for sum of the water Trapped .
        i = 1;

        while (i < size - 1) {
            temp = rightmax[i] < leftmax[i] ? rightmax[i] : leftmax[i];
            temp = temp - arr[i];
            if (temp > 0) {
                sum += temp;
            }
            i++;
        }
        System.out.println("The Total water trapped = " + sum);
        return 0;
    }

}



