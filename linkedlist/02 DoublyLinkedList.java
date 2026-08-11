
class DoublyLinkedList {

    // Data members
    private Node head;
    private Node tail;
    private int size;

    public static class Node {

        Node previous;
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
            this.previous = null;
            this.next = null;
        }
    }

    public DoublyLinkedList() {
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
            return;
        } else {
            head.previous = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void insertAtTail(int data) {
        Node newNode = new Node(data);

        if (head == null && tail == null) {
            head = tail = newNode;
            return;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    public void insertAtPosition(int position, int data) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position. Insertion not possible at position " + position);
        } else if (position == 1) {
            insertAtHead(data);
        } else if (position == size + 1) {
            insertAtTail(data);
        } else {
            Node newNode = new Node(data);
            Node current = head;
            for (int i = 1; i < position - 1; i++) {
                current = current.next;
            }

            newNode.next = current.next;
            newNode.previous = current;

            current.next.previous = newNode;
            current.next = newNode;
            size++;
        }
    }

    // ====================
    //      TRAVERSAL 
    // ====================
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void printBackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.previous;
        }
        System.out.println();
    }

    // ====================
    //      SEARCHING 
    // ====================
    public boolean search(int target) {
        Node current = head;
        while (current != null) {
            if (current.data == target) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int findPosition(int target) {
        Node current = head;
        int index = 1;
        while (current != null) {
            if (current.data == target) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
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
        } else {
            return head.data;
        }
    }

    public int getTail() {
        if (tail == null) {
            return -1;
        } else {
            return tail.data;
        }
    }

    public void clear() {
        if (head == null) {
            System.out.println("LinkedList is already empty");
        } else {
            head = null;
            tail = null;
            size = 0;
        }
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
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }
        current.data = newData;
    }

    // Update first occurance of value
    public boolean updateValue(int oldValue, int newValue) {
        Node current = head;
        while (current != null) {
            if (current.data == oldValue) {
                current.data = newValue;
                return true;
            } else {
                current = current.next;
            }
        }
        System.out.println("Node not found with value " + oldValue);
        return false;
    }

    // ====================
    //      DELETION 
    // ====================
    public void deleteHead() {
        if (head == null) {
            System.out.println("LinkedList is already empty");
            return;
        } else if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        size--;
    }

    public void deleteTail() {
        if (head == null) {
            System.out.println("LinkedList is already empty");
            return;
        } else if (head == tail) {
            head = tail = null;
        } else {
            Node current = head;
            for (int i = 1; i < size - 1; i++) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
        size--;
    }

    public void deleteAtPosition(int position) {

    }

    public boolean deleteValue(int target) {
        return false;
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertAtHead(20);
        list.insertAtHead(10);
        list.printList();

        list.insertAtTail(40);
        list.insertAtTail(50);
        list.printList();

        list.insertAtPosition(3, 30);
        list.printList();
        list.printBackward();
        System.out.println("Doubly Linked List");
    }
}
