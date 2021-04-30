package upgrad;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SortNearlySorted {
    private static void sortArray(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        int i = 0, j;
        for (; i <= k; i++) {
            queue.add(arr[i]);
        }
        j = i;
        i = 0;
        while (!queue.isEmpty() && j < arr.length) {
            arr[i] = queue.poll();
            queue.add(arr[j]);
            i++;
            j++;
        }

        while (!queue.isEmpty()) {
            arr[i] = queue.poll();
            i++;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sortArray(arr, k);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
