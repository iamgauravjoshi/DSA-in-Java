/*
Problem: Remove Cycle in Linked List
Given the head of a singly linked list. A cycle exists if the last node points back to a previous node, forming a loop. Remove the loop from the linked list if it exists.

Internally, the driver code uses a variable x (1-based indexing) to represent the position of the node to which the last node is connected.

The driver code will print "true" if the linked list is correctly modified, otherwise it will print "false".

# Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: TRUE (tail connects to node index 1)
Explanation: There is a cycle in the linked list, where tail connects to the second node.

# Example 2:
Input: head = [1,2,3], pos = -1
Output: FALSE (No cycle detected)
Explanation: There is no cycle present in the linked list.

# Example 3:
Input: head = [2,5,7,3,9,1,6], pos = 3
Output: TRUE (tail connects to node index 3)
 */

class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class RemoveCycleInLinkedList {

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        RemoveCycleInLinkedList s = new RemoveCycleInLinkedList();
        Node head = new Node(1);

        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        // Create cycle: last node points back to node containing 2
        head.next.next.next.next.next = head.next.next;

        boolean isCycle = s.removeLoop(head);

        if (isCycle) {
            System.out.println("Cycle detected: TRUE");
            System.out.println("Updated list:");
            printList(head);
        } else {
            System.out.println("Cycle not detected");
        }
    }

    public boolean removeLoop(Node head) {
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                isCycle = true;
                break;
            }
        }

        if (isCycle) {
            slow = head;
            Node prev = null;
            while (slow != fast) {
                slow = slow.next;
                prev = fast;
                fast = fast.next;
            }
            prev.next = null;

            return true;
        }

        return false;
    }
}
