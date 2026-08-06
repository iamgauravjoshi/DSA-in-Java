import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:-
Input: nums = [1,2,3]
Output: [[],[1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]

Example 2:-
Input: nums = [0]
Output: [[],[0]]

# Constraints:
• 1 <= nums.length <= 10
• -10 < nums[i] <= 10
• All the numbers of nums are unique.
*/

public class ArraySubset {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        subset(arr);
    }

    static void subset(int[] arr) {  
        System.out.println("Array Subset: " + Arrays.toString(arr));
    }

    List<List<Integer>> list = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsets (int[] nums) {
        this.nums = nums;
        List<Integer> current = new ArrayList<>();
        backtrack(0, current);
        return list;
    }

    public void backtrack(int index, List<Integer> current){
        //recursive case
        if (index == nums.length) {
            list.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        backtrack (index+1, current);
        current.remove(current.size()-1);
        backtrack (index+1, current);
    }
}
