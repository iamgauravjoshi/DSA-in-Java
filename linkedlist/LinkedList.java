class LinkedList {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Insertion of a node in beginning/start of LinkedList
    public void insertAtBeginning(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    // Insertion of a node at the end of LinkedList
    public void insertAtEnd(int newData) {
        Node newNode = new Node(newData);
        newNode.next = null;

        // check if LinkedList is empty or not?
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void insertAfter(Node prevNode, int newData) {
        if(prevNode == null) {
            System.out.println("The previous node can't contain null values!");
            return;
        }

        Node newNode = new Node(newData);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    public void deleteNode(int position) {
        // LinkedList is empty
        if(head == null) {
            return;
        }

        Node current = head;
        // Deletion is in the beginning of the list
        if(position == 0) {
            head = current.next;
            return;
        }

        // deletion is not in the beginning
        for(int i=0; current!=null && i<position-1; i++) {
            current = current.next;
        }

        if(current == null) {
            return;
        }

        current.next = current.next.next;
    }

    public void displayLinkedList() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtEnd(2);
        ll.insertAtEnd(5);
        ll.insertAtEnd(6);
        ll.displayLinkedList();

        ll.insertAtEnd(8);
        ll.insertAtEnd(10);
        System.out.println("After insertion at end");
        ll.displayLinkedList();
        System.out.println("\n");
        
        ll.insertAtBeginning(1);

        System.out.println("After insertion at start");
        ll.displayLinkedList();
        System.out.println("\n");

        System.out.println("Insert after a perticular node");
        ll.insertAfter(ll.head.next, 3);
        ll.insertAfter(ll.head.next.next, 4);
        ll.displayLinkedList();
        System.out.println("\n");

        System.out.println("Delete a perticular node");
        ll.deleteNode(0);
        // ll.deleteNode(7);
        ll.displayLinkedList();
    }
}