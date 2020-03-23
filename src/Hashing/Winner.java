package Hashing;

import java.util.*;

/*
Given an array of names (consisting of lowercase characters) of candidates in an election.
A candidate name in array represents a vote casted to the candidate.
Print the name of candidate that received Max votes. If there is tie, print lexicographically smaller name.
*/
public class Winner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String[] arr = new String[n];

            for (int i = 0; i < n; i++)
                arr[i] = sc.next();
            winner(arr, n);
            System.out.println();
        }
    }

    static void winner(String[] arr, int n) {
        int i = 0, maxCount = 0;
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, Integer> frequencyMap = new HashMap<>();
        for (; i < n; i++) {
            if (frequencyMap.containsKey(arr[i])) {
                frequencyMap.put(arr[i], frequencyMap.get(arr[i]) + 1);
            } else {
                frequencyMap.put(arr[i], 1);
            }
        }
        for (Map.Entry<String, Integer> mapElement : frequencyMap.entrySet()) {
            if (maxCount < mapElement.getValue()) {
                maxCount = mapElement.getValue();
                list.clear();
                list.add(mapElement.getKey());
            } else if (maxCount == mapElement.getValue()) {
                list.add(mapElement.getKey());
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0) + " " + maxCount);
    }
}

