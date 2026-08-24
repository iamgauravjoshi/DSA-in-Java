/*  ----- LEETCODE -----
Problem: Odd Even Linked List
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.
Note that the relative order inside both the even and odd groups should remain as it was in the input.
You must solve the problem in O(1) extra space complexity and O(n) time complexity.

# Example 1:
Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]

# Example 2:
Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]

# Constraints:
    -> The number of nodes in the linked list is in the range [0, 104].
    -> -106 <= Node.val <= 106
 */

class OddEvenLinkedList {

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
        // ------- Input 01 -------
        // Node head1 = new Node(1);
        // head1.next = new Node(2);
        // head1.next.next = new Node(3);
        // head1.next.next.next = new Node(4);
        // head1.next.next.next.next = new Node(5);
        // ------- Input 02 -------
        Node head2 = new Node(2);
        head2.next = new Node(1);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(5);
        head2.next.next.next.next = new Node(6);
        head2.next.next.next.next.next = new Node(4);
        head2.next.next.next.next.next.next = new Node(7);

        System.out.println("Before:");
        printList(head2);

        Node newHead = oddEvenList(head2);

        System.out.println();

        System.out.println("After:");
        printList(newHead);
    }

    private static Node oddEvenList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node odd = head, even = head.next, evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}
