import java.util.ArrayList;

/*
Given a string S, find and return all possible subsequences of the string.
A subsequence is a sequence that can be derived from the original string, by deleting zero or more characters without changing the order of the remaining characters.
*/

public class StringSubsequence {
    public static void main(String[] args) {
        System.out.println("String Subsequence Questions!");

        String processed = "";
        String unprocessed = "abc";

        System.out.println("Total count: " + countSubsequence(processed, unprocessed));
        System.out.println("\n");
        printSubsequence(processed, unprocessed);
        System.out.println(subsequenceList(processed, unprocessed));
    }

    static ArrayList<String> subsequenceList(String ps, String up) {
        if(up.isEmpty()) {
            ArrayList<String> tempList = new ArrayList<>();
            tempList.add(ps);
            return tempList;
        }

        char ch = up.charAt(0);

        ArrayList<String> left = subsequenceList(ps+ch, up.substring(1));
        ArrayList<String> right = subsequenceList(ps, up.substring(1));

        left.addAll(right);

        return left;
    }

    static int countSubsequence(String ps, String up) {
        if(up.isEmpty()) {
            return 1;
        }

        char ch = up.charAt(0);

        int left = countSubsequence(ps+ch, up.substring(1));
        int right = countSubsequence(ps, up.substring(1));

        return left + right;
    }

    static void printSubsequence(String ps, String up) {
        if(up.isEmpty()) {
            System.out.println(ps);
            return;
        }

        char ch = up.charAt(0);

        printSubsequence(ps+ch, up.substring(1));
        printSubsequence(ps, up.substring(1));
    }
}
