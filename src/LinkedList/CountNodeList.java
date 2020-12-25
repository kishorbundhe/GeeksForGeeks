package LinkedList;

import java.util.Scanner;

/*
 * Given a linked list of size N. The task is to complete the function countNodesinLoop() that checks whether a given
 * Linked List contains a loop or not and if the loop is present then return the count of nodes in a loop or else return 0*/
public class CountNodeList {
    public static void makeLoop(Node head, Node tail, int x) {
        if (x == 0) return;

        Node curr = head;
        for (int i = 1; i < x; i++)
            curr = curr.next;

        tail.next = curr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int num = sc.nextInt();
            Node head = new Node(num);
            Node tail = head;

            for (int i = 0; i < n - 1; i++) {
                num = sc.nextInt();
                tail.next = new Node(num);
                tail = tail.next;
            }

            int pos = sc.nextInt();
            makeLoop(head, tail, pos);

            Solution x = new Solution();
            System.out.println(Solution.countNodesinLoop(head));
        }
    }
}

class Solution {
    static int countNodesinLoop(Node head) {
        Node slow = head;
        Node fast = head;
        int count;
        boolean isLoop = false;
        // detect a loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isLoop = true;
                break;
            }
        }

        slow = head;
        // second time, fast and slow meet at the start of the loop.
        if (isLoop) {
            while (fast != slow) {
                slow = slow.next;
                fast = fast.next;
            }

            count = 1;
            fast = fast.next;
            // make slow stand at the starting point and make fast come back to slow and while doing so count the nodes.
            while (fast != slow) {
                fast = fast.next;
                count++;
            }
            return count;
        } else {
            return 0;
        }
    }
}
