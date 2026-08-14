
class CircularDoublyLinkedList {

    static class Node {

        int data;
        Node previous;
        Node next;

        public Node(int data) {
            this.data = data;
            this.previous = null;
            this.next = null;
        }
    }

    // Data members
    private Node head;
    private Node tail;
    private int size;

    public CircularDoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // ====================
    //      INSERTION 
    // ====================
    public void insertAtHead(int data) {
        Node newNode = new Node(data);

        // Case 1: Empty list
        if (head == null && tail == null) {
            head = tail = newNode;
            newNode.next = newNode;
            newNode.previous = newNode;
            size++;
            return;
        }

        // Case 2: Non-empty list
        newNode.next = head;
        newNode.previous = tail;

        tail.next = newNode;
        head.previous = newNode;

        head = newNode;
        size++;
    }

    public void insertAtTail(int data) {
        Node newNode = new Node(data);

        // Case 1: Empty list
        if (head == null && tail == null) {
            head = tail = newNode;
            newNode.next = newNode;
            newNode.previous = newNode;
            size++;
            return;
        }

        // Case 2: Non-empty list
        newNode.next = head;
        newNode.previous = tail;

        tail.next = newNode;
        head.previous = newNode;

        tail = newNode;
        size++;
    }

    public void insertAtPosition(int position, int data) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position. Insertion not possible at position " + position);
            return;
        }

        if (position == 1) {
            insertAtHead(data);
            return;
        }

        if (position == size + 1) {
            insertAtTail(data);
            return;
        }

        /*
            The idea is:
                - If position is in the first half, traverse from head.
                - If position is in the second half, traverse from tail.
         */
        Node current;

        if (position <= size / 2) {
            current = head;
            for (int i = 1; i < position - 1; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size; i >= position; i--) {
                current = current.previous;
            }
        }

        Node newNode = new Node(data);

        newNode.previous = current;
        newNode.next = current.next;

        current.next.previous = newNode;
        current.next = newNode;
        size++;
    }

    // ====================
    //      DELETION 
    // ====================
    public void deleteHead() {
        // Case 1: Empty list
        if (head == null) {
            System.out.println("Circular Doubly LinkedList is empty.");
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
        head.next.previous = tail;
        head.next = null;
        head.previous = null;
        head = tail.next;
        size--;
    }

    public void deleteTail() {
        // Case 1: Empty list
        if (head == null) {
            System.out.println("Circular Doubly LinkedList is empty.");
            return;
        }

        // Case 2: Only one node
        if (head == tail) {
            head = tail = null;
            size--;
            return;
        }

        // Case 3: Multiple nodes
        head.previous = tail.previous;
        tail.previous.next = head;
        tail.next = null;
        tail.previous = null;
        tail = head.previous;
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
        Node current;

        if (position <= size / 2) {
            current = head;
            for (int i = 1; i < position; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size; i > position; i--) {
                current = current.previous;
            }
        }

        current.previous.next = current.next;
        current.next.previous = current.previous;
        current.next = current.previous = null;
        size--;
    }

    // Delete 1st occurrence of an element  ❌ (need to do)
    public boolean deleteValue(int target) {
        if (head == null) {
            System.out.println("Circular Singly LikedList is empty. No node to delete.");
            return false;
        }

        if (head.data == target) {
            deleteHead();
            return true;
        }

        System.out.println(target + " not found in circular linkedlist.");
        return false;
    }

    // ====================
    //      UPDATION    ❌ (need to do)
    // ====================
    // Update value using position
    public void updateAtPosition(int position, int newData) {
        if (position < 1 || position > size) {
            System.out.println("IndexOutOfBound. Given index " + position + " not found!");
            return;
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
            System.out.println("Circular Doubly LinkedList is empty.");
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
            System.out.println("Circular Doubly LinkedList is empty.");
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
    public void printForward() {
        if (head == null) {
            System.out.println("Circular Doubly LinkedList is empty.");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println("<-> Back to Head");
    }

    public void printBackward() {
        if (head == null) {
            System.out.println("Circular Doubly LinkedList is empty.");
            return;
        }

        Node current = tail;
        do {
            System.out.print(current.data + " ");
            current = current.previous;
        } while (current != tail);
        System.out.println("<-> Back to Tail");
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
            System.out.println("Circular Doubly LinkedList is already empty.");
        } else {
            head = tail = null;
            size = 0;
        }
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();

        // System.out.println("Is list empty? : " + list.isEmpty());
        list.insertAtHead(10);
        list.insertAtPosition(2, 20);
        list.insertAtTail(30);
        list.insertAtTail(40);
        list.insertAtTail(40);
        list.insertAtPosition(6, 50);
        list.printForward();

        // list.deleteHead();
        // list.printForward();
        // list.deleteTail();
        // list.printForward();
        // list.deleteAtPosition(3);
        // list.printForward();
        list.deleteValue(40);
        list.printForward();

        System.out.println("Is list empty? : " + list.isEmpty());
        System.out.println("Head : " + list.getHead());
        System.out.println("Tail : " + list.getTail());
        System.out.println("Size : " + list.getSize());
    }
}
