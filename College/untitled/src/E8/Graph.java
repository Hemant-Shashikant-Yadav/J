import java.util.Arrays;

public class Graph {
    final int numVertices = 5;
    int[] nodeColors;

    boolean isSafe(int v, int[][] adjacencyMatrix, int[] colors, int currentColor) {
        for (int i = 0; i < numVertices; i++)
            if (adjacencyMatrix[v][i] == 1 && currentColor == colors[i])
                return false;
        return true;
    }

    boolean colorGraphUtil(int[][] adjacencyMatrix, int numOfColors, int[] colors, int v) {
        if (v == numVertices)
            return true;

        for (int currentColor = 1; currentColor <= numOfColors; currentColor++) {
            if (isSafe(v, adjacencyMatrix, colors, currentColor)) {
                colors[v] = currentColor;
                if (colorGraphUtil(adjacencyMatrix, numOfColors, colors, v + 1))
                    return true;
                colors[v] = 0;
            }
        }
        return false;
    }

    void printColoring(int colors[]) {
        System.out.println("Coloring scheme for vertices:");
        for (int i = 0; i < numVertices; i++)
            System.out.println(colors[i]);
    }

    boolean colorGraph(int[][] adjacencyMatrix, int numOfColors) {
        nodeColors = new int[numVertices];
        Arrays.fill(nodeColors, 0);

        if (!colorGraphUtil(adjacencyMatrix, numOfColors, nodeColors, 0)) {
            System.out.println("Coloring scheme not possible");
            return false;
        }

        printColoring(nodeColors);
        return true;
    }

    public static void main(String args[]) {
        Graph graph = new Graph();

        int[][] adjacencyMatrix = {
                {0, 1, 1, 1, 0},
                {1, 0, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0}
        };

        int numOfColors = 4;
        graph.colorGraph(adjacencyMatrix, numOfColors);
    }
}
