package Search;
/*Given a sorted array arr of N positive integers (elements may be repeated) and a number x.
The task is to find the leftmost index of x in the array arr.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeftIndexOfX {
    public static void main(String[] args) throws IOException {
        int x, t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            String[] string = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(string[i]);
            }
            System.out.println("Element to Searh it's left index");
            x = Integer.parseInt(br.readLine().trim());
            leftIndex(arr, n, x);
        }
    }

    private static void leftIndex(int[] arr, int size, int x) {
        int mid, low, high;
        low = 0;
        high = size - 1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] == x && mid != 0 && arr[mid - 1] == x) {
                high = mid - 1;
            } else if (x > arr[mid]) {
                low = mid + 1;
            } else if (x < arr[mid]) {
                high = mid - 1;
            } else {
                System.out.println("Left index of " + x + "=" + mid);
                return;
            }
        }

    }
}