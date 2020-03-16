package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PrintNonRepeatedElements {
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] str = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            int[] arr = new int[n];

            str = read.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(str[i]);


            printNonRepeated(arr, n);
            System.out.println();
        }
    }

    static void printNonRepeated(int[] arr, int n) {
        StringBuilder stringbuilder = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                stringbuilder.append(entry.getKey() + " ");
            }

        }

        System.out.println(stringbuilder.toString().trim());
    }

}
