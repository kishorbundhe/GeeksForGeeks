package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/*Given an array arr[] of N numbers. The task is to print only those numbers whose digits are from set {1,2,3}.*/
public class NumberContaining123 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            countNoContain123(arr, n);
        }
    }

    private static void countNoContain123(int[] arr, int n) {
        int i, j, temp, r, flag;
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        ArrayList<Integer> arrayList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < n; i++) {
            temp = arr[i];
            flag = 0;
            while (temp > 0) {
                flag = 1;
                r = temp % 10;
                if (!set.contains(r)) {
                    flag = 2;
                    break;
                }
                temp = temp / 10;
            }
            if (flag == 1) {
                arrayList.add(arr[i]);
            }
        }
        Collections.sort(arrayList);
        for (int k :
                arrayList) {
            sb.append(k + " ");
        }
        if (sb.toString().isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(sb.toString());
        }

    }
}
