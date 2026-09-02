
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Problem: All Subsequences of a String
Given a string s, generate all possible subsequences of the string (including the empty subsequence) and return them in lexicographical order.

A subsequence is obtained by deleting zero or more characters from the string without changing the relative order of the remaining characters.

# Example 01:
Input : s = "abc"
Output: ["","a", "ab", "abc", "ac", "b", "bc", "c"]
Explanation: There are a total of 8 non-empty subsequences for the given string. 

# Example 02:
Input: s = "aa"
Output: ["", "a", "a", "aa"]

# Constraints:
    -> 1 ≤ n ≤ 16
    -> s consists of lowercase English letters.

 */
class StringSubsequences {

    public static void main(String[] args) {
        System.out.println("String Subsequence Questions!");
        String s = "abc";

        System.out.println("Total count: " + countSubsequence("", s));
        System.out.println(printSubsequence(s));
    }

    static List<String> printSubsequence(String s) {
        List<String> list = new ArrayList<>();

        solve("", s, list);
        Collections.sort(list);

        return list;
    }

    private static void solve(String ps, String up, List<String> list) {
        if (up.isEmpty()) {
            list.add(ps);
            return;
        }

        char ch = up.charAt(0);

        solve(ps + ch, up.substring(1), list);
        solve(ps, up.substring(1), list);
    }

    static int countSubsequence(String ps, String up) {
        if (up.isEmpty()) {
            return 1;
        }

        char ch = up.charAt(0);

        int left = countSubsequence(ps + ch, up.substring(1));
        int right = countSubsequence(ps, up.substring(1));

        return left + right;
    }
}

// class Solution {
//     public List<String> powerSet(String s) {
//         List<String> list = new ArrayList<>();
//         solve(0, s, new StringBuilder(), list);
//         Collections.sort(list);
//         return list;
//     }
//     private void solve(int index, String s,
//             StringBuilder ps, List<String> list) {
//         if (index == s.length()) {
//             list.add(ps.toString());
//             return;
//         }
//         // Don't take current character
//         solve(index + 1, s, ps, list);
//         // Take current character
//         ps.append(s.charAt(index));
//         solve(index + 1, s, ps, list);
//         // Backtrack
//         ps.deleteCharAt(ps.length() - 1);
//     }
// }
