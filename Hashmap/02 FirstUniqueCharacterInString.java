
import java.util.HashMap;

/*
Problem: First unique/non-repeating character in string
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

# Example 1:
Input: s = "leetcode"
Output: 0
Explanation: The character 'l' at index 0 is the first character that does not occur at any other index.

# Example 2:
Input: s = "loveleetcode"
Output: 2

# Example 3:
Input: s = "aabb"
Output: -1 

# Constraints:
    -> 1 <= s.length <= 105
    -> s consists of only lowercase English letters.
 */
class FirstUniqueCharacterInString {

    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "loveleetcode";
        String s3 = "aabb";

        System.out.println(s1 + ": " + firstUniqueChar(s1));
        System.out.println(s2 + ": " + firstUniqueChar(s2));
        System.out.println(s3 + ": " + firstUniqueChar(s3));
    }

    static int firstUniqueChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        // Step 1: Count frequency of each character
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // Step 2: Find the first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    // private static int firstUniqueChar2(String s) {
    //     int[] arr = new int[26];
    //     // Step 1: Count frequency of each character
    //     for (char c : s.toCharArray()) {
    //         arr[c - 'a']++;
    //     }
    //     // Step 2: Find the first character with frequency 1
    //     for (int i = 0; i < s.length(); i++) {
    //         if (arr[s.charAt(i) - 'a'] == 1) {
    //             return i;
    //         }
    //     }
    //     // No non-repeating character exists
    //     return -1;
    // }
}
