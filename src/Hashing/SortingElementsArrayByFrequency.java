package Hashing;

/*Given an array A[] of integers, sort the array according to frequency of elements.
 That is elements that have higher frequency come first. If frequencies of two elements are same, then smaller number comes first.*/

import java.util.*;

class keyValue implements Comparator<keyValue> {
    int data;
    int value;

    public keyValue() {

    }

    public keyValue(int data, int value) {
        this.data = data;
        this.value = value;
    }

    @Override
    public int compare(keyValue o1, keyValue o2) {
        return o2.value - o1.value;
    }
}

public class SortingElementsArrayByFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int temp;
            HashMap<Integer, Integer> frequencyMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                temp = sc.nextInt();
                if (frequencyMap.containsKey(temp)) {
                    frequencyMap.put(temp, frequencyMap.get(temp) + 1);
                } else {
                    frequencyMap.put(temp, 1);
                }
            }
            ArrayList<keyValue> objectList = new ArrayList<>();
            for (Map.Entry<Integer, Integer> e : frequencyMap.entrySet()) {
                objectList.add(new keyValue(e.getKey(), e.getValue()));

            }
            objectList.sort(new keyValue());
            StringBuilder sb = new StringBuilder();
            for (keyValue x : objectList) {
                temp = x.value;
                while (temp-- > 0) {
                    sb.append(x.data + " ");
                }
            }
            System.out.println(sb.toString().trim());
        }
    }
}
