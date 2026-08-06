import java.util.ArrayList;

public class MazeAllDirection {
    public static void main(String[] args) {        
        int i = 0;
        int j = 0;
        boolean[][] maze = {
            {true, true, true},
            {true, true, true},
            {true, true, true},
        };

        System.out.println("Total ways: " + countPathsWithObstacle(i, j, maze));
        System.out.println("\n");
        System.out.println("List: " + getPossiblePathsList("", maze, i, j));
        System.out.println("\n");
        printPossiblePaths("", maze, i, j);
    }

    /* ------- Get list of possible paths to reach destination, not diagonal and with restriction ------- */
    static ArrayList<String> getPossiblePathsList(String ps, boolean[][] maze, int i, int j) {
        if(i==maze.length-1 && j==maze[0].length-1) {
            ArrayList<String> tempList = new ArrayList<>();
            tempList.add(ps);
            return tempList;
        }

        ArrayList<String> list = new ArrayList<>();

        if(maze[i][j] == false) {
            return list;
        }

        // Mark the previous step as FALSE
        maze[i][j] = false;

        // Down direction
        if(i < maze.length-1) {
            list.addAll(getPossiblePathsList(ps+'D', maze, i+1, j));
        }

        // Right direction
        if(j < maze[0].length-1) {
            list.addAll(getPossiblePathsList(ps+'R', maze, i, j+1));
        }

        // Up direction
        if(i > 0) {
            list.addAll(getPossiblePathsList(ps+'U', maze, i-1, j));
        }

        // Left direction
        if(j > 0) {
            list.addAll(getPossiblePathsList(ps+'L', maze, i, j-1));
        }

        // Diagonal
        // if(i < maze.length-1 && j < maze[0].length-1) {
        //     list.addAll(getPossiblePathsList(ps+'C', maze, i+1, j+1));
        // }

        // Mark the current step as TRUE
        maze[i][j] = true;

        return list;
    }

    /* ------- Count total ways to reach the final destination, not diagonal and with obstacle ------- */
    static int countPathsWithObstacle(int i, int j, boolean[][] maze) {
        if(i==maze.length-1 && j==maze[0].length-1) {
            return 1;
        }

        int count = 0;

        if(maze[i][j] == false) {
            return count;
        }

        maze[i][j] = false;

        // Down direction
        if(i < maze.length-1) {
            count += countPathsWithObstacle(i+1, j, maze);
        }

        // Right direction
        if(j < maze[0].length-1) {
            count += countPathsWithObstacle(i, j+1, maze);
        }

        // Up direction
        if(i > 0) {
            count += countPathsWithObstacle(i-1, j, maze);
        }

        // Left direction
        if(j > 0) {
            count += countPathsWithObstacle(i, j-1, maze);
        }

        // Diagonal
        // if(i < maze.length-1 && j < maze[0].length-1) {
        //     count += countPathsWithObstacle(i+1, j+1, maze);
        // }

        maze[i][j] = true;

        return count;
    }

    /* ------- Print possible paths to reach destination, not diagonal and with obstacle ------- */
    static void printPossiblePaths(String ps, boolean[][] maze, int i, int j) {
        if(i==maze.length-1 && j==maze[0].length-1) {
            System.out.println(ps);
            return;
        }

        if(maze[i][j] == false) {
            return;
        }

        maze[i][j] = false;

        // Down direction
        if(i < maze.length-1) {
            printPossiblePaths(ps+'D', maze, i+1, j);
        }

        // Right direction
        if(j < maze[0].length-1) {
            printPossiblePaths(ps+'R', maze, i, j+1);
        }

        // Up direction
        if(i > 0) {
            printPossiblePaths(ps+'U', maze, i-1, j);
        }

        // Left direction
        if(j > 0) {
            printPossiblePaths(ps+'L', maze, i, j-1);
        }

        // Diagonal
        // if(i < maze.length-1 && j < maze[0].length-1) {
        //     printPossiblePaths(ps+'C', maze, i+1, j+1);
        // }

        maze[i][j] = true;
    }

}
