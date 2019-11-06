package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MaxOccured {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] L = new int[n];
            int[] R = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                L[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int maxx = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                R[i] = Integer.parseInt(inputLine[i]);
                if (R[i] > maxx) {
                    maxx = R[i];
                }
            }
            System.out.println("Returned Value " + MaxOccur.maxOccured(L, R, n, maxx));
        }
    }
}

class MaxOccur {

    public static int maxOccured(int[] L, int[] R, int n, int maxx) {
        int[] arr = new int[1000000];
        int[] prefixArray;
        int i = 0;
        int count = 0;
        prefixArray = new int[maxx + 2];
        prefixArray[0] = arr[0];
        while (i < n) {
            arr[L[i]] = arr[L[i]] + 1;
            arr[R[i] + 1] = arr[R[i] + 1] - 1;
            i++;
        }
        for (i = 1; i < prefixArray.length; i++) {
            prefixArray[i] = prefixArray[i - 1] + arr[i];
        }
        List<Integer> maxlist = new ArrayList<Integer>();
        for (i = 0; i < prefixArray.length; i++) {
            if (prefixArray[i] == count) {
                maxlist.add(i);
                count = prefixArray[i];
            } else if (prefixArray[i] > count) {
                maxlist.clear();
                count = prefixArray[i];
                maxlist.add(i);
            }
        }
        System.out.println("Printing the list =" + maxlist);
        return maxlist.get(0);
    }

}