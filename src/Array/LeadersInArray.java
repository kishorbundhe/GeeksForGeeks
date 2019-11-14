package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* Given an array of positive integers. Your task is to find the leaders in the array.
Note: An element of array is leader if it is greater than or equal to all the elements to its right side.
Also, the rightmost element is always a leader.
 */
public class LeadersInArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            String[] inputline = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputline[i]);
            }
            Leader obj = new Leader();
            StringBuffer str = new StringBuffer();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = Leader.leaders(arr, n);
            for (int i : res) {
                str.append(i + " ");
            }
            System.out.println(str);
        }
    }
}

class Leader {
    static ArrayList<Integer> leaders(int[] arr, int n) {
        ArrayList<Integer> leaders = new ArrayList<Integer>();
        int i = 0, leader, size;
        size = arr.length;
        leader = arr[size - 1];
        leaders.add(arr[size - 1]);
        for (i = size - 2; i >= 0; i--) {
            if (arr[i] >= leader) {
                leader = arr[i];
                leaders.add(leader);
            }
        }
        Collections.reverse(leaders);
        return leaders;
    }
}
