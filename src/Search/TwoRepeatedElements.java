package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*You are given an array of N+2 integer elements. All elements of the array are in range 1 to N.
And all elements occur once except two numbers which occur twice. Find the two repeating numbers.*/

/*
* Output:
Print the two elements occuring twice in the array. Order of the two elements must be according to second appearance, i.e., first print the element whose second
* occurrence arrives first. For example in 1 2 2 1, the output should be 2 1. And for 1 1 2 2, output should be 1 2.*/
public class TwoRepeatedElements {
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
            twoRepeated(arr, n);
        }
    }

    private static void twoRepeated(int[] arr, int size) {
        int i = 0, j = 0;
        int n = size - 1;
        int[] store = new int[4];
        for (i = 0; i < size; i++) {
            arr[(arr[i] - 1) % n] += n;

        }
        for (i = 0; i < size; i++) {
            if (arr[i] / (n) == 2) {
                store[j] = i + 1;
                j++;
            }
        }
        for (i = 0; i < size; i++) {
            if (arr[i] % (n) == store[0]) {
                store[2] = i;
            } else if (arr[i] % (n) == store[1]) {
                store[3] = i;
            }
        }
        if (store[2] < store[3]) {
            System.out.print(store[0] + " " + store[1]);
        } else {
            System.out.print(store[1] + " " + store[0]);
        }

//        for(i = 0; i < size; i++){
////            if(store[0])
//        }

    }

    public static int binarysearch(int[] arr, int low, int high, int x) {
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (x > arr[mid]) {
                low = mid + 1;
            } else if (x < arr[mid]) {
                high = mid - 1;
            }
        }
        return -1;
    }
}
