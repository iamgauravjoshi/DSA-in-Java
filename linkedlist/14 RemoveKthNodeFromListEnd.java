/*
Problem: Remove Nth Node From End of List
Given the head of a linked list, remove the nth node from the end of the list and return its head.

# Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

# Example 2:
Input: head = [1], n = 1
Output: []

# Example 3:
Input: head = [1,2], n = 1
Output: [1]

# Constraints:
    -> The number of nodes in the list is sz.
    -> 1 <= sz <= 30
    -> 0 <= Node.val <= 100
    -> 1 <= n <= sz
 */

class RemoveKthNodeFromListEnd {

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
        Node head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = new Node(30);
        head1.next.next.next = new Node(40);
        head1.next.next.next.next = new Node(50);
        head1.next.next.next.next.next = new Node(60);
        // ------- Input 02 -------
        // head2.next = new Node(5);
        // head2.next.next = new Node(100);
        // head2.next.next.next = new Node(5);
        // ------- Input 03 -------
        // Node head3 = new Node(1);

        System.out.println("Before:");
        printList(head1);

        Node newHead = removeNthFromEnd(head1, 6);

        System.out.println();

        System.out.println("After:");
        printList(newHead);
    }

    static Node removeNthFromEnd(Node head, int k) {
        Node slow = head;
        Node fast = head;

        for (int i = 1; i <= k; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        Node keyNode = slow.next;
        slow.next = keyNode.next;
        keyNode.next = null;

        return head;
    }

}
