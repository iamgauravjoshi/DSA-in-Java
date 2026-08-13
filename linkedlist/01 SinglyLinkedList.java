
class SinglyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    // Node class
    public static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Class constructor
    public SinglyLinkedList() {
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
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
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
            Node prevNode = head;
            for (int i = 1; i < position - 1; i++) {
                prevNode = prevNode.next;
            }
            newNode.next = prevNode.next;
            prevNode.next = newNode;
            size++;
        }
    }

    // ====================
    //      DELETION 
    // ====================
    public void deleteHead() {
        if (head == null) {
            System.out.println("LinkedList is already empty");
            return;
        }

        if (head == tail) {
            head = tail = null;
            size--;
            return;
        }

        Node current = head;
        head.next = null;
        head = current.next;
        size--;
    }

    public void deleteTail() {
        if (head == null) {
            System.out.println("LinkedList is already empty");
            return;
        }

        if (head == tail) {
            head = tail = null;
            size--;
            return;
        }

        Node current = head;

        for (int i = 1; i < size - 1; i++) {
            current = current.next;
        }

        current.next = null;
        tail = current;
        size--;
    }

    public void deleteAtPosition(int position) {
        if (position < 1 || position > size) {
            System.out.println("IndexOutOfBound. Given index " + position + " not found!");
            return;
        }

        if (position == 1) {
            deleteHead();
            return;
        }

        if (position == size) {
            deleteTail();
            return;
        }

        Node current = head;

        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }

        current.next = current.next.next;
        current.next.next = null;
        size--;
    }

    // Delete 1st occurrence of an element
    public boolean deleteValue(int target) {
        if (head == null) {
            System.out.println("No value to delete. LinkedList is empty.");
            return false;
        } else if (head.data == target) {
            deleteHead();
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == target) {
                Node nodeToDelete = current.next;
                current.next = nodeToDelete.next;

                if (nodeToDelete == tail) {
                    tail = current;
                }

                nodeToDelete.next = null;
                size--;
                return true;
            }
            current = current.next;
        }

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

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // if(list.isEmpty()) {
        //     System.out.println("List is empty");
        // }
        // System.out.println("Size of LL: " + list.getSize());
        // list.insertAtHead(10);
        // list.printList();
        // list.insertAtHead (20);
        // list.printList();
        // list. insertAtHead (30);
        // list.printList();
        // list.insertAtTail(100);
        // list.printList();
        // list. insertAtTail(110);
        // list.printList();
        // list.insertAtTail(120);
        // list.printList();
        // list.insertAtPosition(1, 1);
        // list.printList();
        // list.insertAtPosition(10, 7);
        // list.insertAtPosition(7, 7);
        // list.printList();
        // System.out.println("Is 20 exists: " + list.search(20));
        // System.out.println("Node 110 position: " + list.findPosition(110));
        // list.updateAtPosition(8, 8);
        // list.updateValue(15, 25);
        // list.printList();
        // list.clear();
        // list.printList();
        list.insertAtHead(10);
        list.insertAtTail(20);
        list.insertAtTail(30);
        list.printList();

        // System.out.println("----- Head Deletion -----");
        // System.out.println("head data: " + list.getHead());
        // System.out.println("tail data: " + list.getTail());
        // System.out.println("list size: " + list.getSize());
        // list.deleteHead();
        // System.out.println();
        // System.out.println("head data: " + list.getHead());
        // System.out.println("tail data: " + list.getTail());
        // System.out.println("list size: " + list.getSize());
        // list.deleteHead();
        // list.printList();
        // System.out.println();
        // System.out.println("head data: " + list.getHead());
        // System.out.println("tail data: " + list.getTail());
        // System.out.println("list size: " + list.getSize());
        // System.out.println("----- Tail Deletion -----");
        // System.out.println("head data: " + list.getHead());
        // System.out.println("tail data: " + list.getTail());
        // System.out.println("list size: " + list.getSize());
        // list.deleteTail();
        // System.out.println();
        // System.out.println("head data: " + list.getHead());
        // System.out.println("tail data: " + list.getTail());
        // System.out.println("list size: " + list.getSize());
        // list.deleteTail();
        // list.printList();
        // System.out.println();
        // System.out.println("head data: " + list.getHead());
        // System.out.println("tail data: " + list.getTail());
        // System.out.println("list size: " + list.getSize());
        list.deleteAtPosition(2);
        list.printList();
    }
}
