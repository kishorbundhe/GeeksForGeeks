package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*Given an unsorted array of positive integers.
Find the number of triangles that can be formed with three different array elements as three sides of triangles.*/
public class Count_possible_triangle {
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
            findNumberOfTriangles(arr, n);
            System.out.println(Arrays.toString(arr));

        }

    }

    private static void findNumberOfTriangles(int[] arr, int n) {
        int totalNofpossibility = 0, i = 0, j = 0, z = n - 1, twoSideSum = 0;
        /* Total no of possibility is equal to NC3 or Combination(N 3)*/
        if (n > 3) {
            totalNofpossibility = (n * (n - 1) * (n - 2)) / 6;
        } else if (n == 3) {
            totalNofpossibility = 1;
        }
        Arrays.sort(arr);
        for (i = 0; i < n; i++) {
            for (j = i + 1; j < n; j++) {
                twoSideSum = arr[i] + arr[j];
                z = n - 1;
                while (z >= 0) {
                    if (twoSideSum > arr[z]) {
                        break;
                    } else {
                        totalNofpossibility--;
                    }
                    z--;
                }
            }
        }
        System.out.println(totalNofpossibility);
    }
}
