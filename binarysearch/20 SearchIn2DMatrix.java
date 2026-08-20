/*
Problem: Search in a Row-Column Sorted Matrix
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

# Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

# Example 2:
Input: matrix = [[18,21,27],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

# Example 3:
Input: matrix = [[18,21,27],[38,55,67]], target = 55
Output: true


# Constraints:
    -> m == matrix.length
    -> n == matrix[i].length
    -> 1 <= m, n <= 100
    -> -104 <= matrix[i][j], target <= 104
 */

class SearchInMatrix {

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int[][] matrix2 = {{18, 21, 27}, {38, 55, 67}};

        System.out.println("Matrix 1:");
        System.out.println(searchMatrix(matrix1, 3));
        System.out.println(searchMatrix(matrix1, 13));

        System.out.println("\n Matrix 2:");
        System.out.println(searchMatrix(matrix2, 30));
        System.out.println(searchMatrix(matrix2, 55));
    }

    static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        // Binary search for the row that may contain target
        int start = 0;
        int end = matrix.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < matrix[mid][0]) {
                end = mid - 1;
            } else if (target > matrix[mid][matrix[mid].length - 1]) {
                start = mid + 1;
            } else {
                // target can only be in this row
                return binarySearch(matrix[mid], target);
            }
        }

        return false;
    }

    static boolean binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
