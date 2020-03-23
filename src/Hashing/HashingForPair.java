package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/* Pair with Sum exist or not in array using hashing*/
public class HashingForPair {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n, sum;
            n = Integer.parseInt(read.readLine().trim());
            int[] arr = new int[n];
            String[] str = read.readLine().split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(str[i]);
            sum = Integer.parseInt(read.readLine());
            System.out.println(sumExists(arr, n, sum));
        }
    }

    public static int sumExists(int[] arr, int n, int sum) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (set.contains(sum - arr[i])) {
                return 1;
            }
            set.add(arr[i]);
        }
        return 0;
    }
}
