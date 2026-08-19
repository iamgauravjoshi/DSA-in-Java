
class PeakIndexInMountainArray {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5, 7, 8, 3};
        int[] arr2 = {3, 5, 3, 2, 0};
        int[] arr3 = {18, 29, 38, 59, 98, 100, 99, 98, 90};

        System.out.println(peakIndexInMountainArray(arr1));
        System.out.println(peakIndexInMountainArray(arr2));
        System.out.println(peakIndexInMountainArray(arr3));
    }

    static int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
