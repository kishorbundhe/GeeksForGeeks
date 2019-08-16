/*Given a positive integer value N. The task is to find how many numbers less than or equal to N have numbers of divisors exactly equal to 3.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExactlyDivisor {
    public static void main(String[] args) {
        System.out.println("Please enter the value of n");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        exactly3Divisors(n);
    }

    static List<Integer> list = new ArrayList<Integer>();

    public static int exactly3Divisors(int N) {
        int count = 0;
        printPrime(N);
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
            temp = temp * temp;
            if (temp <= N) {
                count++;
            }
        }
        System.out.println(count);
        return count;
    }

    public static void printPrime(int N) {
        int i, sizeOfList;
        for (i = 0; i <= N; i++) {
            list.add(i, i);
        }
        sizeOfList = list.size();

        for (i = 2; i <= sizeOfList; i++) {

            for (int j = i + 1; j < sizeOfList; j++) {
                int temp = list.get(j);
                if (temp % i == 0) {
                    list.remove((Integer) temp);
                    sizeOfList = list.size();
                }

            }
            sizeOfList = list.size();
        }
        list.remove(0);
        list.remove(0);
        System.out.println(list);
    }
}