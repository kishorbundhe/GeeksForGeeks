package Array;

import java.util.Scanner;

import static Array.CreatePrefixArray.prefixArray;

/* Check if the given Array can be divided in equal three parts with equal sum
 *  Example [5,2,6,1,1,1,5] and output=yes,{5,2},{6,1},{1,1,5}
 * Example[1,2,4] output=No
 * */
public class EqualThreepartsOfArray {
    public static void main(String[] args) {
        System.out.println("Size of the array");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int i = 0;
        int[] arr = new int[size];
        int[] prefixarr = new int[size];
        System.out.println("Enter the value for the array");
        while (i < size) {
            arr[i] = sc.nextInt();
            i++;
        }
        prefixarr = prefixArray(arr);
        EqualThreeSum(arr, prefixarr);
    }

    public static void EqualThreeSum(int[] arr, int[] prefixArray) {
        int size = arr.length, start = 0, end = 0;
        if (prefixArray[size - 1] % 3 == 0) {
            int temp = prefixArray[size - 1] / 3;
            for (int i = 0; i < size; i++) {
                if (prefixArray[i] % temp == 0) {
                    end = i;
                    System.out.println("Yes from index [ " + start + "," + end + " ]");
                    start = end + 1;
                }
            }
        } else {
            System.out.println("No");

        }

    }

}
