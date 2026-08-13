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
