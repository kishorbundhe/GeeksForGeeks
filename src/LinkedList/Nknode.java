package LinkedList;

import java.util.Scanner;

/*Given a singly linked list and a number k. Write a function to find the (N/k)th element,
        where N is the number of elements in the list. We need to consider ceil value in case of decimals.*/
public class Nknode {
    static Node head;

    public static void addToTheLast(Node node) {

        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                addToTheLast(new Node(a));
            }
            int k = sc.nextInt();
            System.out.println(nknode(head, k));
        }
    }

    private static int nknode(Node head, int k) {
        Node fast = head;
        Node slow = head;
        int t = k;
        t = k;
        while (fast != null && fast.next != null) {
            while (t > 0 && fast != null && fast.next != null) {
                fast = fast.next;
                t--;
            }
            if (t > 0) {
                break;
            }
            slow = slow.next;

            t = k;

        }
        return slow.data;
    }
}







