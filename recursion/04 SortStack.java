/*
Problem: Sort a Stack
Given a stack of integers st[]. Sort the stack in ascending order (smallest element at the bottom and largest at the top).

# Example 01:
Input: st[] = [41, 3, 32, 2, 11]
Output: [41, 32, 11, 3, 2]

# Example 02:
Input: st[] = [2, 2, 7, 4, 1]
Output: [1, 2, 2, 4, 7]

# Constraints:
    1 ≤ st.size() ≤ 103
    0 ≤ stack element ≤ 103 
 */

import java.util.Stack;

class SortStack {

    public static void main(String[] args) {
        // 3, 2, 1
        // 2, 2, 7, 4, 1
        Stack<Integer> st = new Stack<>();

        st.push(41);
        st.push(3);
        st.push(32);
        st.push(2);
        st.push(11);

        System.out.print("Before: ");
        System.out.println(st);

        sortStack(st);

        System.out.print("After: ");
        System.out.println(st);
    }

    public static void sortStack(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }

        int top = st.pop();
        sortStack(st);
        insert(st, top);
    }

    private static void insert(Stack<Integer> st, int num) {
        if (st.empty() || st.peek() <= num) {
            st.push(num);
            return;
        }

        // If num is less than the peek element of stack then first remove the peek and compare with next peek element of stack and then insert the element at the correct position.
        int top = st.pop();
        insert(st, num);
        st.push(top);
    }
}
