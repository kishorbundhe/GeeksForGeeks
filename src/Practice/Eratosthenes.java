package Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*Using Sieve of Eratosthenes is the most efficient way of generating prime numbers upto a given number N.*/
public class Eratosthenes {
    public static void main(String[] args) {
        System.out.println("Please enter the value of n");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        printPrime(n);
    }

//    public static void printAllPrime(int n) {
//        int i, j, element, tempArrayListSize;
//        tempArrayListSize = n + 1;
//        List<Integer> list = new ArrayList<Integer>();
//        for (i = 0; i < tempArrayListSize; i++) {
//            list.add(i, i);
//        }
//
//        for (i = 2; i < tempArrayListSize; i++) {
//            for (j = i + 1; j < tempArrayListSize; j++) {
//                if (list.get(j) % i == 0) {
//                    list.remove((Integer) list.get(j));
//                    tempArrayListSize = list.size();
//
//                }
//
//            }
//            tempArrayListSize = list.size();
//        }
//        System.out.println(list);
//    }


    static List<Integer> list = new ArrayList<Integer>();

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
        System.out.println(list);

    }
}
