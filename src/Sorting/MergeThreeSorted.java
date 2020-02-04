package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*Given three sorted arrays A, B and C of size N, M and P respectively.
The task is to merge them into a single array which must be sorted in increasing order.*/
public class MergeThreeSorted {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] str = (br.readLine()).trim().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            int p = Integer.parseInt(str[2]);
            int[] A = new int[n];
            str = (br.readLine()).trim().split(" ");
            for (int i = 0; i < n; i++)
                A[i] = Integer.parseInt(str[i]);

            str = (br.readLine()).trim().split(" ");
            int[] B = new int[m];
            for (int i = 0; i < m; i++)
                B[i] = Integer.parseInt(str[i]);

            str = (br.readLine()).trim().split(" ");
            int[] C = new int[p];
            for (int i = 0; i < p; i++) {
                C[i] = Integer.parseInt(str[i]);
            }
            System.out.println(merge3sorted(A, B, C));
        }
    }

    static ArrayList<Integer> merge3sorted(int[] A, int[] B, int[] C) {
        ArrayList<Integer> mergedList = new ArrayList<Integer>();
        int m, n, p, i = 0, j = 0, k = 0;
        m = A.length;
        n = B.length;
        p = C.length;

        while (i < m && j < n && k < p) {
            if (A[i] <= B[j] && A[i] <= C[k]) {
                mergedList.add(A[i]);
                i++;
            } else if (B[j] <= A[i] && B[j] <= C[k]) {
                mergedList.add(B[j]);
                j++;
            } else if (C[k] <= A[i] && C[k] <= B[j]) {
                mergedList.add(C[k]);
                k++;
            }
        }
        if (i == m) {
            mergetwo(mergedList, B, C, j, k);

        } else if (j == n) {
            mergetwo(mergedList, A, C, i, k);
        } else {
            mergetwo(mergedList, A, B, i, j);
        }


        return mergedList;
    }

    private static void mergetwo(ArrayList<Integer> mergedlist, int[] a, int[] b, int i, int j) {
        int m, n;
        m = a.length;
        n = b.length;
        while (i < m && j < n) {
            if (a[i] <= b[j]) {
                mergedlist.add(a[i]);
                i++;
            } else {
                mergedlist.add(b[j]);
                j++;
            }
        }
        while (i < m) {
            mergedlist.add(a[i]);
            i++;
        }
        while (j < n) {
            mergedlist.add(b[j]);
            j++;
        }
    }

}

// Function to merge three sorted arrays
// A[], B[], C[]: input arrays