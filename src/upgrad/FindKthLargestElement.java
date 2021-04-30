package upgrad;

import java.util.PriorityQueue;
import java.util.Scanner;

public class FindKthLargestElement {
    static PriorityQueue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int k = sc.nextInt();

        int[] stream = new int[n];

        for (int i = 0; i < n; i++) {

            stream[i] = sc.nextInt();
            findKthLargest(stream[i], k, i + 1);

        }


    }

    private static void findKthLargest(int value, int k, int size) {

        if (k > size) {
            queue.add(value);
            System.out.println("None");
            return;
        } else if (k == size) {
            queue.add(value);
            System.out.println(k + " largest number is " + queue.peek());
            return;
        }
        if (value > queue.peek()) {
            queue.poll();
            queue.add(value);
        }
        System.out.println(k + " largest number is " + queue.peek());
    }
}
