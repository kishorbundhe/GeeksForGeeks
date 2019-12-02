package Practice;

import java.util.Scanner;

import static java.lang.StrictMath.ceil;
import static java.lang.StrictMath.log;

/*Given a number N. The task is to find the length of the longest consecutive 1s in its binary representation.*/
public class LargestConsecutive {
    public static void main(String[] args) {
        System.out.println("Please enter the value of n");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        maxConsecutiveOnes(n);
    }

    private static void binaryRespresentation(int n) {
        int numberofBit = (int) ceil(log(n));
        for (; numberofBit > 1; numberofBit--) {
            if (((n >> 1) & 1) == 1) {
                System.out.print(1);

            } else {
                System.out.print(0);
            }
            n = n >> 1;
        }
    }

    private static void maxConsecutiveOnes(int x) {
        int max = 0, tempmax = 0, flag = 0;
//        binaryRespresentation(x);
        if (x == 0) {
            System.out.println(0);

        } else if ((x & (x >> 1)) == 0) {
            System.out.println(1);
        } else {
            while (x != 0) {

                if ((x & 1) == 1) {
                    max++;
                    x = x >> 1;
                    continue;
                }
                if (max > tempmax) {
                    tempmax = max;
                }
                max = 0;
                x = x >> 1;
            }
            if (max > tempmax) {
                tempmax = max;
            }
            System.out.println(tempmax);
        }
    }

}
