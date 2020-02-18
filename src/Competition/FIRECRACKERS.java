package Competition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class FIRECRACKERS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int t = br.nextInt();
        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[n];
        Set<Integer> hash_Set = new HashSet<Integer>();
        String[] string = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(string[i]);
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                hash_Set.add(arr[i] / 2);
            } else {
                hash_Set.add(arr[i]);
            }
        }
        System.out.println(hash_Set.size());
    }
}
