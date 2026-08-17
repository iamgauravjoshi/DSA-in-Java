
class SerachInNearlySortedArray {

    public static void main(String[] args) {
        int[] arr1 = {10, 3, 40, 20, 50, 80, 70};
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] arr3 = {-20};

        System.out.println(findTarget(arr1, 40));
        System.out.println(findTarget(arr1, 70));
        System.out.println(findTarget(arr1, 60));
        System.out.println(findTarget(arr2, 1));
        System.out.println(findTarget(arr3, 10));
    }

    static int findTarget(int[] arr, int target) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                return mid;
            }

            if (mid - 1 >= start && target == arr[mid - 1]) {
                return mid - 1;
            }

            if (mid + 1 <= end && target == arr[mid + 1]) {
                return mid + 1;
            }

            if (target < arr[mid]) {
                end = mid - 2;
            } else {
                start = mid + 2;
            }
        }
        return -1;
    }
}
