package practice;

import java.util.*;

class LongestTree {

    static void addEdge(ArrayList<ArrayList<Integer>> adj,
                        int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static int DFSUtil(int u, ArrayList<ArrayList<Integer>> adj,
                       List<Boolean> visited) {
        visited.add(u, true);
        int sz = 1;

        List<Integer> children = adj.get(u);

        for (int i = 0; i < children.size(); i++) {
            if (!visited.get(children.get(i))) {
                sz += DFSUtil(children.get(i),
                        adj, visited);
            }
        }

        return sz;
    }

    static int largestTree(ArrayList<ArrayList<Integer>> adj,
                           int V) {
        ArrayList<Boolean> visited = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            visited.add(false);
        }
        int answer = 0;

        for (int u = 0; u < V; u++) {
            if (!visited.get(u)) {
                answer = Math.max(answer,
                        DFSUtil(u, adj, visited));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 3, 4);
        System.out.println(adj);
        System.out.print(largestTree(adj, V));
    }
}