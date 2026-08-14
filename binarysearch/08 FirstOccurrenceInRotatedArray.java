/*
Problem:- Find the first occurrence index of an element in a sorted rotated array.
Given an array arr[] which can have duplicate elements. It was initially "sorted in ascending order" but then rotated at some unknown pivot, the task is to find the first occurrence index of a target key.  If the key is not present in the array, return -1.
 */

class FirstOccurrenceInRotatedArray {

    public static void main(String[] args) {

        int[] arr1 = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int[] arr2 = {};
        int[] arr3 = {4, 5, 5, 6, 1, 2, 2, 3};
        int[] arr4 = {1, 2, 3, 4, 5};

        System.out.println(findFirstOccurrence(arr1, 8));
        System.out.println(findFirstOccurrence(arr2, 1));
        System.out.println(findFirstOccurrence(arr3, 4));
        System.out.println(findFirstOccurrence(arr3, 2));
        System.out.println(findFirstOccurrence(arr4, 5));

        // System.out.println(s.findFirstOccurrence(arr2, 2));
    }

    static int findFirstOccurrence(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int pivot = findPivotIndex(arr);

        int leftIndex = findFirstOccurrenceInRange(arr, 0, pivot - 1, target);

        if (leftIndex >= 0) {
            return leftIndex;
        }

        int rightIndex = findFirstOccurrenceInRange(arr, pivot, arr.length - 1, target);

        return rightIndex;
    }

    private static int findFirstOccurrenceInRange(int[] arr, int start, int end, int target) {
        int index = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                index = mid;
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return index;
    }

    private static int findPivotIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < arr[end]) {
                end = mid;
            } else if (arr[mid] > arr[end]) {
                start = mid + 1;
            } else {
                end--;
            }
        }

        return start;
    }
}

class Solution {

    // Finds the index of the smallest element.
    // This is the rotation point.
    static int findPivot(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < arr[high]) {
                // Minimum is at mid or to its left
                high = mid;
            } else if (arr[mid] > arr[high]) {
                // Minimum must be to the right of mid
                low = mid + 1;
            } else {
                // arr[mid] == arr[high]
                // We cannot determine which side contains
                // the minimum, so safely reduce high.
                high--;
            }
        }

        return low;
    }

    // Finds the first occurrence of key in a sorted range [low, high].
    static int firstOccurrence(int[] arr, int low, int high, int key) {
        int answer = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {
                answer = mid;

                // Continue searching towards the left
                // to find the first occurrence.
                high = mid - 1;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }

    // Main function
    static int searchFirst(int[] arr, int key) {

        if (arr == null || arr.length == 0) {
            return -1;
        }

        // Step 1: Find rotation point
        int pivot = findPivot(arr);

        // Step 2: Search the left sorted part first.
        // This is important because we need the smallest
        // index in the rotated array.
        int answer = firstOccurrence(arr, 0, pivot - 1, key);

        if (answer != -1) {
            return answer;
        }

        // Step 3: Search the right sorted part.
        return firstOccurrence(arr, pivot, arr.length - 1, key);
    }

    public static void main(String[] args) {

        int[] arr = {4, 4, 5, 6, 1, 2, 2, 4};

        int key = 4;

        int index = searchFirst(arr, key);

        System.out.println("First occurrence index = " + index);
    }
}
