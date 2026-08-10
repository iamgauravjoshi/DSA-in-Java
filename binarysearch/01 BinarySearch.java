class BinarySearch {
    public static void main(String[] args) {
      BinarySearch bs = new BinarySearch();
      int[] arr1 = {2,4,5,7,9,12,15};
      int[] arr2 = {15,12,9,7,5,4,2};
      int target = 2;

      int index1 = bs.binarySearch(arr1, target);
      int index2 = bs.reverseSortedBinarySearch(arr2, target);

      if(index1 == -1) {
        System.out.println(target + " not found inside array");
      } else {
        System.out.println(target + " found at index " + index1);
      }

      if(index2 == -1) {
        System.out.println(target + " not found inside array");
      } else {
        System.out.println(target + " found at index " + index2);
      }
    }

    public int binarySearch(int[] arr, int target) {
      int start = 0;
      int end = arr.length-1;

      while(start <= end) {
        int mid = start + (end-start)/2;

        if(arr[mid] == target) {
          return mid;
        } else if(target < arr[mid]) {
          end = mid-1;
        } else {
          start = mid+1;
        }
      }

      return -1;
    }

    public int reverseSortedBinarySearch(int[] arr, int target) {
      int start = 0;
      int end = arr.length-1;

      while(start <= end) {
        int mid = start + (end-start)/2;

        if(arr[mid] == target) {
          return mid;
        } else if(target < arr[mid]) {
          start = mid+1;
        } else {
          end = mid-1;
        }
      }

      return -1;
    }
}