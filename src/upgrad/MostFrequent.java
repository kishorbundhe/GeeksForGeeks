package upgrad;

import java.util.HashMap;
import java.util.Scanner;

public class MostFrequent {

    public static int mostFrequentElement(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int maxElement = 0, maxCount = 0, count;
        for (int x : arr) {
            if (!frequencyMap.containsKey(x)) {
                if (maxCount < 0) {
                    maxElement = x;
                    maxCount = 1;
                }
                frequencyMap.put(x, 1);
            } else {
                count = frequencyMap.get(x);
                if (maxCount < count + 1) {
                    maxElement = x;
                    maxCount = count + 1;
                }
                frequencyMap.put(x, count + 1);
            }
        }
        return maxElement;
    }


    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(mostFrequentElement(arr));
    }
}