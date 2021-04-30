package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class AllPathFromSourceToTarget {
    static int count = 0;

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.substring(1, str.length() - 1);
        int target = 3;
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (Character.isDigit(c)) {
                temp.add(Character.getNumericValue(c));
            }
            if (c.equals(']')) {
                graph.add(new ArrayList<>(temp));
                temp.clear();
            }
        }
        System.out.println(graph);
        DFS(graph, 0, 3);
        System.out.println(count);
    }

    private static void DFS(ArrayList<ArrayList<Integer>> graph, int start, int target) {
        int size = graph.size();
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (visited[i] == false)
                DfsRec(graph, start, target, visited);
        }
    }

    private static void DfsRec(ArrayList<ArrayList<Integer>> graph, int start, int target, boolean[] visited) {
        visited[start] = true;
        for (int u : graph.get(start)) {
            if (visited[u] == false) {
                DfsRec(graph, u, target, visited);
            }
            if (u == target && visited[target] == true) {
                count++;
            }
        }
    }

}
