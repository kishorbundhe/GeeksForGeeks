package Practice;

import java.util.Scanner;

public class PowerOfNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n, k;
        while (t-- > 0) {
            n = sc.nextInt();
            k = sc.nextInt();

            System.out.println(PowerOfNumber(n, k));
        }
    }

    private static long PowerOfNumber(int N, int R) {
        if (R == 1) {
            return N;
        }
        long temp = 1;
        temp *= N * PowerOfNumber(N, R - 1);
        return temp % (1000000007);

    }

}
