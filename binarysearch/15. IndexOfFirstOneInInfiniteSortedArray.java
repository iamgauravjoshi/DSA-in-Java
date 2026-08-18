/*
Problem: Find the index of first 1 in an infinite sorted array of 0s and 1s
Given an infinite sorted array consisting 0s and 1s. The problem is to find the index of first ‘1’ in that array. As the array is infinite, therefore it is guaranteed that number '1' will be present in the array.

# Example 1:
Input : arr[] = {0, 0, 1, 1, 1, 1} 
Output : 2

# Example 2:
Input : arr[] = {1, 1, 1, 1,, 1, 1}
Output : 0
 */

import java.util.List;

class IndexOfFirstOneInInfiniteSortedArray {

    public static void main(String[] args) {
        List<Integer> arr1 = List.of(0, 0, 0, 1, 1, 1);
        List<Integer> arr2 = List.of(0, 0, 0, 0, 0, 0, 0, 0, 0);
        List<Integer> arr3 = List.of(1, 1, 1, 1, 1, 1);

        System.out.println(posOfFirstOne(arr1));
        System.out.println(posOfFirstOne(arr2));
        System.out.println(posOfFirstOne(arr3));
    }

    // Exponential Search (also called Doubling Search) to find boundries
    static int posOfFirstOne(List<Integer> arr) {
        int low = 0, high = 1;
        int n = arr.size();

        while (high < n && arr.get(high) != 1) {
            low = high;
            high = high * 2;
        }

        high = Math.min(high, n - 1);

        return indexOfFirstOne(arr, low, high);
    }

    // Iterative Binary Search to find lower index of 1
    static int indexOfFirstOne(List<Integer> arr, int low, int high) {
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr.get(mid) == 1) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
