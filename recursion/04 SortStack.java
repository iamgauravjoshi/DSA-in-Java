
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

    static void sortStack(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }

        int top = st.pop();

        sortStack(st);

        insert(st, top);
    }

    static void insert(Stack<Integer> st, int num) {
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
