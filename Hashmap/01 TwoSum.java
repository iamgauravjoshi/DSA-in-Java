
import java.util.Arrays;
import java.util.HashMap;

class TwoSum {

    public static void main(String[] args) {
        int[] arr1 = {2, 7, 11, 15};
        int target1 = 9;

        int[] arr2 = {2, 4, 17, 12, 13, 19, 20, 23};
        int target2 = 1;

        int[] arr3 = {3, 3};
        int target3 = 6;

        System.out.print("Array 01: ");
        System.out.println(Arrays.toString(twoSum(arr1, target1)));

        System.out.print("Array 02: ");
        System.out.println(Arrays.toString(twoSum(arr2, target2)));

        System.out.print("Array 03: ");
        System.out.println(Arrays.toString(twoSum(arr3, target3)));
    }

    static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];

            /*
                Builds the entire map first. And loops through the array again.

                For {2, 7, 11, 15}, target 9:
                i = 0 → number = 2 → need 7 → not found → store 2
                i = 1 → number = 7 → need 2 → found!
             */
            if (map.containsKey(remaining)) {
                return new int[]{map.get(remaining), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}
