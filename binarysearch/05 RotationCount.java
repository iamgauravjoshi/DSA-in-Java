/*
Given an increasing sorted rotated array arr[] of distinct integers. The array is right-rotated k times. Find the value of k.
Let's suppose we have an array arr[] = [2, 4, 6, 9], if we rotate it by 2 times it will look like this:
After 1st Rotation : [9, 2, 4, 6]
After 2nd Rotation : [6, 9, 2, 4]
 */

class RotationCount {

    public static void main(String[] args) {
        RotationCount rc = new RotationCount();
        int[] arr1 = {17, 21, 25, 4, 7, 9, 11, 13, 16};
        int[] arr2 = {5, 6, 7, 8, 9, 1, 2, 3, 4};
        int[] arr3 = {1, 2, 3, 4, 5};

        System.out.println("Total right-rotation count: " + rc.findKRotation(arr1));
        System.out.println("Total right-rotation count: " + rc.findKRotation(arr2));
        System.out.println("Total right-rotation count: " + rc.findKRotation(arr3));
    }

    private int findKRotation(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}
