package upgrad;

import java.util.LinkedList;
import java.util.Scanner;

public class CheckWhetherUndirectedGraphIsTree {

    private static LinkedList<Integer>[] adj;
    private final int vertexCount;
    private final int edgeCount;

    CheckWhetherUndirectedGraphIsTree(int vertexCount, int edgeCount) {
        this.vertexCount = vertexCount;
        this.edgeCount = edgeCount;
        adj = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; ++i) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Get the number of nodes from the input.
        int noOfNodes = sc.nextInt();
        // Get the number of edges from the input.
        int noOfEdges = sc.nextInt();

        CheckWhetherUndirectedGraphIsTree graph = new CheckWhetherUndirectedGraphIsTree(noOfNodes, noOfEdges);
        // Adding edges to the graph
        for (int i = 0; i < noOfEdges; ++i) {
            graph.addEdge(sc.nextInt(), sc.nextInt());
        }
        if (noOfNodes > 0 && graph.isTree()) {
            System.out.println("Supplied graph is Tree");
        } else {
            System.out.println("Supplied Graph is not Tree");
        }
    }

    public void addEdge(int v, int w) {
        if (!isValidIndex(v) || !isValidIndex(w)) {
            return;
        }
        adj[v].add(w);
        adj[w].add(v);
    }

    private boolean isValidIndex(int i) {
        return i >= 0 && i <= (vertexCount - 1);
    }

    private boolean isCyclic(int v, boolean[] visited, int parent) {
        boolean isCyclic = false;
        isCyclic = DFSRec(v, visited, parent);
        return isCyclic && isConnected(visited);
    }

    public boolean isConnected(boolean[] visited) {
        int length = visited.length;
        for (int i = 0; i < length; i++) {
            return visited[i];
        }
        return false;
    }

    private boolean DFSRec(int v, boolean[] visited, int parent) {
        visited[v] = true;
        for (int u : adj[v]) {
            if (visited[u] == false) {
                return DFSRec(u, visited, v);
            } else if (v != parent)
                return true;

        }
        return false;
    }

    public boolean isTree() {
        // vertex = 6 and edge = 5
        // vertex = 15 and edge = 4
        if (vertexCount - 1 != edgeCount)
            return false;
        else
            return isCyclic(0, new boolean[adj.length], -1);
    }
}
