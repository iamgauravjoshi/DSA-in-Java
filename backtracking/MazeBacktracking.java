import java.util.Arrays;

public class MazeBacktracking {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;

        boolean[][] maze = {
            {true, true, true},
            {true, true, true},
            {true, true, true},
        };

        int[][] matrix = new int[maze.length][maze[0].length];

        // System.out.println("List: " + getAllPathsMatrix("", i, j, maze));
        // System.out.println("\n");
        printAllPathsMatrix("", i, j, maze, matrix, 1);
    }
    
    static void printAllPathsMatrix(String ps, int i, int j, boolean[][] maze, int[][] matrix, int steps) {
        // Base condition
        if(i==maze.length-1 && j==maze[0].length-1) {
            matrix[i][j] = steps;
            for(int[] row: matrix) {
                System.out.println(Arrays.toString(row));
            }

            System.out.println();

            return;
        }

        if(maze[i][j] == false) {
            return;
        }

        maze[i][j] = false;
        matrix[i][j] = steps;

        // Down direction
        if(i < maze.length-1) {
            printAllPathsMatrix(ps+"D", i+1, j, maze, matrix, steps+1);
        }

        // Right direction
        if(j < maze[0].length-1) {
            printAllPathsMatrix(ps+"R", i, j+1, maze, matrix, steps+1);
        }

        // Up direction
        if(i > 0) {
            printAllPathsMatrix(ps+"U", i-1, j, maze, matrix, steps+1);
        }

        // Left direction
        if(j > 0) {
            printAllPathsMatrix(ps+"L", i, j-1, maze, matrix, steps+1);
        }

        maze[i][j] = true;
        matrix[i][j] = 0;
    }
}
