package E7;

import java.util.*;

class DFS {
    private LinkedList<Integer> adjacencyLists[];
    private boolean visited[];

    DFS(int vertices) {
        adjacencyLists = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            adjacencyLists[i] = new LinkedList<Integer>();
    }

    void addEdge(int source, int destination) {
        adjacencyLists[source].add(destination);
    }

    void depthFirstSearch(int startVertex) {
        visited[startVertex] = true;
        System.out.print(startVertex + " ");

        Iterator<Integer> iterator = adjacencyLists[startVertex].listIterator();
        while (iterator.hasNext()) {
            int adjacent = iterator.next();
            if (!visited[adjacent])
                depthFirstSearch(adjacent);
        }
    }

    public static void main(String args[]) {
        DFS graph = new DFS(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);

        System.out.println("DFS Traversal from vertex 2:");
        graph.depthFirstSearch(2);
    }
}
