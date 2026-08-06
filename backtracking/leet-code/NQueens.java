import java.util.Arrays;

public class NQueens {
    public static void main(String[] args) {
        boolean[][] board = new boolean[4][4];
        System.out.println("Possible ways: " + getPossibleQueenPositions(board, 0));
    }

    static int getPossibleQueenPositions(boolean[][] board, int r) {
        if(r == board.length-1) {
            displayBoard(board);
            return 1;
        }
        return 0;
    }

    static void displayBoard(boolean[][] board) {
        for(boolean[] row: board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
