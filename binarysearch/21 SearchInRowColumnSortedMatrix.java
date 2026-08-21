/*
Problem: Search in a Row-Column Sorted
Given a 2D integer matrix mat[][] of size n x m, where every row and column is sorted in increasing order and a number x, return true if the element x is present in the matrix. Otherwise, return false.

# Example 1:
Input: mat[][] = [[3, 30, 38], [20, 52, 54], [35, 60, 69]], x = 62
Output: false
Explanation: 62 is not present in the matrix, so output is false.

# Example 2:
Input: mat[][] = [[18, 21, 27],  [38, 55, 67]], x = 55
Output: true
Explanation: 55 is present in the matrix.

# Example 3:
Input: mat[][] = [[1, 2, 3], [4, 5, 6], [7, 8, 9]], x = 3
Output: true
Explanation: 3 is present in the matrix.

# Constraints:
    -> 1 ≤ n, m ≤ 103
    -> 1 ≤ mat[i][j] ≤ 109
    -> 1 ≤ x ≤ 109
 */

class SearchInRowColumnSortedMatrix {

    public static void main(String[] args) {
        int[][] matrix1 = {{3, 30, 38}, {20, 52, 54}, {35, 60, 69}};
        int[][] matrix2 = {{18, 21, 27, 32}, {25, 38, 55, 67}};
        int[][] matrix3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println("Matrix 1:");
        System.out.println(matrixSearch(matrix1, 20));
        System.out.println(matrixSearch(matrix1, 13));

        System.out.println("Matrix 2:");
        System.out.println(matrixSearch(matrix2, 55));

        System.out.println("Matrix 3:");
        System.out.println(matrixSearch(matrix3, 3));
    }

    public static boolean matrixSearch(int[][] mat, int target) {
        int row = 0;
        int col = mat[0].length - 1;

        while (row < mat.length && col >= 0) {
            if (mat[row][col] == target) {
                return true;
            }

            if (target < mat[row][col]) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }
}
