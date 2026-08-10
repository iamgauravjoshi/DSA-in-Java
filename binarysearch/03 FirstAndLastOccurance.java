import java.util.Arrays;

class FirstAndLastOccurrence {
  public static void main(String[] args) {
    int[] arr1 = {1, 3, 5, 5, 5, 5, 67, 125, 125};
    int[] arr2 = {};
    int target1 = 5;
    int target2 = 67;
    int target3 = 0;

    int[] result1 = firstAndLastOccurrence(arr1, target1);
    int[] result2 = firstAndLastOccurrence(arr1, target2);
    int[] result3 = firstAndLastOccurrence(arr2, target3);

    System.out.println("First and Last Occurrence of " + target1 + ": " + Arrays.toString(result1));
    System.out.println("First and Last Occurrence of " + target2 + ": " + Arrays.toString(result2));
    System.out.println("First and Last Occurrence of " + target3 + ": " + Arrays.toString(result3));
  }

  static int[] firstAndLastOccurrence(int arr[], int target) {

    int first = findOccurrence(arr, target, true);
    int last = findOccurrence(arr, target, false);

    return new int[]{first, last};
  }

  static int findOccurrence(int[] arr, int target, boolean findFirst) {
    if(arr == null || arr.length == 0) {
      return -1;
    }

    int start = 0;
    int end = arr.length-1;
    int ans = -1;

    while(start <= end) {
      int mid = start + (end-start)/2;

      if(arr[mid] == target) {
        ans = mid;

        if(findFirst) {
          end = mid-1;
        } else {
          start = mid+1;
        }
      } else if(target < arr[mid]) {
        end = mid-1;
      } else {
        start = mid+1;
      }
    }
    return ans;
  }
}  

  
