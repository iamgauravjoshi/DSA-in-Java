
class FindMinMaxInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr1 = {17, 21, 25, 4, 7, 9, 11, 13, 16};
        int[] arr2 = {5, 6, 7, 8, 9, 1, 2, 3, 4};
        int[] arr3 = {9, 9, 7, 7};

        System.out.println("Minimum in arr1: " + findMinimum(arr1));
        System.out.println("Maximum in arr1: " + findMaximum(arr1));

        System.out.println("Minimum in arr2: " + findMinimum(arr2));
        System.out.println("Maximum in arr2: " + findMaximum(arr2));

        System.out.println("Minimum in arr3: " + findMinimum(arr3));
        System.out.println("Maximum in arr3: " + findMaximum(arr3));
    }

    private static int findMinimum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

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

        return arr[start];
    }

    private static int findMaximum(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[end]) {
                start = mid;
            } else if (arr[mid] < arr[end]) {
                end = mid - 1;
            } else {
                end--;
            }
        }

        return arr[start];
    }
}
