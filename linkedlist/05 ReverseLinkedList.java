
class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();

        // list.reverseList();
    }

    //  Definition for singly-linked list. 
    static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prevNode = null;
        ListNode current = head;
        ListNode nextNode = current.next;

        while (current != null) {
            current.next = prevNode;
            prevNode = current;
            current = nextNode;
        }

        return prevNode;
    }
}
