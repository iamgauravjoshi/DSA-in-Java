import java.util.ArrayList;

/* 
Given a string containing digits from 2-9 inclusive, return all possible letter combinations
that the number could represent. Return the answer in any order.
A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1
does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad", "ae", "af","bd", "be","bf","cd","ce","cf"]
Example 2:
Input: digits = ""
Output: []
*/

public class LetterCombinationOfPhoneNumber {

    public static void main(String[] args) {
        String str = "12";
        System.out.println(letterCombination("", str));
        System.out.println(letterCombinationCount("", str));
        // printLetterCombination("", "");
    }

    static ArrayList<String> letterCombination(String ps, String up) {
        if(up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(ps);
            return list;
        }

        int digit = up.charAt(0) - '0';
        ArrayList<String> list = new ArrayList<>();

        for(int i=(digit-1)*3; i<digit*3; i++) {
            char ch = (char)('a' + i);
            ArrayList<String> temp = letterCombination(ps + ch, up.substring(1));
            list.addAll(temp);
        }

        return list;
    }

    static void printLetterCombination(String ps, String up) {
        if(up.isEmpty()) {
            System.out.println(ps);
            return;
        }

        int digit = up.charAt(0) - '0';

        for(int i=(digit-1)*3; i<digit*3; i++) {
            char ch = (char)('a' + i);
            printLetterCombination(ps + ch, up.substring(1));
        }
    }

    // Return the total combination count that could be made using given input
    static int letterCombinationCount(String ps, String up) {
        if(up.isEmpty()) {
            return 1;
        }

        int count = 0;
        int digit = up.charAt(0) - '0';

        for(int i=(digit-1)*3; i<digit*3; i++) {
            char ch = (char)('a' + i);
            count += letterCombinationCount(ps + ch, up.substring(1));
        }

        return count;
    }
}