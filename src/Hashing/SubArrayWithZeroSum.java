package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*zeroSum() : Given an array a[] of N positive and negative numbers. Find if there is a subarray (of size at-least one) with 0 sum.*/
/*rangeSum() :Given an unsorted array arr[] of N integers and a sum. The task is to count the number of subarray which adds to a given number.*/
public class SubArrayWithZeroSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");
            System.out.println(Arrays.toString(inputLine));
            for (int i = 0; i < n; i++) {
                if (inputLine[i].isEmpty())
                    arr[i] = Integer.parseInt(inputLine[i]);
            }
            /* zeroSum(arr, n);*/
            int sum = Integer.parseInt(br.readLine().trim());
            System.out.println(rangeSum(arr, n, sum));
        }
    }

    private static int rangeSum(int[] arr, int n, int sum) {
        int presum = 0, count = 0;
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            presum += arr[i];
            if (presum == sum) {
                count++;
            }
            if (frequencyMap.containsKey(presum - sum)) {
                count += frequencyMap.get(presum - sum);
            }
            if (!frequencyMap.containsKey(presum)) {
                frequencyMap.put(presum, 1);
            } else {
                frequencyMap.put(presum, frequencyMap.get(presum) + 1);
            }

        }
        return count;
    }

    private static void zeroSum(int[] arr, int n) {
        int presum = 0;
        HashSet<Integer> preSumSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            presum += arr[i];
            if (presum == 0) {
                System.out.println("Yes");
                return;
            }
            if (preSumSet.contains(presum)) {
                System.out.println("Yes");
                return;
            } else {
                preSumSet.add(presum);
            }

        }
        System.out.println("No");

    }
}