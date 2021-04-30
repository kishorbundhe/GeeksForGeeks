package upgrad;

import java.util.*;

public class FindIternary {

    public static void findItinerary(Map<String, String> tickets) {
        Set<String> sourceSet = new HashSet<>(tickets.keySet());
        ArrayList<String> destinationList = new ArrayList<>(tickets.values());
        for (String temp : destinationList) {
            sourceSet.remove(temp);
        }
        String source = (String) sourceSet.toArray()[0];
        String destination;
        if (tickets.get(source) == null) {
            System.out.println("Invalid Input");
            return;
        }

        while (tickets.containsKey(source)) {
            destination = tickets.get(source);
            System.out.println(source + "->" + destination);
            source = destination;
        }

    }

    public static void main(String[] args) {
        Map<String, String> tickets = new HashMap<String, String>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            tickets.put(sc.next(), sc.next());
        }
        findItinerary(tickets);
    }
}