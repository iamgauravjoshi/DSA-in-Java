
class CountOccurrence {

    public static void main(String[] args) {
        CountOccurrence co = new CountOccurrence();
        int[] arr1 = {1, 3, 5, 5, 5, 5, 67, 125, 125};
        int[] arr2 = {4, 4, 8, 8, 8, 15, 16, 23, 23, 42};
        int target1 = 5;
        int target2 = 8;

        int count1 = co.countFreq(arr1, target1);
        int count2 = co.countFreq(arr2, target2);

        System.out.println("Count of element " + target1 + ": " + count1);
        System.out.println("Count of element " + target2 + ": " + count2);
    }

    private int countFreq(int arr[], int target) {
        int first = findOccurrenceIndex(arr, target, true);

        if (first == -1) {
            first = 0;
        }

        int last = findOccurrenceIndex(arr, target, false);

        return last - first + 1;
    }

    private int findOccurrenceIndex(int[] arr, int target, boolean findFirst) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int start = 0;
        int end = arr.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                ans = mid;

                if (findFirst) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
