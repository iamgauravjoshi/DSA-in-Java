/*
Given a sorted array arr[] and an integer x, find the index (0-based) of the largest element in arr[] that is less than or equal to x. This element is called the floor of x. If such an element does not exist, return -1.
Note: In case of multiple occurrences of floor of x, return the index of the last occurrence.

# Example 1:
Input: arr[] = [1, 2, 8, 10, 10, 12, 19], x = 5
Output: 1
Explanation: Largest number less than or equal to 5 is 2, whose index is 1.

# Example 2:
Input: arr[] = [1, 2, 8, 10, 10, 12, 19], x = 11
Output: 4
Explanation: Largest Number less than or equal to 11 is 10, whose indices are 3 and 4. The index of last occurrence is 4.

# Example 3:
Input: arr[] = [1, 2, 8, 10, 10, 12, 19], x = 0
Output: -1
Explanation: No element less than or equal to 0 is found. So, output is -1.

# Constraints:-
    1 ≤ arr.size() ≤ 106
    1 ≤ arr[i] ≤ 106
    0 ≤ x ≤ arr[n-1]
 */

class FloorOfAnElement {

    public static void main(String[] args) {
        FloorOfAnElement s = new FloorOfAnElement();
        int[] arr1 = {1, 2, 8, 10, 10, 12, 19};
        int[] arr2 = {1, 3, 5, 6};

        System.out.println(s.findFloor(arr1, 5));
        System.out.println(s.findFloor(arr1, 11));
        System.out.println(s.findFloor(arr1, 0));

        System.out.println();

        System.out.println(s.findFloor(arr2, 5));
        System.out.println(s.findFloor(arr2, 2));
        System.out.println(s.findFloor(arr2, 7));
    }

    public int findFloor(int[] arr, int target) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;
    }
}
