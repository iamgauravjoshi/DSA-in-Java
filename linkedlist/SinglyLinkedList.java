public class SinglyLinkedList {
    
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
        if(head == null && tail == null) {
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
        if(head == null && tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void insertAtPosition(int position, int data) {
        if(position < 1 || position > size+1) {
            System.out.println("Invalid position. Insertion not possible at position " + position);
            return;
        } else if(position == 1) {
            insertAtHead(data);
            return;
        } else if (position == size+1) {
            insertAtTail(data);
            return;
        } else {
            Node newNode = new Node(data);
            Node prevNode = head;
            for(int i=1; i<position-1; i++) {
                prevNode = prevNode.next;
            }
            newNode.next = prevNode.next;
            prevNode.next = newNode;
        }
        size++;
    }

    // ====================
    //      TRAVERSAL 
    // ====================
    public void printList() {
        Node current = head;
        while(current.next != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
    public static void main(String[] args) {
        
    }
}