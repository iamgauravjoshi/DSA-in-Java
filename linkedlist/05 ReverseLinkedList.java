
class ReverseLinkedList {

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node reverse(Node head) {
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

    static Node solve(Node previous, Node current) {
        if (current == null) {
            return previous;
        }

        Node nextNode = current.next;
        current.next = previous;
        previous = current;
        current = nextNode;

        return solve(previous, current);
    }

    static Node recursiveReverse(Node head) {
        Node current = head;
        Node previous = null;

        return solve(previous, current);
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

        Node head = new Node(10);

        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        System.out.println("Before:");
        printList(head);

        // head = reverse(head);
        head = recursiveReverse(head);

        System.out.println("After:");
        printList(head);
    }
}
