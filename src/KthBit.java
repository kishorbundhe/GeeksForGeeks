import java.util.Scanner;

public class KthBit {

    public static void main(String[] args) {
        System.out.println("Please enter the value of n");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        checkKthBit(n, k);

    }

    private static void checkKthBit(int n, int k) {
        boolean flag = false;
        int twopowerk = 1 << k;
        System.out.println(twopowerk);
        if ((n & twopowerk) == 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}
