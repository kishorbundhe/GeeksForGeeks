package upgrad;

import java.util.Scanner;

public class SearchElementInRotatedArray {
    public static int search(int[] arr, int left, int right, int key, int size) {
        int start = binarySearch(arr, left, right);
        System.out.println("start " + start);
        int end = (start + size - 1) % size;
        if (key > arr[0]) {
            return binarySearchFromArray(arr, left, end, key);
        } else {
            return binarySearchFromArray(arr, start, right, key);
        }

    }

    private static int binarySearchFromArray(int[] arr, int left, int right, int key) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) return mid;
            else if (key > arr[mid]) {
                return binarySearchFromArray(arr, mid + 1, right, key);
            } else {
                return binarySearchFromArray(arr, left, mid - 1, key);
            }
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (left == right)
                return left;
            if (arr[mid] < arr[mid - 1]) {
                return mid;
            } else if (arr[mid] > arr[mid + 1]) {
                return mid + 1;
            } else if (arr[left] > arr[mid]) {
                return binarySearch(arr, left, mid - 1);
            } else
                return binarySearch(arr, mid + 1, right);
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        int i = search(arr, 0, n - 1, key, n);
        if (i != -1) {
            System.out.println(i);
        } else {
            System.out.println("-1");
        }
    }
}
