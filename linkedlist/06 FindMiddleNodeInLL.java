/*
Problem: Middle of a Linked List
Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.

# Example 1:
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

# Example 2:
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 
# Constraints:
    - The number of nodes in the list is in the range [1, 100].
    - 1 <= Node.val <= 100
 */

class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class FindMiddleNodeInLL {

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

        System.out.println("List:");
        printList(head);

        int middle = findMiddleNode(head);

        System.out.println("Middle: " + middle);
    }

    static int findMiddleNode(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null) {
            fast = fast.next;

            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }

        return slow.data;
    }
}
