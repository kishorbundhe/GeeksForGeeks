package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*Given an array arr[] of positive integers of size N. Reverse every sub-array of K group elements.*/
public class ReverseSubArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        System.out.println("Size of the subgroup");
        int k = sc.nextInt();
        System.out.println("Size of the Array ");
        int size = sc.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        while (size > 0) {
            list.add(sc.nextInt());
            size--;
        }
        Reversesubarrays(list, list.size(), k);
    }

    public static void Reversesubarrays(List<Integer> input, int size, int k) {
        if (k > size) {
            k = size;
        }
        int temp, end = k - 1, start = 0, noftimesouterloop = (size % k == 0) ? (size / k) : (size / k) + 1;
        int temp_end = k - 1;
        while (noftimesouterloop > 0) {

            for (; start < end; start++, end--) {
                temp = input.get(start);
                input.set(start, input.get(end));
                input.set(end, temp);
            }
            noftimesouterloop--;
            start = temp_end + 1;
            end = start + (k - 1);
            temp_end = end;
            if (end > size - 1) {
                end = size - 1;
            }
        }
        System.out.println("ArrayList after reversing =" + input);
    }
}
