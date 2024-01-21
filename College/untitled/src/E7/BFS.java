package E7;

import java.util.*;

public class BFS {
    private int numVertices;
    private LinkedList<Integer> adjacencyList[];

    BFS(int vertices) {
        numVertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; ++i)
            adjacencyList[i] = new LinkedList();
    }

    void addEdge(int start, int end) {
        adjacencyList[start].add(end);
    }

    void breadthFirstSearch(int startVertex) {
        boolean visited[] = new boolean[numVertices];
        LinkedList<Integer> queue = new LinkedList();
        visited[startVertex] = true;
        queue.add(startVertex);

        while (queue.size() != 0) {
            startVertex = queue.poll();
            System.out.print(startVertex + " ");

            Iterator<Integer> iterator = adjacencyList[startVertex].listIterator();
            while (iterator.hasNext()) {
                int neighbor = iterator.next();
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String args[]) {
        BFS graph = new BFS(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("BFS Traversal from vertex 1:");
        graph.breadthFirstSearch(1);
    }
}
