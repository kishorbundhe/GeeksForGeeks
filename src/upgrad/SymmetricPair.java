package upgrad;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SymmetricPair {
    public static void symmetricPair(int[][] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int noOfRow = arr.length, key, value;
        for (int i = 0; i < noOfRow; i++) {
            key = arr[i][0];
            value = arr[i][1];
            if (map.containsKey(value) && key == map.get(value)) {
                System.out.println(value + " " + key);
            } else {
                map.put(key, value);
            }

        }
    }

    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int[][] arr = new int[row][2];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        symmetricPair(arr);
    }
}
