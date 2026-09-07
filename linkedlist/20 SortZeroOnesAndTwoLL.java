/*
Problem: Sort a linked list of 0s, 1s and 2s
Given the head of a linked list where nodes can contain values 0s, 1s, and 2s only. Your task is to rearrange the list so that all 0s appear at the beginning, followed by all 1s, and all 2s are placed at the end.

# Example 01:
Input: head = 1 → 2 → 2 → 1 → 2 → 0 → 2 → 2
Output: 0 → 1 → 1 → 2 → 2 → 2 → 2 → 2
Explanation: All the 0s are segregated to the left end of the linked list, 2s to the right end of the list, and 1s in between. The final list will be:

# Example 02:
Input: head = 2 → 2 → 0 → 1
Output: 0 → 1 → 2 → 2
Explanation: After arranging all the 0s, 1s and 2s in the given format, the output will be:

# Constraints:
    -> 1 ≤ no. of nodes ≤ 106
    -> 0 ≤ node->data ≤ 2
 */

class SortZeroOnesAndTwoLL {

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
        // Input: head = [1,2,2,1,2,0,2,2]
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(2);
        head1.next.next.next = new Node(1);
        head1.next.next.next.next = new Node(2);
        head1.next.next.next.next.next = new Node(0);
        head1.next.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next.next = new Node(2);

        // Input: head = [2,2,0,1]
        Node head2 = new Node(2);
        head2.next = new Node(2);
        head2.next.next = new Node(0);
        head2.next.next.next = new Node(1);

        System.out.println("Before:");
        printList(head1);

        Node newHead = segregate(head1);

        System.out.println();

        System.out.println("After:");
        printList(newHead);
    }

    static Node segregate(Node head) {
        Node current = head;
        Node zeroHead = new Node(-1);
        Node zeroTail = zeroHead;
        Node oneHead = new Node(-1);
        Node oneTail = oneHead;
        Node twoHead = new Node(-1);
        Node twoTail = twoHead;

        while (current != null) {
            Node nodeToInsert = current;
            switch (current.data) {
                case 0 -> {
                    zeroTail.next = nodeToInsert;
                    zeroTail = zeroTail.next;
                }
                case 1 -> {
                    oneTail.next = nodeToInsert;
                    oneTail = oneTail.next;
                }
                default -> {
                    twoTail.next = nodeToInsert;
                    twoTail = twoTail.next;
                }
            }
            current = current.next;
            nodeToInsert.next = null;
        }

        zeroTail.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        oneTail.next = twoHead.next;
        twoTail.next = null;

        zeroHead = zeroHead.next;
        return zeroHead;
    }
}
