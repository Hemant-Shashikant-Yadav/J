package E9;

public class N_Queen {
    final int boardSize = 5;

    void printBoard(int[][] chessBoard) {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (chessBoard[i][j] == 1)
                    System.out.print("Q ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
    }

    boolean isSafe(int[][] chessBoard, int row, int col) {
        int i, j;

        for (i = 0; i < col; i++)
            if (chessBoard[row][i] == 1)
                return false;

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (chessBoard[i][j] == 1)
                return false;

        for (i = row, j = col; j >= 0 && i < boardSize; i++, j--)
            if (chessBoard[i][j] == 1)
                return false;

        return true;
    }

    boolean solveNQueensUtil(int[][] chessBoard, int col) {
        if (col >= boardSize)
            return true;

        for (int i = 0; i < boardSize; i++) {
            if (isSafe(chessBoard, i, col)) {
                chessBoard[i][col] = 1;

                if (solveNQueensUtil(chessBoard, col + 1))
                    return true;

                chessBoard[i][col] = 0;
            }
        }
        return false;
    }

    boolean solveNQueens() {
        int[][] chessBoard = {
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 }
        };

        if (!solveNQueensUtil(chessBoard, 0)) {
            System.out.print("Solution does not exist");
            return false;
        }

        printBoard(chessBoard);
        return true;
    }

    public static void main(String args[]) {
        N_Queen queensSolver = new N_Queen();
        queensSolver.solveNQueens();
    }
}
