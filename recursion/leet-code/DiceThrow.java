/*
# PROBLEM STATEMENT =>
You are given:

n = number of dice
m = number of faces on each die (numbered from 1 to m)
x = target sum

Find the number of possible ways to obtain the sum x by rolling all n dice.

Each die is distinct, so different sequences of rolls count as different ways.

# EXPECTED OUTCOME =>
Return an integer representing the total number of distinct ways to obtain the target sum x using exactly n dice.
If it is impossible, return 0.

------- EXAMPLE 01 -------
Input: n = 2, m = 6, x = 7
Output: 6
Explanation: (1,6) (2,5) (3,4) (4,3) (5,2) (6,1)

------- EXAMPLE 02 -------
Input: n = 3, m = 6, x = 5
Output: 6
Explaination: 
(1,1,3)
(1,2,2)
(1,3,1)
(2,1,2)
(2,2,1)
(3,1,1)

------- EXAMPLE 03 -------
Input: n = 2, m = 6, x = 13
Output: 0
Explaination: The maximum possible sum with two six-sided dice is 12, so a sum of 13 is impossible.

*/


// Dice combination with faces greater than 6

public class DiceThrow {
    public static void main(String[] args) {
        // System.out.println(diceCombinationList("", 4));
        printDiceCombination("", 4);
    }

    static void printDiceCombination(String ps, int target) {

        if(target == 0) {
            System.out.println(ps);
            return;
        }

        for(int i=1; i<=6 && i<=target; i++) {
            printDiceCombination(ps + i, target-i);
        }
    }
}
