package Practice;/*Given a positive integer value N. The task is to find how many numbers less than or equal to N have numbers of divisors exactly equal to 3.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExactlyDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            int N;
            N = sc.nextInt();
            long start = System.nanoTime();
            System.out.println(exactly3Divisors(N));
            long end = System.nanoTime();
            System.out.println("Time taken to run in ms " + ((end - start) / 1000));
        }
    }


    public static int exactly3Divisors(int N) {
        int count = 0;
        int temp;
        int temp1 = 2 + (int) Math.sqrt(N);

        List<Integer> list = new ArrayList<Integer>();
        list = printPrime(temp1);

        for (int i = 0; i < list.size(); i++) {
            temp = list.get(i);
            temp = temp * temp;
            if (temp <= N) {
                System.out.println(temp);
                count++;
            }
        }
        return count;
    }

    public static List<Integer> printPrime(int N) {
        List<Integer> list = new ArrayList<Integer>();
        int i, sizeOfList, previousListSize;
        for (i = 0; i <= N; i++) {
            list.add(i, i);
        }
        sizeOfList = list.size();
        previousListSize = sizeOfList;
        System.out.println(list);
        for (i = 2; i < sizeOfList; i++) {

            for (int j = i + 1; j < sizeOfList; j++) {
                int temp = list.get(j);
                if (temp % list.get(i) == 0) {
                    list.remove((Integer) temp);
                    j = j - 1;
                    sizeOfList = sizeOfList - 1;
                }

            }
            if (sizeOfList == previousListSize) {
                break;
            } else {
                previousListSize = sizeOfList;
            }
            sizeOfList = list.size();
        }

        list.remove(0);
        list.remove(0);
        return list;
    }
}