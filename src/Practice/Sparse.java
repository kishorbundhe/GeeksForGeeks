package Practice;

import java.util.Scanner;

/*Given a number N.  The task is to check whether it is sparse or not.
 A number is said to be a sparse number if no two or more consecutive bits are set
   in the binary representation.*/
public class Sparse {
    public static void main(String[] args) {
        System.out.println("Please enter the value of n");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        isSparse(n);
    }

    private static void isSparse(int n) {
        int temp;
        temp = n >> 1;
        if ((n & temp) > 0) System.out.println("NOT SPARSE");
        else System.out.println("SPARSE");
    }
}
