package upgrad;

import java.util.Scanner;

public class MedianofTwoArrays {
    public static int median(int[] arr1, int[] arr2, int n) {
        int count = 1, i = 0, j = 0, n1 = 0, n2 = 0;
        while (i < n && j < n && count <= n) {
            if (arr1[i] < arr2[j]) {
                n1 = arr1[i];
                i++;
            } else {
                n1 = arr2[j];
                j++;
            }
            count++;
        }
        if (i < n && j < n) {
            if (arr1[i] < arr2[j]) {
                n2 = arr1[i];
            } else {
                n2 = arr2[j];
            }
        } else if (i < n) {
            n2 = arr1[i++];
        } else if (j < n) {
            n2 = arr2[j++];
        }
        System.out.println(n1 + " " + n2);
        return (n1 + n2) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
        System.out.println(median(arr1, arr2, n));
    }
}
