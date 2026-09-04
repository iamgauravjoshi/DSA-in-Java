/*
Problem: Rotate LinkedList To Right
Given the head of a linked list, rotate the list to the right by k places.

# Example 01:
Input: 1 -> 2 -> 3 -> 4 -> 5, k = 2
Output: 4 -> 5 -> 1 -> 2 -> 3

# Example 02:
Input: 0 -> 1 -> 2, k = 4
Output: 2 -> 0 -> 1

# Constraints:
    -> The number of nodes in the list is in the range [0, 500].
    -> -100 <= Node.val <= 100
    -> 0 <= k <= 2 * 109
 */

class RotateLinkedListToRight {

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
        // Input: 1 -> 2 -> 3 -> 4 -> 5
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        // Input: 0 -> 1 -> 2
        Node head2 = new Node(0);
        head2.next = new Node(1);
        head2.next.next = new Node(2);

        System.out.println("Before:");
        System.out.print("Head 1: ");
        printList(head1);
        System.out.print("Head 2: ");
        printList(head2);

        Node newHead1 = rotateRight(head1, 2);
        Node newHead2 = rotateRight(head2, 4);

        System.out.println();

        System.out.println("After:");
        System.out.print("Head 1: ");
        printList(newHead1);
        System.out.print("Head 2: ");
        printList(newHead2);
    }

    static Node rotateRight(Node head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        Node current = head;
        int len = 1;

        // Step 1: Find list length and make it circular
        while (current.next != null) {
            len++;
            current = current.next;
        }

        current.next = head;

        k = k % len;

        // Step 2: Break the link from kth node
        current = head;

        for (int i = 1; i < len - k; i++) {
            current = current.next;
        }

        Node forwardNode = current.next;
        current.next = null;

        return forwardNode;
    }
}
