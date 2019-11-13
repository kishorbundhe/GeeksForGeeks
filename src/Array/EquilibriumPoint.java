package Array;
/* Given an array A of N positive numbers. The task is to find the position where equilibrium first occurs in the array.
 Equilibrium position in an array is a position such that the sum of elements before it is equal to the sum of elements after it.*/
import java.util.Scanner;

import static Array.CreatePrefixArray.prefixArray;

/* Point where the Sum of the left side element and right side element have the same sum */
public class EquilibriumPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i;
        int t = sc.nextInt();
        while (t-- > 0) {
            i = 0;
            int size = sc.nextInt();
            int[] arr = new int[size];
            while (i < size) {
                arr[i] = sc.nextInt();
                i++;
            }
            firstEquillibriumPoint(arr);
            /* System.out.println(" Enter the index to check Equilibrium Point ");
        int point = sc.nextInt();
        equilibriumPoint(arr, point);*/
        }
    }


    public static void equilibriumPoint(int[] array, int index) {
        int size = array.length;
        int[] temp = prefixArray(array);
        if (index < size && index != 0 && index != size - 1) {
            if (temp[index - 1] - (temp[size - 1] - temp[index]) == 0) {
                System.out.println(" Yes it is Equilibrium Point ");
            } else {
                System.out.println(" No, It is not a Equilibrium Point ");
            }

        } else if (index == 0 && index == size - 1) {
            System.out.println("End Points Cannot be the Equilibrium Point");
        }
    }

    public static void firstEquillibriumPoint(int[] array) {
        int i = 0, size;
        size = array.length;
        if (size == 1) {
            System.out.print(1);
        } else if (size == 2) {
            System.out.print(-1);
        } else {
            int[] temp = prefixArray(array);
            for (i = 1; i < size - 1; i++) {
                if (temp[i - 1] - (temp[size - 1] - temp[i]) == 0) {
                    break;
                }
            }
            if (i < size - 1) {
                System.out.print(i);
            } else {
                System.out.print(-1);
            }
        }

    }

}
