package LinkedList;

import java.util.Scanner;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for (int i = 0; i < n - 1; i++) {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }

            head = reverseList(head);
            printList(head);

        }

    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node temp = null;
        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}