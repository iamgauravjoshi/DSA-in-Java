
/*
Problem: Intersection of Two Linked Lists
In this problem, you are given two singly linked lists represented by their respective head nodes,
headA and headB. Your task is to determine the node at which the two linked lists intersect, if
they do intersect at all.
Two linked lists are said to intersect if they share a common node, and all subsequent nodes
following this common node are shared between the two lists.
The goal is to write a function that returns the intersected node if there is an intersection;
otherwise, it should return null if the linked lists do not intersect.

# Example 01:
Input:
    listA = 4->1->8->4->5
    listB = 5->6->1->8->4->5
Output: 8
Explanation: The two linked lists intersect at node 8. Therefore, the function should return the node with value 8.

# Example 02:
Input:
    listA = 2->6->4
    listB: 1->5
Output: null
Explanation: The two lists do not intersect, so return null.
 */
class IntersectionOfTwoLL {

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
        // Input: headA = 4->1->8->4->5
        Node headA = new Node(4);
        headA.next = new Node(1);
        headA.next.next = new Node(8);
        headA.next.next.next = new Node(4);
        headA.next.next.next.next = new Node(5);

        // Input: headB = 5->6->1->8->4->5
        Node headB = new Node(5);
        headB.next = new Node(6);
        headB.next.next = new Node(1);
        headB.next.next.next = new Node(8);
        headB.next.next.next.next = new Node(4);
        headB.next.next.next.next.next = new Node(5);

        System.out.print("listA: ");
        printList(headA);

        System.out.print("listB: ");
        printList(headB);

        Node intersectionNode = getIntersectionNode(headA, headB);

        System.out.println();

        System.out.println("Intersection Node: ");
        printList(intersectionNode);
    }

    static Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) {
            return null;
        }

        Node listA = headA;
        Node listB = headB;

        while (listA != null && listB != null) {
            listA = listA.next;
            listB = listB.next;
        }

        // if listA points to null
        if (listA == null) {
            while (listB != null) {
                listB = listB.next;
                headB = headB.next;
            }
        } else {
            // listB points to null
            while (listA != null) {
                listA = listA.next;
                headA = headA.next;
            }
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    /* ---------- OPTIMIZED SOLUTION ---------- */
    public Node intersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) {
            return null;
        }

        Node a = headA;
        Node b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }
}
