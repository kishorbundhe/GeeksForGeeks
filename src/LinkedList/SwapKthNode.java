package LinkedList;

import java.util.Scanner;

class SwapKthNode {
    static Node head;
    static Node lastNode;

    public static void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            lastNode = node;
        } else {
            Node temp = head;
            lastNode.next = node;
            lastNode = node;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n, K;
            n = sc.nextInt();
            K = sc.nextInt();

            Node head = null;
            int val = sc.nextInt();
            head = new Node(val);
            addToTheLast(head);

            for (int i = 1; i < n; i++) {
                val = sc.nextInt();
                addToTheLast(new Node(val));
            }

            Node[] before = new Node[n];
            addressstore(before, head);
            GFG obj = new GFG();

            head = obj.swapkthnode(head, n, K);

            Node[] after = new Node[n];
            addressstore(after, head);

            if (check(before, after, n, K))
                System.out.println("1");
            else
                System.out.println("0");

        }
    }

    static boolean check(Node[] before, Node[] after, int num, int K) {
        if (K > num)
            return true;

        return (before[K - 1] == after[num - K]) && (before[num - K] == after[K - 1]);


    }

    static void addressstore(Node[] arr, Node head) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            arr[i] = temp;
            i++;
            temp = temp.next;
        }
    }

}

class GFG {
    // Should swap Kth node from beginning and
    // Kth node from end in list and return new head.
    Node swapkthnode(Node head, int num, int K) {
        Node firstNodeDeleted = head, secondNodeDeleted = null;
        Node oneNodeBeforeFromTheStart = head, oneNodeBeforeFromTheLast = null;

        int i, nMinusK = 0;
        Node temp = head;
        if (num % 2 == 1 && K == (num / 2 + 1) || K > num) {
            return head;
        }
        if (K > num / 2) {
            nMinusK = K;
            K = num - K + 1;
        } else {
            nMinusK = num - K + 1;
        }


        for (i = 1; i < nMinusK - 1; i++) {
            if (i == K - 1) {
                oneNodeBeforeFromTheStart = temp;
                firstNodeDeleted = temp.next;
            }
            temp = temp.next;
        }

        oneNodeBeforeFromTheLast = temp;
        secondNodeDeleted = temp.next;
        //
        if (firstNodeDeleted == head || K == 1) {
            temp = head.next;
            secondNodeDeleted.next = temp;
            oneNodeBeforeFromTheLast.next = firstNodeDeleted;
            firstNodeDeleted.next = null;
            head = secondNodeDeleted;
            return head;
        } else if (firstNodeDeleted.next == secondNodeDeleted) {
            oneNodeBeforeFromTheLast.next = secondNodeDeleted.next;
            oneNodeBeforeFromTheStart.next = firstNodeDeleted.next;
            //
            temp = oneNodeBeforeFromTheStart.next;
            oneNodeBeforeFromTheStart.next = secondNodeDeleted;
            secondNodeDeleted.next = temp;

            temp = secondNodeDeleted.next;
            secondNodeDeleted.next = firstNodeDeleted;
            return head;
        }
        oneNodeBeforeFromTheLast.next = secondNodeDeleted.next;
        oneNodeBeforeFromTheStart.next = firstNodeDeleted.next;

        // add second deleted to the first place
        temp = oneNodeBeforeFromTheStart.next;
        oneNodeBeforeFromTheStart.next = secondNodeDeleted;
        secondNodeDeleted.next = temp;

        // add first deleted to the second place
        temp = oneNodeBeforeFromTheLast.next;
        oneNodeBeforeFromTheLast.next = firstNodeDeleted;
        firstNodeDeleted.next = temp;

        return head;
    }
}
