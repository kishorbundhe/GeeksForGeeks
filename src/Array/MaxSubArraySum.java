package Array;

import java.util.Scanner;

/* By Kishor Bundhe*/
/* Find the subarray having length=k with max and min of the sum with */
public class MaxSubArraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        System.out.println("What is the size of the SubArray of k ");
        int k = sc.nextInt();
        System.out.println("Enter the size of the Array");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the value for the array");
        while (i < size) {
            arr[i] = sc.nextInt();
            i++;
        }
      /*  maxSubArray(arr, k);
        minSubArray(arr, k);*/
        System.out.println("Enter the sum to find");
        int sumToFind = sc.nextInt();
        System.out.println("Is Sum Present " + givenSum(arr, sumToFind));
    }

    /*This function calculates the maximun sum of the subArray */
    public static void maxSubArray(int[] arr, int k) {
        int size, i = 0, sum = 0, temp = 0, start, end;
        size = arr.length;
        while (i < k) {
            sum += arr[i];
            i++;
        }
        start = 0;
        end = k - 1;
        for (i = k; i < size; i++) {
            temp = sum;
            sum = sum + arr[i] - arr[i - k];
            if (sum > temp) {
                start = i - k + 1;
                end = i;

            }


        }
        System.out.println("The max sum =" + sum + " is from index [i,j]=[" + start + "," + end + "]");


    }

    /*This function calculates the minimum sum of the subArray */
    public static void minSubArray(int[] arr, int k) {
        int size, i = 0, sum = 0, temp = 0, start, end;
        size = arr.length;
        while (i < k) {
            sum += arr[i];
            i++;
        }
        start = 0;
        end = k - 1;
        for (i = k; i < size; i++) {
            temp = sum;
            sum = sum + arr[i] - arr[i - k];
            if (sum < temp) {
                start = i - k + 1;
                end = i;
            } else {
                sum = temp;

            }

        }
        System.out.println("The min sum =" + sum + " is from index [i,j]=[" + start + "," + end + "]");

    }

    /* This function returns whether there is subarray have a given sum */
    public static boolean givenSum(int[] arr, int sum) {
        int size, i = 0, temp = 0, start = 0, end = 0;
        size = arr.length;
        /* Handling  the case for 0*/
        if (sum == 0) {
            for (int j : arr) {
                if (j == 0) {
                    return true;
                }
            }
            if (sum == 0) {
                return false;
            }
        }
        for (i = 0; i < size; i++) {
            if (temp == sum) {
                return true;
            }
            temp += arr[i];
            end++;
            if (temp > sum) {
                while (temp > sum) {
                    temp -= arr[start];
                    start++;
                }
            }


        }
        return false;
    }
}
