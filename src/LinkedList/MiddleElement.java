package LinkedList;

import java.util.Scanner;

/*Given a singly linked list of N nodes. The task is to find the middle of the linked list.
 For example, if given linked list is 1->2->3->4->5 then the output should be 3.
If there are even nodes, then there would be two middle nodes, we need to print the second middle element.
 For example, if given linked list is 1->2->3->4->5->6 then the output should be 4.*/
public class MiddleElement {
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
            System.out.println(getMiddle(head));
        }
    }

    private static int getMiddle(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
}
