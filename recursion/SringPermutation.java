import java.util.*;

// PERMUTATION - Rearrange the string by changing the position of any character/element at any place in string

class SringPermutation {
    public static void main(String[] args) {
        System.out.println("Total count: " + permutationCount("", "abc"));
        System.out.println("\n");
        System.out.println(permutationArrayList("", "abc"));
        System.out.println("\n");
        printPermutations("", "abc");
    }

    static void printPermutations(String ps, String up) {
        if (up.isEmpty()) {
            System.out.println(ps);
            return;
        }

        char ch = up.charAt(0);

        for (int i = 0; i < ps.length()+1; i++) {
            String f = ps.substring(0, i);
            String s = ps.substring(i, ps.length());
            printPermutations(f + ch + s, up.substring(1));
        }
    }

    static ArrayList<String> permutationArrayList(String ps, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(ps);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        char ch = up.charAt(0);

        for (int i = 0; i < ps.length() + 1; i++) {
            String f = ps.substring(0, i);
            String s = ps.substring(i, ps.length());
            list.addAll(permutationArrayList(f + ch + s, up.substring(1)));
        }

        return list;
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