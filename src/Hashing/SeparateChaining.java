package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*

Separate chaining technique in hashing allows to us to use a linked list at each hash slot to handle the problem of collisions.
That is, every slot of the hash table is a linked list,so whenever a collision occurs, the element can be append as a node to the linked list at the slot.

* */
public class SeparateChaining {
    public static void main(String[] args) throws IOException {
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while (t-- > 0) {
            int hashSize = Integer.parseInt(br.readLine().trim());
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(hashSize);
            for (int i = 0; i < hashSize; i++) {
                res.add(new ArrayList<Integer>());
            }
            separateChaining(arr, n, res, hashSize);
            for (int i = 0; i < res.size(); i++) {
                if (res.get(i).size() > 0) {
                    System.out.print(i + "->");
                    for (int j = 0; j < res.get(i).size() - 1; j++) {
                        System.out.print(res.get(i).get(j) + "->");
                    }
                    System.out.print(res.get(i).get(res.get(i).size() - 1));
                    System.out.println();
                }
            }
        }
    }

    public static void separateChaining(int[] arr, int n, ArrayList<ArrayList<Integer>> hashTable, int hashSize) {
        int index = 0;

        for (int i = 0; i < n; i++) {

            index = arr[i] % hashSize;
            if (hashTable.get(index) == null) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(arr[i]);
                hashTable.add(index, temp);
            } else {
                hashTable.get(index).add(arr[i]);
            }
        }
    }
}
