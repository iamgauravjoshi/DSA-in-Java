/*
Problem: Detect cycle in a Linked List
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

# Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

# Example 2:
Input: head = [1,2]
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

# Example 3:
Input: head = [1]
Output: false
Explanation: There is no cycle in the linked list.
 

# Constraints:
    -> The number of the nodes in the list is in the range [0, 104].
    -> -105 <= Node.val <= 105
    -> pos is -1 or a valid index in the linked-list.
 */

class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class CheckCycleInLinkedList {

    public static void main(String[] args) {
        CheckCycleInLinkedList s = new CheckCycleInLinkedList();
        Node head = new Node(1);

        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        // Create cycle: last node points back to node containing 2
        head.next.next.next.next.next = head.next.next;

        System.out.println("Cycle detected: " + s.hasCycle(head));
    }

    public boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
