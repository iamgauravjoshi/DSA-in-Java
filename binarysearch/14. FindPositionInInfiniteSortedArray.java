/*
Problem: Find position of an element in a sorted array of infinite numbers
Given a sorted array arr[] of infinite numbers. The task is to search for an element k in the array.

# Example 1:
Input: arr[] = [3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170], k = 10
Output: 4
Explanation: 10 is at index 4 in array.

# Example 2:
Input: arr[] = [2, 5, 7, 9], k = 3
Output: -1
Explanation: 3 is not present in array.
 */

import java.util.List;

class FindPositionInInfiniteSortedArray {

    public static void main(String[] args) {
        List<Integer> arr = List.of(3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170);
        int target = 170;
        int result = findPos(arr, target);
        System.out.println(result);
    }

    // Exponential Search (also called Doubling Search) to find boundries
    static int findPos(List<Integer> arr, int target) {
        // If target is at the first position
        if (arr.get(0) == target) {
            return 0;
        }

        // Find the range using exponential expansion
        int start = 0, end = 1;
        int n = arr.size();

        while (end < n && target > arr.get(end)) {
            start = end;
            end = end * 2;
        }

        // Make sure high doesn't go outside the array
        end = Math.min(end, n - 1);

        // Binary search within the identified range
        return binarySearch(arr, target, start, end);
    }

    // Iterative Binary Search
    static int binarySearch(List<Integer> arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr.get(mid)) {
                return mid;
            }

            if (target < arr.get(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
