import java.util.Scanner;

public class NoOfSetBits {
    public static void main(String[] args) {
        System.out.println("Please enter the value of n");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        NoofSetbits(n);
    }

    private static void NoofSetbits(int n) {
        int count = 0, i, temp;
        // Your logic here
        for (i = 1; i <= n; i++) {
            temp = i;
            while (temp != 0) {
                temp = temp & (temp - 1);
                count++;
            }
        }
        System.out.println(count);
    }
}
