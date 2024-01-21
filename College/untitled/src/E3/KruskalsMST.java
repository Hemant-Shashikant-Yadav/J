package CollegeDAA.E3;

import java.util.*;

class KruskalsAlgorithm {
    static class Edge implements Comparable<Edge> {
        int vertex1, vertex2, weight;

        Edge(int v1, int v2, int w) {
            vertex1 = v1;
            vertex2 = v2;
            weight = w;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    static class DisjointSet {
        Map<Integer, Integer> parent = new HashMap<>();

        void makeSet(int vertex) {
            parent.put(vertex, vertex);
        }

        int find(int vertex) {
            if (parent.get(vertex) == vertex) {
                return vertex;
            }
            parent.put(vertex, find(parent.get(vertex)));
            return parent.get(vertex);
        }

        void union(int vertex1, int vertex2) {
            int root1 = find(vertex1);
            int root2 = find(vertex2);

            if (root1 != root2) {
                parent.put(root1, root2);
            }
        }
    }

    static List<Edge> kruskalsAlgorithm(List<Edge> edges, int numVertices) {
        List<Edge> minimumSpanningTree = new ArrayList<>();
        DisjointSet disjointSet = new DisjointSet();

        for (int i = 1; i <= numVertices; i++) {
            disjointSet.makeSet(i);
        }

        Collections.sort(edges);

        for (Edge edge : edges) {
            int vertex1 = edge.vertex1;
            int vertex2 = edge.vertex2;

            if (disjointSet.find(vertex1) != disjointSet.find(vertex2)) {
                minimumSpanningTree.add(edge);
                disjointSet.union(vertex1, vertex2);
            }
        }

        return minimumSpanningTree;
    }

    public static void main(String[] args) {
        // Example usage
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(1, 2, 4));
        edges.add(new Edge(1, 4, 6));
        edges.add(new Edge(2, 4, 5));
        edges.add(new Edge(2, 3, 2));
        edges.add(new Edge(3, 4, 3));

        int numVertices = 4;

        List<Edge> minimumSpanningTree = kruskalsAlgorithm(edges, numVertices);

        System.out.println("Minimum Spanning Tree:");
        for (Edge edge : minimumSpanningTree) {
            System.out.println(edge.vertex1 + " -- " + edge.vertex2 + " : " + edge.weight);
        }
    }
}
