import java.util.ArrayList;

public class MazeProblemDiagonal {
    public static void main(String[] args) {
        int i = 3;
        int j = 3;

        System.out.println("Total ways: " + countAllPaths(i, j));
        System.out.println("\n");
        System.out.println(getPossiblePathsList("", i, j));
        System.out.println("\n");
        printPossiblePaths("", i, j);
    }

    /* ------- Get list of possible paths to reach destination, including diagonal ------- */
    static ArrayList<String> getPossiblePathsList(String ps, int i, int j) {
        if(i==1 && j==1) {
            ArrayList<String> tempList = new ArrayList<>();
            tempList.add(ps);
            return tempList;
        }

        ArrayList<String> list = new ArrayList<>();

        // Down direction
        if(i>1) {
            list.addAll(getPossiblePathsList(ps+'D', i-1, j));
        }

        // Right direction
        if(j>1) {
            list.addAll(getPossiblePathsList(ps+'R', i, j-1));
        }

        // Diagonal
        if(i>1 && j>1) {
            list.addAll(getPossiblePathsList(ps+'C', i-1, j-1));
        }

        return list;
    }

    /* ------- Count total ways to reach the final destination, including diagonal ------- */
    static int countAllPaths(int i, int j) {
        if(i==1 || j==1) {
            return 1;
        }

        int down = countAllPaths(i-1, j);
        int diagonal = countAllPaths(i-1, j-1);
        int right = countAllPaths(i, j-1);

        return down + right + diagonal;
    }

    /* ------- Print possible paths to reach destination, including diagonal ------- */
    static void printPossiblePaths(String ps, int i, int j) {
        if(i==1 && j==1) {
            System.out.println(ps);
            return;
        }

        // Down direction
        if(i>1) {
            printPossiblePaths(ps+'D', i-1, j);
        }

        // Right direction
        if(j>1) {
            printPossiblePaths(ps+'R', i, j-1);
        }

        // Diagonal
        if(i>1 && j>1) {
            printPossiblePaths(ps+'C', i-1, j-1);
        }
    }
}