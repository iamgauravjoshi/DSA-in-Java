/*
Problem: Find Peak Element
A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

# NOTE: You must write an algorithm that runs in O(log n) time.

# Example 1:
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.

# Example 2:
Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.

# Constraints:
    -> 1 <= nums.length <= 1000
    -> -231 <= nums[i] <= 231 - 1
    -> nums[i] != nums[i + 1] for all valid i.
 */

class FindPeakElement {

    public static void main(String[] args) {
        int[] arr1 = {80, 70, 60, 50, 40, 30, 20, 10};
        int[] arr2 = {10, 20, 15, 2, 23, 90, 80};
        int[] arr3 = {1, 2, 3, 5, 6, 4};

        System.out.println(findPeakElement(arr1));
        System.out.println(findPeakElement(arr2));
        System.out.println(findPeakElement(arr3));
    }

    static int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int peakElement(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        // If there is only one element, it is always a peak
        if (n == 1) {
            return 0;
        }

        // Binary search for a peak element
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is not a boundary element
            if (mid > 0 && mid < n - 1) {

                // If nums[mid] is greater than both neighbors,
                // then mid is a peak element
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid;

                    // If the left neighbor is greater,
                    // move towards the left side
                } else if (nums[mid] < nums[mid - 1]) {
                    high = mid - 1;

                    // If the right neighbor is greater,
                    // move towards the right side
                } else if (nums[mid] < nums[mid + 1]) {
                    low = mid + 1;

                    // In this case, move towards the right
                } else {
                    low = mid + 1;
                }

                // If mid is the first element
            } else if (mid == 0) {

                // If it is greater than the next element,
                // then it is a peak
                if (nums[0] > nums[1]) {
                    return 0;
                } else {
                    // Otherwise, the next element is a peak
                    return 1;
                }

                // If mid is the last element
            } else if (mid == n - 1) {

                // If it is greater than the previous element,
                // then it is a peak
                if (nums[n - 1] > nums[n - 2]) {
                    return n - 1;
                } else {
                    // Otherwise, the previous element is a peak
                    return n - 2;
                }
            }
        }

        // No peak found (should not happen for a valid input)
        return -1;
    }
}
