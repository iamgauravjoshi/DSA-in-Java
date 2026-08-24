/*
Problem: Get Kth node value from end of the Linked List
Given the head of a linked list and an integer k, return the kth node from the end of the linked list. If k is greater than the number of nodes in the list, return -1.

# Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: 4

# Example 2:
Input: head = [1], n = 1
Output: 1

# Example 3:
Input: head = [1,2], n = 3
Output: -1


# Constraints:
    -> 1 <= number of nodes <= 106
    -> 1 <= node.data , x <= 106
    -> 1 <= k <= 106
 */

// TWO POINTER/SLIDING WINDOW PATTERN
class KthNodeValueFromEnd {

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
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);
        // head.next = new Node(5);
        // head.next.next = new Node(100);
        // head.next.next.next = new Node(5);

        System.out.println("Input:");
        printList(head);

        int value = getKthFromEnd(head, 2);

        System.out.println();

        System.out.println("Kth Node: " + value);
    }

    static int getKthFromEnd(Node head, int k) {
        Node slow = head;
        Node fast = head;

        for (int i = 1; i <= k; i++) {
            if (fast == null) {
                return -1;
            }
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;
    }

}
