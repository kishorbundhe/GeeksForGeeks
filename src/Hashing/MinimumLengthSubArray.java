package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* Given an array of number  , find the minimum sub array such that its sum is divisble by K */
public class MinimumLengthSubArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < T; t_i++) {
            String[] NK = br.readLine().split(" ");
            int N = Integer.parseInt(NK[0]);
            int K = Integer.parseInt(NK[1]);
            String[] arr_arr = br.readLine().split(" ");
            int[] arr = new int[N];
            for (int i_arr = 0; i_arr < arr_arr.length; i_arr++) {
                arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
            }

            int out_ = Solution(N, K, arr);
            System.out.println(out_);
        }
    }

    static int Solution(int N, int K, int[] arr) {
        int i, presum = 0, res = Integer.MAX_VALUE, flag = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (i = 0; i < N; i++) {
            presum += arr[i];
            if (presum % K == 0) {
                flag = 1;
                res = Math.min(res, i + 1);
            }
            int temp = presum;
            while (temp > 0) {
                if (map.containsKey(temp)) {
                    flag = 1;
                    res = Math.min(res, i - map.get(temp));

                }

                temp = temp - K;
            }
            map.put(presum, i);
        }
        if (flag == 0) {
            return -1;
        } else
            return res;

    }
}