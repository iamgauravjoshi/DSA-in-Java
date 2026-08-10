class OrderAgnosticBinarySearch {
  public static void main(String[] args) {
    int[] arr1 = {2,4,5,7,9,12,15};
    int[] arr2 = {15,12,9,7,5,4,2};
    int target = 9;

    int index1 = orderAgnosticBS(arr1, target);
    int index2 = orderAgnosticBS(arr2, target);

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

  static int orderAgnosticBS(int[] arr, int target) {
    if (arr == null || arr.length == 0) {
      return -1;
    }
    
    int start = 0;
    int end = arr.length-1;

    boolean ascending = arr[start] <= arr[end];

    while(start <= end) {
      int mid = start + (end-start)/2;

      if(arr[mid] == target) {
        return mid;
      }

      if(ascending) {
        if(target < arr[mid]) {
          end = mid-1;
        } else {
          start = mid+1;
        }
      } else {
        if(target > arr[mid]) {
          end = mid-1;
        } else {
          start = mid+1;
        }
      }
    }

    return -1;
  }
}