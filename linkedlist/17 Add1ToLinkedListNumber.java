/*
Problem: Add 1 to a Linked List Number
Given the head of a singly linked list representing a positive integer number. Each node of the linked list represents a digit of the number, with the 1st node containing the leftmost digit of the number and so on. The task is to add one to the value represented by the linked list and return the head of a linked list containing the final value.

The number will contain no leading zeroes except when the value represented is zero itself.

# Example 01:
Input: Head: 4 -> 5 -> 6
Output: 4 -> 5 -> 7
Explanation: 4 -> 5 -> 6 represents 456 and when 1 is added it becomes 457. 

# Example 03:
Input: Head: 9 -> 9 -> 9
Output: 1 -> 0 -> 0 -> 0
Explanation: 9 -> 9 -> 9 represents 999 and when 1 is added it becomes 1000. 

# Example 02:
Input: Head: 0 -> 0 -> 1
Output: 0 -> 0 -> 2

# Constraints:
    -> 1 ≤ size of linked list ≤ 105
    -> 0 ≤ node.data ≤ 9
 */

class Add1ToLinkedListNumber {

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
        Add1ToLinkedListNumber s = new Add1ToLinkedListNumber();
        // Input: head = 4 -> 5 -> 6
        Node head1 = new Node(4);
        head1.next = new Node(5);
        head1.next.next = new Node(6);

        // Input: head = 0 -> 0 -> 1
        Node head2 = new Node(0);
        head2.next = new Node(0);
        head2.next.next = new Node(1);

        // Input: head = 9 -> 9 -> 9 -> 9
        Node head3 = new Node(9);
        head3.next = new Node(9);
        head3.next.next = new Node(9);
        head3.next.next.next = new Node(9);

        System.out.println("Before:");
        printList(head3);

        Node newHead = s.addOne(head3);

        System.out.println();

        System.out.println("After:");
        printList(newHead);
    }

    public Node addOne(Node head) {
        // Step 1: Reverse original LL
        head = reverseList(head);
        // Step 2: logic to add 1
        Node current = head;
        int carry = 1;
        while (current != null) {
            int sum = current.data + carry;
            int digit = sum % 10;
            current.data = digit;
            carry = sum / 10;

            if (current.next == null && carry > 0) {
                current.next = new Node(carry);
                carry = 0;
            }
            current = current.next;
        }
        // Step 3: reverse the LL again
        head = reverseList(head);
        // Step 4: return HEAD of modified LL
        return head;
    }

    private Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
