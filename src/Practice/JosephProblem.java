package Practice;

import java.util.Scanner;

public class JosephProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n, k;
        while (t-- > 0) {
            n = sc.nextInt();
            k = sc.nextInt();

            System.out.println(josephus(n, k));
        }
    }

    private static int josephus(int n, int k) {
        if (n == 1) return 1;
        return ((josephus(n - 1, k) + k - 1) % n) + 1;
    }
}
