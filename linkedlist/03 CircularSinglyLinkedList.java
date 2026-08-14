
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
    //      DELETION 
    // ====================
    public void deleteHead() {
        // Case 1: Empty list
        if (head == null) {
            System.out.println("Circular LinkedList is empty.");
            return;
        }

        // Case 2: Only one node
        if (head == tail) {
            head = tail = null;
            size--;
            return;
        }

        // Case 3: Multiple nodes
        tail.next = head.next;
        head.next = null;
        head = tail.next;
        size--;
    }

    public void deleteTail() {
        // Case 1: Empty list
        if (head == null) {
            System.out.println("Circular Singly LinkedList is empty.");
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

        while (current.next != tail) {
            current = current.next;
        }

        current.next = head;
        tail.next = null;
        tail = current;
        size--;
    }

    // Delete at given position (1 based positioning)
    public void deleteAtPosition(int position) {
        // Case 1: Position is out of bound
        if (position < 1 || position > size) {
            System.out.println("IndexOutOfBound. Position: " + position + ", Size: " + size);
            return;
        }

        // Case 2: Delete the head (position 1)
        if (position == 1) {
            deleteHead();
            return;
        }

        // Case 3: Delete the tail (last position)
        if (position == size) {
            deleteTail();
            return;
        }

        // Case 4: Delete a node from the middle
        Node current = head;
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }

        Node nodeToDelete = current.next;
        current.next = nodeToDelete.next;
        nodeToDelete.next = null;
        size--;
    }

    // Delete 1st occurrence of an element
    public boolean deleteValue(int target) {
        if (head == null) {
            System.out.println("Circular Singly LikedList is empty. No node to delete.");
            return false;
        }

        if (head.data == target) {
            deleteHead();
            return true;
        }

        Node current = head;

        while (current.next != head) {

            if (current.next.data == target) {
                // If deleting the tail, update tail
                if (current.next == tail) {
                    tail = current;
                }

                Node nodeToDelete = current.next;
                current.next = nodeToDelete.next;
                nodeToDelete.next = null;
                size--;
                return true;
            }
            current = current.next;
        }

        System.out.println(target + " not found in circular linkedlist.");
        return false;
    }

    // ====================
    //      UPDATION 
    // ====================
    // Update value using position
    public void updateAtPosition(int position, int newData) {
        if (position < 1 || position > size) {
            System.out.println("IndexOutOfBound. Given index " + position + " not found!");
            return;
        }
        Node current = head;
        for (int i = 1; i <= position; i++) {
            if (i == position) {
                current.data = newData;
                return;
            } else {
                current = current.next;
            }
        }
    }

    // Update first occurance of value
    public boolean updateValue(int oldValue, int newValue) {
        return false;
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
    //      TRAVERSAL 
    // ====================
    public void printList() {
        if (head == null) {
            System.out.println("Circular Singly LinkedList is empty.");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    // ====================
    //  UTILITY FUNCTIONS 
    // ====================
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getHead() {
        if (head == null) {
            return -1;
        }
        return head.data;
    }

    public int getTail() {
        if (tail == null) {
            return -1;
        }
        return tail.data;
    }

    public void clear() {
        if (head == null) {
            System.out.println("Circular Singly LinkedList is already empty.");
        } else {
            head = tail = null;
            size = 0;
        }
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();

        // System.out.println("Is list empty? : " + list.isEmpty());
        list.insertAtHead(10);
        list.insertAtPosition(2, 20);
        list.insertAtTail(30);
        list.insertAtTail(40);
        list.insertAtTail(40);
        list.insertAtPosition(6, 50);
        list.printList();

        // list.deleteHead();
        // list.printList();
        // list.deleteTail();
        // list.printList();
        // list.deleteAtPosition(3);
        // list.printList();
        list.deleteValue(40);
        list.printList();

        System.out.println("Is list empty? : " + list.isEmpty());
        System.out.println("Head : " + list.getHead());
        System.out.println("Tail : " + list.getTail());
        System.out.println("Size : " + list.getSize());
    }
}
