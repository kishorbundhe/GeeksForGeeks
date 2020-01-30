package Array;

import PublicFunctions.CalculateTimeForProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Given an array arr[] of N distinct integers, check if this array is Sorted (non-increasing or non-decreasing)
and Rotated counter-clockwise. Note that input array may be sorted in either increasing or decreasing order, then rotated.
A sorted array is not considered as sorted and rotated, i.e., there should be at least one rotation.
* */
public class SortedAndRotated {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            String[] inputline = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputline[i]);
            }
            CalculateTimeForProgram calculateTimeForProgram = new CalculateTimeForProgram();
            calculateTimeForProgram.startTime();
            boolean flag = checkSortedAndRotated(arr, n);
            calculateTimeForProgram.endTime();

            System.out.println(flag + " " + calculateTimeForProgram.timeInMilli());
        }
    }

    public static boolean checkSortedAndRotated(int[] arr, int n) {
        int maxElement, minElement, i, indexOfmaxElement = 0, indexOfminElement = 0;
        maxElement = arr[0];
        minElement = arr[0];
        for (i = 0; i < n; i++) {
            if (arr[i] > maxElement) {
                maxElement = arr[i];
                indexOfmaxElement = i;
            }
            if (arr[i] < minElement) {
                minElement = arr[i];
                indexOfminElement = i;
            }
        }
        if (indexOfminElement > indexOfmaxElement) {
            if (indexOfminElement - indexOfmaxElement == 1) {
                /* Function to check whether the array is increasing  */
                return checkNonDecreasing(arr, indexOfmaxElement, indexOfminElement, n);
            } else {
                return false;
            }
        } else {
            if (indexOfmaxElement - indexOfminElement == 1) {
                /* Function to check whether the array is decreasing */
                return checkNonIncreasing(arr, indexOfmaxElement, indexOfminElement, n);
            } else {
                return false;
            }

        }
    }

    public static boolean checkNonIncreasing(int[] arr, int indexOfmaxElement, int indexOfminElement, int n) {
        /* Function to check whether the array is decreasing */
        boolean flag = true;
        int i = indexOfmaxElement;
        while (i != (indexOfminElement - 1)) {
            if (arr[i % n] > arr[(i + 1) % n]) {

            } else {
                flag = false;
                break;
            }
            i = (i + 1) % n;
        }
        return flag;
    }

    public static boolean checkNonDecreasing(int[] arr, int indexOfmaxElement, int indexOfminElement, int n) {
        /* Function to check whether the array is increasing  */
        boolean flag = true;
        int i = indexOfminElement;
        while (i != (indexOfmaxElement - 1)) {
            if (arr[i % n] < arr[(i + 1) % n]) {

            } else {
                flag = false;
                break;
            }
            i = (i + 1) % n;
        }
        return flag;
    }
}
