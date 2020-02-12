package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeWithOutSpace {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[] arr1 = new int[n];
            int[] arr2 = new int[m];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                arr2[i] = Integer.parseInt(inputLine[i]);
            }
            MergerSort1.merge(arr1, arr2, n, m);

            StringBuffer str = new StringBuffer();
            for (int i = 0; i < n; i++) {
                str.append(arr1[i] + " ");
            }
            for (int i = 0; i < m; i++) {
                str.append(arr2[i] + " ");
            }
            System.out.println(str);
        }
    }
}

class MergeSort {
    static int i, j, N;

    public static void merge(int[] arr1, int[] arr2, int n, int m) {
        int pos = 0;
        i = 0;
        j = 0;
        if (arr1[n - 1] > arr2[m - 1]) {
            N = arr1[n - 1] + 1;
        } else {
            N = arr2[m - 1] + 1;
        }
        if (arr2[0] > arr1[n - 1]) {
            return;
        }
        pos = replace(arr1, arr2, arr1, pos, n, m);
        if (pos < n) {
            while (i < n && pos < n) {
                arr1[pos] += N * (arr1[i] % N);
                i++;
                pos++;
            }
            while (j < m && pos < n) {
                arr1[pos] += N * (arr2[j] % N);
                j++;
                pos++;
            }
        }
        pos = 0;
        pos = replace(arr1, arr2, arr2, pos, n, m);
        while (i < n && pos < m) {
            arr2[pos] += N * (arr1[i] % N);
            i++;
            pos++;
        }
        while (j < m && pos < m) {
            arr2[pos] += N * (arr2[j] % N);
            j++;
            pos++;
        }

        System.out.println("i=" + i + " j=" + j);
        for (int k : arr1) {
            System.out.print(k / N + " ");
        }
        for (int k : arr2) {
            System.out.print(k / N + " ");
        }
        System.out.println(" ");
      /*  System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));*/
    }

    private static int replace(int[] a, int[] b, int[] c, int pos, int asize, int bsize) {
        int posSize = c.length;
        while (pos < posSize && i < asize && j < bsize) {
            if ((a[i] % N) <= (b[j] % N)) {
                c[pos] += N * (a[i] % N);
                i++;
                pos++;
            } else {
                c[pos] += N * (b[j] % N);
                pos++;
                j++;
            }
        }
        return pos;
    }

}

class MergerSort1 {
    public static void merge(int[] arr1, int[] arr2, int n, int m) throws IOException {
        int key, i, j, posX, temp;
        key = arr2[0];
        i = 0;
        j = 0;
        do {
            posX = binarySearch(arr1, 0, n, key);
            swap(arr1, arr2, posX);
            j = 0;
            while ((j + 1) < m && arr2[j] > arr2[j + 1]) {
                temp = arr2[j + 1];
                arr2[j + 1] = arr2[j];
                arr2[j] = temp;
                j++;
            }
            key = arr2[0];
        } while ((posX + 1) < n);
        System.out.println("-------------------------");
    }

    private static void swap(int[] arr1, int[] arr2, int pos) {
        int temp = arr2[0];
        arr2[0] = arr1[pos];
        arr1[pos] = temp;
    }

    private static int binarySearch(int[] arr, int start, int end, int X) {
        int index, mid;
        while (start < end) {
            mid = start + (end - start) / 2;

            if ((mid - 1) >= 0 && arr[mid] > X && arr[mid - 1] <= X) {
                return mid;
            } else if (mid == start && arr[mid] > X) {
                return 0;
            } else if (mid == end && arr[mid] > X) {
                return end;
            } else if (arr[mid] > X && arr[mid - 1] > X) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return -1;
    }


}

class MergeSort2 {

}