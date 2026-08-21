/*
Problem: Palindrome Linked List
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

# Example 1:
Input: head = [1,2,2,1]
Output: true

# Example 2:
Input: head = [1,2]
Output: false

# Constraints:
    -> The number of nodes in the list is in the range [1, 105].
    -> 0 <= Node.val <= 9
 */

class PalindromeLinkedList {

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        // HEAD 01
        Node head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = new Node(30);
        head1.next.next.next = new Node(40);
        head1.next.next.next.next = new Node(50);
        head1.next.next.next.next.next = new Node(60);

        // HEAD 02
        Node head2 = new Node(5);
        head2.next = new Node(2);
        head2.next.next = new Node(1);
        head2.next.next.next = new Node(2);
        head2.next.next.next.next = new Node(5);

        System.out.println("HEAD 01:");
        printList(head1);
        System.out.println("Is Palindrome: " + isPalindrome(head1));

        System.out.println("\nHEAD 02:");
        printList(head2);
        System.out.println("Is Palindrome: " + isPalindrome(head2));
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    static boolean isPalindrome(Node head) {
        Node slow = head, fast = head, prev, temp;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        prev = slow;
        slow = slow.next;
        prev.next = null;

        while (slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        fast = head;
        slow = prev;

        while (slow != null) {
            if (fast.data != slow.data) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }
}
