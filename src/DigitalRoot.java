import java.util.Scanner;

/*You are given a number n. You need to find the digital root of n.
DigitalRoot of a number is the recursive sum of its digits until we get a single digit number.
Eg.DigitalRoot(191)=1+9+1=>11=>1+1=>2*/
public class DigitalRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(digitalRoot(n));
        }

    }

    static int count = 0, temp;

    public static int digitalRoot(int n) {
        int sum = 0;
        if (n == 0)
            return 0;
        count++;
        sum += (n % 10) + digitalRoot(n / 10);
        count--;
        if (count == 0) {
            if (sum < 10) {
                return sum;
            } else {
                temp = sum;
                temp = digitalRoot(temp);
                return temp;
            }
        }
        return sum;
    }
}
