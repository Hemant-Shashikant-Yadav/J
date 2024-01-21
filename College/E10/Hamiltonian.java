package E10;

public class Hamiltonian {
    final int numVertices = 6;
    int[] cyclePath;

    boolean isSafe(int v, int[][] graph, int[] path, int pos) {
        if (graph[path[pos - 1]][v] == 0)
            return false;

        for (int i = 0; i < pos; i++)
            if (path[i] == v)
                return false;

        return true;
    }

    boolean hamCycleUtil(int[][] graph, int[] path, int pos) {
        if (pos == numVertices) {
            if (graph[path[pos - 1]][path[0]] == 1)
                return true;
            else
                return false;
        }

        for (int v = 1; v < numVertices; v++) {
            if (isSafe(v, graph, path, pos)) {
                path[pos] = v;

                if (hamCycleUtil(graph, path, pos + 1))
                    return true;

                path[pos] = -1;
            }
        }

        return false;
    }

    int hamCycle(int[][] graph) {
        cyclePath = new int[numVertices];
        for (int i = 0; i < numVertices; i++)
            cyclePath[i] = -1;

        cyclePath[0] = 0;
        if (hamCycleUtil(graph, cyclePath, 1) == false) {
            System.out.println("\nSolution does not exist");
            return 0;
        }

        printSolution(cyclePath);
        return 1;
    }

    void printSolution(int path[]) {
        System.out.println("Solution Exists: Hamiltonian Cycle");
        for (int i = 0; i < numVertices; i++)
            System.out.print(" " + path[i] + " ");

        System.out.println(" " + path[0] + " ");
    }

    public static void main(String args[]) {
        Hamiltonian solver = new Hamiltonian();

        int graph1[][] = {
                {0, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 1},
                {1, 1, 0, 0, 1, 1},
                {0, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 0},
        };

        solver.hamCycle(graph1);


    }
}
