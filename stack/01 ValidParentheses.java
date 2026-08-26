/*
Problem: Valid Parentheses
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
    -> Open brackets must be closed by the same type of brackets.
    -> Open brackets must be closed in the correct order.
    -> Every close bracket has a corresponding open bracket of the same type.

# Example 1:
Input: s = "[{()}]"
Output: true

# Example 2:
Input: s = "([{]})"
Output: false

# Constraints:
    -> 1 <= s.length <= 104
    -> s consists of parentheses only '()[]{}'.
 */

import java.util.Stack;

class ValidParentheses {

    public static void main(String[] args) {
        String s1 = "()[]{}";
        String s2 = "(((";
        String s3 = "[{()}]";
        String s4 = "([{]})";

        System.out.println(s1 + ": " + isValid(s1));
        System.out.println(s2 + ": " + isValid(s2));
        System.out.println(s3 + ": " + isValid(s3));
        System.out.println(s4 + ": " + isValid(s4));
    }

    private static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char ch : chars) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (ch == ')' || ch == '}' || ch == ']') {
                    if (stack.empty()) {
                        return false;
                    }
                    char peek = stack.peek();

                    if (ch == ')' && peek != '('
                            || ch == '}' && peek != '{'
                            || ch == ']' && peek != '[') {
                        return false;
                    }

                    stack.pop();
                }
            }
        }
        return stack.empty();
    }

    // public boolean isValidParentheses(String s) {
    //     Deque<Character> stack = new ArrayDeque<>();
    //     for (char c : s.toCharArray()) {
    //         if (c == '(') {
    //             stack.push(')');
    //         } else if (c == '{') {
    //             stack.push('}');
    //         } else if (c == '[') {
    //             stack.push(']');
    //         } else {
    //             if (stack.isEmpty() || stack.pop() != c) {
    //                 return false;
    //             }
    //         }
    //     }
    //     return stack.isEmpty();
    // }
}
