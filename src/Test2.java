import java.util.*;

class Test2 {
    static void addEdge(Vector<Integer> adj[],
                        int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    static int DFSUtil(int u, Vector<Integer> adj[],
                       Vector<Boolean> visited) {
        visited.add(u, true);
        int sz = 1;

        for (int i = 0; i < adj[u].size(); i++)
            if (visited.get(adj[u].get(i)) == false)
                sz += DFSUtil(adj[u].get(i),
                        adj, visited);
        return sz;
    }
    static int largestTree(Vector<Integer> adj[],
                           int V) {
        Vector<Boolean> visited = new Vector<>();
        for (int i = 0; i < V; i++) {
            visited.add(false);
        }
        int answer = 0;

        for (int u = 0; u < V; u++) {
            if (visited.get(u) == false) {
                // Find the answer
                answer = Math.max(answer,
                        DFSUtil(u, adj, visited));
            }
        }
        return answer;
    }

    // Driver code
    public static void main(String[] args) {
        int V = 5;
        Vector<Integer> adj[] = new Vector[V];
        for (int i = 0; i < adj.length; i++)
            adj[i] = new Vector<Integer>();
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 3, 4);
        System.out.print(largestTree(adj, V));
    }
}

// This code is contributed by Rajput-Ji
