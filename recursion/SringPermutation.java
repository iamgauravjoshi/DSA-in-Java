/*
Problem: All String Permutations in Sorted Order
Given a string s. Find all permutations  of a given string. Return the permutations in lexicographically non-decreasing order.

# Example 01:
Input: s = "AA"
Output: ["AA", "AA"]
Explanation: There are total 2 permutations, as given in the output.

# Example 02:
Input: s = "ABC"
Output: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
Explanation: There are total 6 permutations, as given in the output.

# Constraints:
    -> 1 ≤ s.size() ≤ 5
 */

import java.util.ArrayList;
import java.util.Collections;

class SringPermutation {

    public static void main(String[] args) {
        System.out.println("Total count: " + permutationCount("", "abc"));
        System.out.println(permutationList("abc"));
    }

    static ArrayList<String> permutationList(String s) {
        ArrayList<String> list = new ArrayList<>();

        solve("", s, list);
        Collections.sort(list);

        return list;
    }

    private static void solve(String ps, String up, ArrayList<String> list) {
        if (up.isEmpty()) {
            list.add(ps);
            return;
        }

        char ch = up.charAt(0);

        for (int i = 0; i <= ps.length(); i++) {
            String first = ps.substring(0, i);
            String second = ps.substring(i);

            solve(first + ch + second, up.substring(1), list);
        }
    }

    static int permutationCount(String ps, String up) {
        if (up.isEmpty()) {
            return 1;
        }

        int count = 0;
        char ch = up.charAt(0);

        for (int i = 0; i < ps.length() + 1; i++) {
            String f = ps.substring(0, i);
            String s = ps.substring(i, ps.length());
            count += permutationCount(f + ch + s, up.substring(1));
        }

        return count;
    }
}

// class Solution {
//     public ArrayList<String> permutationList(String s) {
//         ArrayList<String> list = new ArrayList<>();
//         char[] arr = s.toCharArray();
//         Arrays.sort(arr);
//         boolean[] used = new boolean[arr.length];
//         solve(arr, used, "", list);
//         return list;
//     }
//     private void solve(char[] arr, boolean[] used,
//             String p, ArrayList<String> list) {
//         if (p.length() == arr.length) {
//             list.add(p);
//             return;
//         }
//         for (int i = 0; i < arr.length; i++) {
//             if (used[i]) {
//                 continue;
//             }
//             used[i] = true;
//             solve(arr, used, p + arr[i], list);
//             used[i] = false;
//         }
//     }
// }
