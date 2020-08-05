package LinkedList;

import java.util.Scanner;


public class NoOfNodesInList {
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

//            CountNodes g = new CountNodes();
            System.out.println(getCount(head));
        }
    }

    public static int getCount(Node head) {
        int count = 0;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

}
