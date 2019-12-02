package Practice;

import java.util.Scanner;

public class TowerOFHanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int N = sc.nextInt();
            Hanoi(N, 1, 3, 2);
        }
    }

    static int count = 0, moves = 0;

    public static void Hanoi(int N, int from, int to, int aux) {

        if (N == 1) {
            moves++;

            System.out.println("move disk " + N + " from rod " + from + " to rod " + to);

            return;
        }

        Hanoi(N - 1, from, aux, to);
        moves++;
        System.out.println("move disk " + N + " from rod " + from + " to rod " + to);
        Hanoi(N - 1, aux, to, from);
    }
}