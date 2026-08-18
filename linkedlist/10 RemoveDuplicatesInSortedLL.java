/*
Problem: Remove Duplicates from a Sorted Linked List
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

# Example 1:
Input: head = [1,1,2]
Output: [1,2]

# Example 2:
Input: head = [1,1,2,3,3]
Output: [1,2,3]

# Constraints:
    -> The number of nodes in the list is in the range [0, 300].
    -> -100 <= Node.val <= 100
    -> The list is guaranteed to be sorted in ascending order.
 */

class RemoveDuplicatesInSortedLL {

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
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(3);

        System.out.println("Before:");
        printList(head);

        Node newHead = removeDuplicates(head);

        System.out.println();

        System.out.println("After:");
        printList(newHead);
    }

    static Node removeDuplicates(Node head) {
        if (head == null) {
            return head;
        }

        Node previous = head;
        Node current = head.next;

        while (current != null) {
            if (current.data == previous.data) {
                previous.next = current.next;
                current.next = null;
                current = previous.next;
            } else {
                previous = current;
                current = current.next;
            }
        }
        return head;
    }
}
