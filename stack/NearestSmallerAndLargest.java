import java.util.*;

public class NearestSmallerAndLargest {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {10, 4, 2, 20, 40, 12};
        // int[] arr = {1, 3, 2, 4};
        int n = arr.length;

        s.prevSmallerElement(arr, n);
        s.prevLargerElement(arr, n);
        s.nextLargerElement(arr, n);
        s.nextSmallerElement(arr, n);
    }
}

class Solution {

    private List<Integer> resultList(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(-1);
        }
        return result;
    }

    public void prevSmallerElement(int[] arr, int n) {
        List<Integer> result = resultList(n);

        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    result.set(i, arr[j]);
                    break;
                }
            }
        }

        System.out.println("Prev smaller: " + result);
    }

    public void prevLargerElement(int[] arr, int n) {
        List<Integer> result = resultList(n);

        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    result.set(i, arr[j]);
                    break;
                }
            }
        }

        System.out.println("Prev largest: " + result);
    }

    public void nextSmallerElement(int[] arr, int n) {
        List<Integer> result = resultList(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    result.set(i, arr[j]);
                    break;
                }
            }
        }

        System.out.println("Next smaller: " + result);
    }

    public void nextLargerElement(int[] arr, int n) {
        List<Integer> result = resultList(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    result.set(i, arr[j]);
                    break;
                }
            }
        }

        System.out.println("Next largest: " + result);
    }
}
