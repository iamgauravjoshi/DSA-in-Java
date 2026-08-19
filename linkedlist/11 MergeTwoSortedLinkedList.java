/*
Problem: Merge two sorted linked lists
Given the head of two sorted linked lists consisting of nodes respectively. Merge both lists and return the head of the sorted merged list.

# Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

# Example 2:
Input: list1 = [], list2 = []
Output: []

# Example 3:
Input: list1 = [], list2 = [0]
Output: [0]
 
# Constraints:
    -> The number of nodes in both lists is in the range [0, 50].
    -> -100 <= Node.val <= 100
    -> Both list1 and list2 are sorted in non-decreasing order.
 */

class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class MergeTwoSortedLinkedList {

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        MergeTwoSortedLinkedList s = new MergeTwoSortedLinkedList();
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(4);

        Node head2 = new Node(1);
        head2.next = new Node(3);
        head2.next.next = new Node(4);

        System.out.println("List 01:");
        printList(head1);

        System.out.println("List 02:");
        printList(head2);

        Node newHead = s.mergeTwoLists(head1, head2);

        System.out.println();

        System.out.println("After:");
        printList(newHead);
    }

    public Node mergeTwoLists(Node list1, Node list2) {
        if (list1 == null && list2 == null) {
            return list1;
        }

        Node ans = new Node(0);
        Node tail = ans;

        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        return ans.next;
    }
}
