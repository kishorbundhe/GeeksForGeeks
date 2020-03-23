package Competition;


import java.io.InputStreamReader;
import java.util.*;

public class TopProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            int maxCount = 0;
            int n = Integer.parseInt(sc.nextLine().trim());
            HashMap<String, Integer> frequencyMap = new HashMap<>();

            StringBuilder sb = new StringBuilder();
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String string = sc.nextLine().trim();
                if (string.equals("top")) {
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
                    for (String l :
                            list) {
                        sb.append(l + " ");
                    }
                    sb.append("\n");
                    list.clear();
                } else {
                    String[] stringNameQuantity = string.trim().split(" ");

                    if (frequencyMap.containsKey(stringNameQuantity[0])) {
                        frequencyMap.put(stringNameQuantity[0], frequencyMap.get(stringNameQuantity[0]) + Integer.parseInt(stringNameQuantity[1]));
                    } else {
                        frequencyMap.put(stringNameQuantity[0], Integer.parseInt(stringNameQuantity[1]));
                    }
                }
            }

            System.out.print(sb.toString());
        }
    }
}

