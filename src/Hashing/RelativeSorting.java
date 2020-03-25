package Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*Given two arrays A1[] and A2[] of size N and M respectively.
The task is to sort A1 in such a way that the relative order among the elements will be same as those in A2.
For the elements not present in A2, append them at last in sorted order.
It is also given that the number of elements in A2[] are smaller than or equal
to number of elements in A1[] and A2[] has all distinct elements.
Note: Expected time complexity is O(N log(N)).*/

/* Did  not use Single Responsiblity function */
public class RelativeSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int temp, count = 0, tempSecond, tobeSortedFrom;
            HashMap<Integer, Integer> frequencyMap = new HashMap<>();
            int[] output = new int[n];

            for (int i = 0; i < n; i++) {
                temp = sc.nextInt();
                if (frequencyMap.containsKey(temp)) {
                    frequencyMap.put(temp, frequencyMap.get(temp) + 1);
                } else {
                    frequencyMap.put(temp, 1);
                }
            }

            for (int j = 0; j < m; j++) {
                tempSecond = sc.nextInt();
                if (frequencyMap.containsKey(tempSecond)) {
                    while (!(frequencyMap.get(tempSecond) == 0)) {
                        output[count++] = tempSecond;
                        frequencyMap.put(tempSecond, frequencyMap.get(tempSecond) - 1);
                    }
                    frequencyMap.remove(tempSecond);
                }
            }
            tobeSortedFrom = count;
            for (Map.Entry<Integer, Integer> e :
                    frequencyMap.entrySet()) {
                temp = e.getValue();
                while (temp-- > 0) {
                    output[count++] = e.getKey();
                }

            }
            Arrays.sort(output, tobeSortedFrom, n);
            StringBuilder sb = new StringBuilder();
            for (int x : output) {
                sb.append(x + " ");
            }
            System.out.println(sb.toString().trim());

        }

    }

}
