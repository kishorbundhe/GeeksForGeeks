package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static PublicFunctions.PublicFunctions.binarysearch;


/* Search an element in a sorted and rotated array
* Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 3
Output : Found at index 8
* */
public class SearchInSortedRotated {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            String[] string = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(string[i]);
            }
            /*System.out.println("Enter the element you want to find ");
            int element = Integer.parseInt(br.readLine().trim());*/
            minNumber(arr, 0, n - 1);
            /*searchElement(arr, n, element);*/
            /*floorSqrt(40);*/
        }
    }


    public static void floorSqrt(long x) {
        long start = 1, end = x, ans = 0, mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;
            if (mid * mid == x) {
                System.out.println(mid);
            } else if (mid * mid < x) {
                start = mid + 1;
                ans = mid;

            } else {
                end = mid - 1;
            }

        }
        System.out.println(ans);
    }

    static long minNumber(int[] arr, int low, int high) {
        int mid, pivotIndex = 0;
        do {
            mid = (low + high) / 2;
            if (arr[mid] > arr[mid + 1]) {
                pivotIndex = mid;
                break;
            } else if (arr[mid] > arr[0]) {
                low = mid + 1;
            } else if (arr[mid] < arr[0]) {
                high = mid - 1;
            }

        } while (low <= high);
        System.out.println(arr[pivotIndex + 1]);
        return arr[pivotIndex + 1];
    }

    /* Using Binary search Algo we first find the pivot element*/
    public static void searchElement(int[] arr, int n, int x) {
        /* Find the pivot element using binary search */
        int low, high, mid, pivotIndex = 0, found;
        low = 0;
        high = n - 1;
        do {
            mid = low + (high - low) / 2;
            if (arr[mid] > arr[mid + 1]) {
                pivotIndex = mid;
                break;
            } else if (arr[mid] > arr[0]) {
                low = mid + 1;
            } else if (arr[mid] < arr[0]) {
                high = mid - 1;
            }

        } while (low <= high);

        if (x >= arr[0] && x <= arr[pivotIndex]) {
            found = binarysearch(arr, 0, pivotIndex, x);
        } else {
            found = binarysearch(arr, pivotIndex + 1, n - 1, x);
        }
        if (found != -1) {
            System.out.println("Element found at index =" + found);
        } else {
            System.out.println("Element is not present in the array");
        }
    }


}
