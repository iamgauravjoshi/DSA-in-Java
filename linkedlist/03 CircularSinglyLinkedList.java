
class CircularSinglyLinkedList {

    static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Data members
    private Node head;
    private Node tail;
    private int size;

    public CircularSinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // ====================
    //      INSERTION 
    // ====================
    public void insertAtHead(int data) {
        Node newNode = new Node(data);

        if (head == null && tail == null) {
            head = tail = newNode;
            tail.next = newNode;
        }
        newNode.next = head;
        head = newNode;

        tail.next = newNode;
        size++;
    }

    public void insertAtTail(int data) {
        Node newNode = new Node(data);

        if (head == null && tail == null) {
            head = tail = newNode;
            tail.next = head;
        }

        tail.next = newNode;
        tail = newNode;
        tail.next = head;

        size++;
    }

    public void insertAtPosition(int position, int data) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position. Insertion not possible at position " + position);
        }

        if (position == 1) {
            insertAtHead(data);
            return;
        }

        if (position == size + 1) {
            insertAtTail(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;

        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    // ====================
    //      TRAVERSAL 
    // ====================
    public void printList() {
        if (head == null) {
            System.out.println("Circular LinkedList is empty.");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
    }

    // ====================
    //      SEARCHING 
    // ====================
    public boolean search(int target) {
        if (head == null) {
            System.out.println("Circular LinkedList is empty.");
            return false;
        }

        Node current = head;

        do {
            if (current.data == target) {
                return true;
            }
            current = current.next;
        } while (current != head);

        return false;
    }

    public int findPosition(int target) {
        if (head == null) {
            return -1;
        }

        Node current = head;
        int index = 1;

        do {
            if (current.data == target) {
                return index;
            }
            current = current.next;
            index++;
        } while (current != head);

        return -1;
    }

    // ====================
    //      DELETION 
    // ====================
    public void deleteHead() {
        // Case 1: Empty list
        if (head == null) {
            System.out.println("LinkedList is empty");
            return;
        }

        // Case 2: Only one node
        if (head == tail) {
            head.next = null;
            head = tail = null;
            size--;
            return;
        }

        // Case 3: Multiple nodes
        Node temp = head;
        head.next = null;
        head = temp.next;
        tail.next = head;
        size--;
    }

    public void deleteTail() {
        // Case 1: Empty list
        if (head == null) {
            System.out.println("LinkedList is already empty");
            return;
        }

        // Case 2: Only one node
        if (head == tail) {
            head.next = null;
            head = tail = null;
            size--;
            return;
        }

        // Case 3: Multiple nodes
        Node current = head;
        for (int i = 1; i < size - 1; i++) {
            current = current.next;
        }
        current.next = head;
        tail.next = null;
        tail = current;
        size--;
    }

    public void deleteAtPosition(int position) {

    }

    // Delete 1st occurrence of an element
    public boolean deleteValue(int target) {
        return false;
    }

    public static void main(String[] args) {

    }
}
