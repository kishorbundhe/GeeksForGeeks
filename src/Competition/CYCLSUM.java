package Competition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CYCLSUM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            String[] string = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(string[i]);
            }

            RotateArray(arr, n);
        }
    }

    private static void RotateArray(int[] arr, int n) {
        int currentMax = 0, globalMax = 0;
        int i = 0, j = 0, start = 0, end = n - 1;
        while (j != (n)) {
            i = start;
            globalMax = 0;
            currentMax = 0;
            do {
                currentMax = Math.max(arr[i], currentMax + arr[i]);
                globalMax = Math.max(currentMax, globalMax);
                i = (i + 1) % n;
            } while (i != start);
            System.out.print(globalMax + " ");
            start = (start + 1) % n;
            end = (end + 1) % n;
            j++;
        }
    }

}
