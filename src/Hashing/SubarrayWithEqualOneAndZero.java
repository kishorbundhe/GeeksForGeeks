package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SubarrayWithEqualOneAndZero {
    public static void main(String[] args) throws IOException {
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(countSubarrWithEqualZeroAndOne(arr, n));
        }
    }

    static int countSubarrWithEqualZeroAndOne(int[] arr, int n) {
        int presum = 0, count = 0, temp;
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                presum += -1;
            } else {
                presum += 1;
            }

            if (presum == 0) {
                count++;
            }
            if (frequencyMap.containsKey(presum)) {
                temp = frequencyMap.get(presum);
                count += temp;
                frequencyMap.put(presum, temp + 1);
            } else {
                frequencyMap.put(presum, 1);
            }

        }
        return count;
    }
}
