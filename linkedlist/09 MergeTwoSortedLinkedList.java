
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
        Solution s = new Solution();
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
}

class Solution {

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
