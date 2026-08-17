
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
        int index = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] <= target) {
                index = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return index;
    }
}
