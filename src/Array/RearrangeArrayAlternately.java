package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*Given a sorted array of positive integers. Your task is to rearrange  the array elements alternatively
i.e first element should be max value, second should be min value, third should be second max, fourth should be second min and so on.

Note: O(1) extra space is allowed. Also, try to modify the input array as required.*/
public class RearrangeArrayAlternately {
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
//            Rearrange obj = new Rearrange();
            rearranageArray(arr, n);
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void rearranageArray(int[] arr, int size) {
        int start = 0, end = size - 1;
        for (; start < size; ) {
            leftRotate(arr, start, end);
            start = start + 2;
        }
    }

    private static void leftRotate(int[] arr, int start, int end) {
        int temp = arr[end];
        while (start < end) {
            arr[end] = arr[end - 1];
            end--;
        }
        arr[start] = temp;
    }
}


