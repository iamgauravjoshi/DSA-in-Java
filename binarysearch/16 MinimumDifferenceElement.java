/*
Find the minimum absolute difference when subtract array element with the provided key.
 */

class MinimumDifferenceElement {

    public static void main(String[] args) {
        int[] arr1 = {7, 10, 18, 23, 33, 41, 49, 55, 61, 75};
        int[] arr2 = {2, 5, 6, 11, 15, 20, 21};
        int[] arr3 = {1, 3, 8, 10, 15};

        System.out.println(minDiffElement(arr1, 38));
        System.out.println(minDiffElement(arr1, 11));

        System.out.println();

        System.out.println(minDiffElement(arr2, 13));
        System.out.println(minDiffElement(arr2, 18));

        System.out.println();

        System.out.println(minDiffElement(arr3, 12));
        System.out.println(minDiffElement(arr3, 15));
    }

    static int minDiffElement(int[] arr, int key) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (key == arr[mid]) {
                return arr[mid];
            }

            if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        int floorDiff = Math.abs(key - arr[high]);
        int ceilDiff = Math.abs(key - arr[low]);

        return floorDiff <= ceilDiff ? arr[high] : arr[low];
    }
}
