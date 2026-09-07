/*
Problem: Swapping Nodes in a Linked List
You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

# Example 01:
Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]

# Example 02:
Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]
 
# Constraints:
    -> The number of nodes in the list is n.
    -> 1 <= k <= n <= 105
    -> 0 <= Node.val <= 100
 */
class SwappingNodesInLinkedList {

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
        // Input: head = [7,9,6,6,7,8,3,0,9,5], k=5
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(6);
        head1.next.next.next = new Node(6);
        head1.next.next.next.next = new Node(7);
        head1.next.next.next.next.next = new Node(8);
        head1.next.next.next.next.next.next = new Node(3);
        head1.next.next.next.next.next.next.next = new Node(0);
        head1.next.next.next.next.next.next.next.next = new Node(9);
        head1.next.next.next.next.next.next.next.next.next = new Node(5);

        // Input: head = [1,2,3,4,5], k=2
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(5);

        // INPUT 01 =>
        System.out.println("Input 01 =>");
        System.out.print("Input 01 Before: ");
        printList(head1);

        Node newHead = swapNodes(head1, 5);

        System.out.print("After: ");
        printList(newHead);

        System.out.println();

        // INPUT 02 =>
        System.out.println("Input 02 =>");
        System.out.print("Before: ");
        printList(head2);

        Node newHead2 = swapNodes(head2, 5);

        System.out.print("After: ");
        printList(newHead2);

    }

    static Node swapNodes(Node head, int k) {
        Node first = head;
        // first -> Kth node from beginning
        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        Node temp = first.next;
        Node second = head;

        while (temp != null) {
            temp = temp.next;
            second = second.next;
        }

        int value = first.data;

        first.data = second.data;
        second.data = value;

        return head;
    }
}
