package upgrad;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SumBetweenPthToQthSmallestElement {
    public static int sumBetweenPthToQthSmallestElement(int[] arr, int p, int q) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int x : arr) {
            minHeap.add(x);
        }
        int sum = 0, temp;
        for (int i = 0; i < q - 1; i++) {
            temp = minHeap.poll();
            if (i > p - 1 && i < q - 1) {
                sum += temp;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int p = sc.nextInt();
        int q = sc.nextInt();
        System.out.println(sumBetweenPthToQthSmallestElement(arr, p, q));
    }
}
