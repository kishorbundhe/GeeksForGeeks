package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*Given an array arr[] of size N. The task is to find the first repeating element in an array of integers,
        i.e., an element that occurs more than once and whose index of first occurrence is smallest.*/
public class FirstRepeatingElement {
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine().trim());
            int[] arr = new int[n];
            String[] str = read.readLine().split(" ");

            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(str[i]);


            System.out.println(firstRepeating(arr, n));

        }
    }

    private static int firstRepeating(int[] arr, int n) {
        int res = n;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                res = Math.min(res, map.get(arr[i]));
            } else {
                map.put(arr[i], i);
            }
        }
        res = res >= n ? -2 : res;
        return res + 1;
    }
}
