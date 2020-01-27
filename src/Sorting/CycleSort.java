package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CycleSort {
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
            cycleSort(arr, n);
            System.out.println(Arrays.toString(arr));

        }
    }

    private static void cycleSort(int[] arr, int n) {
        int i, cs, item, pos = 0, j, temp;
        cs = 0;
        for (i = cs; i < n - 1; i++, cs = i) {
            item = arr[cs];
            pos = cs;
            // Count the number of element smaller than this particular item  selected
            for (j = cs + 1; j < n; j++) {
                if (arr[j] < item)
                    pos++;
            }
            // Swapping
            temp = item;
            item = arr[pos];
            arr[pos] = temp;
            // loop to correct the position changes done by the cycle start(cs)
            while (pos != cs) {
                pos = cs;
                // Count the number of element smaller than this particular item  selected

                for (j = cs + 1; j < n; j++) {
                    if (arr[j] < item)
                        pos++;
                }
                // Swapping
                temp = item;
                item = arr[pos];
                arr[pos] = temp;
            }

        }

    }
}