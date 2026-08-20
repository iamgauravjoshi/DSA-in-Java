/*
Problem: Find an element in Bitonic array/Mountain array
Given a bitonic sequence of n distinct elements, and an integer x, the task is to write a program to find given element x in the bitonic sequence in O(log n) time. 

NOTE: A Bitonic Sequence is a sequence of numbers that is first strictly increasing then after a point decreasing.

# Example 1:
Input :  arr[] = {-3, 9, 18, 20, 17, 5, 1}, key = 20
Output : Found at index 3

# Example 2:
Input :  arr[] = {5, 6, 7, 8, 9, 10, 3, 2, 1}, key = 30
Output : Not Found
 */

class SearchInBitonicArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 3, 1};
        int[] nums2 = {10, 20, 30, 40, 50};
        int[] nums3 = {18, 29, 38, 59, 98, 100, 99, 98, 90};
        int[] nums4 = {-8, 2, 3, 4, 5, -2, -3};

        System.out.print("nums 1: ");
        System.out.print(searchInBitonicArray(nums1, 3));
        System.out.print(", ");
        System.out.println(searchInBitonicArray(nums1, 7));
        System.out.print("\nnums 2: ");
        System.out.println(searchInBitonicArray(nums2, 40));
        System.out.print("\nnums 3: ");
        System.out.println(searchInBitonicArray(nums3, 66));
        System.out.print("\nnums 4: ");
        System.out.println(searchInBitonicArray(nums4, 5));
    }

    /*
        Yes. A nice improvement over your original solution is to use the boundary values to decide whether a half can possibly contain the target.

        For a bitonic array:
                     peak
                      ↓
                /-------------\
               /               \
              /                 \
             /                   \
        arr[0]                 arr[n-1]

        -> Left half [0 ... peak] is ascending.
        -> Right half [peak+1 ... n-1] is descending.
        Therefore:
            -> Left half contains values in the range [arr[0], arr[peak]].
            -> Right half contains values in the range [arr[n-1], arr[peak]].

        So before searching a half, we can check whether target is even within that half's value range.
     */
    static int searchInBitonicArray(int[] arr, int target) {
        int peak = findBitonicPoint(arr);

        if (target == arr[peak]) {
            return peak;
        }

        // Target is greater than maximum -> impossible
        if (target > arr[peak]) {
            return -1;
        }

        // Search left if target can exist there
        if (target >= arr[0]) {
            int result = ascendingBinarySearch(arr, target, 0, peak);

            if (result != -1) {
                return result;
            }
        }

        // Search right if target can exist there
        if (target >= arr[arr.length - 1]) {
            return descendingBinarySearch(arr, target, peak + 1, arr.length - 1);
        }

        return -1;
    }

    static int findBitonicPoint(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }

    static int ascendingBinarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    static int descendingBinarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
