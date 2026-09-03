/*
Problem: Merge Nodes in Between Zeros
You are given the head of a linked list, which contains a series of integers separated by 0's. The beginning and end of the linked list will have Node.val == 0.

For every two consecutive 0's, merge all the nodes lying in between them into a single node whose value is the sum of all the merged nodes. The modified list should not contain any 0's.

Return the head of the modified linked list.

#Example 01:
Input: head = [0,3,1,0,4,5,2,0]
Output: [4,11]
Explanation: 
The above figure represents the given linked list. The modified list contains
- The sum of the nodes marked in green: 3 + 1 = 4.
- The sum of the nodes marked in red: 4 + 5 + 2 = 11.

#Example 02:
Input: head = [0,1,0,3,0,2,2,0]
Output: [1,3,4]
Explanation: 
The above figure represents the given linked list. The modified list contains
- The sum of the nodes marked in green: 1 = 1.
- The sum of the nodes marked in red: 3 = 3.
- The sum of the nodes marked in yellow: 2 + 2 = 4.

# Constraints:
    -> The number of nodes in the list is in the range [3, 2 * 105].
    -> 0 <= Node.val <= 1000
    -> There are no two consecutive nodes with Node.val == 0.
    -> The beginning and end of the linked list have Node.val == 0.
 */

class MergeNodesInBetweenZeros {

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Input: head = [0,3,1,0,4,5,2,0]
        Node head1 = new Node(0);
        head1.next = new Node(3);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(0);
        head1.next.next.next.next = new Node(4);
        head1.next.next.next.next.next = new Node(5);
        head1.next.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next.next = new Node(0);
        // Input: head = [0,1,0,3,0,2,2,0]
        Node head2 = new Node(0);
        head2.next = new Node(1);
        head2.next.next = new Node(0);
        head2.next.next.next = new Node(3);
        head2.next.next.next.next = new Node(0);
        head2.next.next.next.next.next = new Node(2);
        head2.next.next.next.next.next.next = new Node(2);
        head2.next.next.next.next.next.next.next = new Node(0);

        System.out.println("Before:");
        printList(head2);

        Node newHead = mergeNodes(head2);

        System.out.println();

        System.out.println("After:");
        printList(newHead);
    }

    static Node mergeNodes(Node head) {
        Node write = head;
        Node read = head.next;
        int sum = 0;

        while (read != null) {
            if (read.data == 0) {
                write.data = sum;
                write.next = read.next;
                write = read.next;
                sum = 0;
            }

            sum = sum + read.data;
            read = read.next;
        }

        return head;
    }
}
