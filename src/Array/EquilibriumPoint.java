package Array;

import java.util.Scanner;

import static Array.CreatePrefixArray.prefixArray;

/* Point where the Sum of the left side element and right side element have the same sum */
public class EquilibriumPoint {
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
        System.out.println(" Enter the index to check Equilibrium Point ");
        int point = sc.nextInt();
        equilibriumPoint(arr, point);
    }


    public static void equilibriumPoint(int[] array, int index) {

        int[] temp = prefixArray(array);
        if (index < array.length && index != 0 && index != array.length - 1) {
            if (temp[index - 1] - (temp[array.length - 1] - temp[index]) == 0) {
                System.out.println(" Yes it is Equilibrium Point ");
            } else {
                System.out.println(" No, It is not a Equilibrium Point ");
            }

        } else if (index == 0 && index == array.length - 1) {
            System.out.println("End Points Cannot be the Equilibrium Point");
        }
    }
}
