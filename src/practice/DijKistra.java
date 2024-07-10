package practice;

import java.util.*;
import java.util.stream.Collectors;

public class DijKistra {
    public static void main(String[] args) {
        int V = 9;
        Graph g = new Graph(V);

        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);
        shortestDistanceFromSource(0,g);
    }


    static class Graph {
        int V;
        List<List<Pair>> adjacency;

        public Graph(int V) {
            this.V = V;
            adjacency = new ArrayList<>();
            for(int i=0;i<V;i++){
                adjacency.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v, int w) {
            adjacency.get(u).add(new Pair(v, w));
            adjacency.get(v).add(new Pair(u, w));
        }
    }

    static class Pair {
        int vertex;
        int weight;

        public Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static int[] shortestDistanceFromSource(int src, Graph graph) {
        int[] distanceFromSource = new int[graph.V];
        Arrays.fill(distanceFromSource, Integer.MAX_VALUE);
        distanceFromSource[src] = 0;
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(i -> i.weight));
        queue.add(new Pair(src, 0));

        while (!queue.isEmpty()) {
            int u = queue.poll().vertex;
            List<Pair> connectedVertices = graph.adjacency.get(u);

            for (Pair v : connectedVertices) {
                if (distanceFromSource[v.vertex] > distanceFromSource[u] + v.weight) {
                    distanceFromSource[v.vertex] = distanceFromSource[u] + v.weight;
                    queue.add(new Pair(v.vertex, distanceFromSource[v.vertex]));
                }
            }
        }
        System.out.println(Arrays.stream(distanceFromSource).boxed().collect(Collectors.toList()));
        return distanceFromSource;
    }
}
