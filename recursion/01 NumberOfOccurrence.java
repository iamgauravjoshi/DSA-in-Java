/*
Problem: Number of Occurrence
Given a sorted array arr[] and a number target, find the number of occurrences of target in given array. 

# Example 01:
Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
Output: 4
Explanation: target = 2 occurs 4 times in the given array so the output is 4.

# Example 02:
Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 4
Output: 0
Explanation: target = 4 is not present in the given array so the output is 0.

# Example 03:
Input: arr[] = [8, 9, 10, 12, 12, 12], target = 12
Output: 3
Explanation: target = 12 occurs 3 times in the given array so the output is 3.

# Constraints:
    -> 1 ≤ arr.size() ≤ 106
    -> 1 ≤ arr[i] ≤ 106
    -> 1 ≤ target ≤ 106
 */

class NumberOfOccurrences {

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2, 2, 2, 2, 3};
        int[] nums2 = {8, 9, 10, 12, 12, 12};

        System.out.println("2 -> " + countFreq(nums1, 2));
        System.out.println("4 -> " + countFreq(nums1, 4));
        System.out.println("12 -> " + countFreq(nums2, 12));
    }

    public static int countFreq(int[] nums, int target) {
        return solve(nums, target, 0, 0);
    }

    private static int solve(int[] nums, int target, int index, int count) {
        if (index >= nums.length) {
            return count;
        }

        if (nums[index] == target) {
            count++;
        }

        return solve(nums, target, index + 1, count);
    }
}
