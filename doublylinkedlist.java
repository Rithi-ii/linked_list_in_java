class Node {
    int data;
    Node next;
    Node prev;

    Node(int x) {
        data = x;
        next = null;
        prev = null;
    }
}

class doubly {
    Node head, tail;

    doubly() {
        head = null;
        tail = null;
    }

    // Insert at end
    void insert(int x) {
        Node newnode = new Node(x);

        if (head == null) {
            head = tail = newnode;
        } else {
            tail.next = newnode;
            newnode.prev = tail;
            tail = newnode;
        }
    }

    void insert_at_start(int x) {
        Node newnode = new Node(x);

        if (head == null) {
            head = tail = newnode;
            return;
        }

        newnode.next = head;
        head.prev = newnode;
        head = newnode;
    }

    void insert_at_end(int x) {
        insert(x);
    }

    void insert_at_position(int x, int pos) {
        if (head == null || pos == 1) {
            insert_at_start(x);
            return;
        }

        Node temp = head;

        for (int i = 1; i < pos - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        Node newnode = new Node(x);

        newnode.next = temp.next;
        newnode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newnode;
        } else {
            tail = newnode;
        }

        temp.next = newnode;
    }

    // Delete first node
    void delete_at_start() {
        if (head == null)
            return;

        if (head == tail) {
            head = tail = null;
            return;
        }

        head = head.next;
        head.prev = null;
    }

    // Delete last node
    void delete_at_end() {
        if (head == null)
            return;

        if (head == tail) {
            head = tail = null;
            return;
        }

        tail = tail.prev;
        tail.next = null;
    }

    // Delete node at position
    void delete_at_position(int pos) {
        if (head == null)
            return;

        if (pos == 1) {
            delete_at_start();
            return;
        }

        Node temp = head;

        for (int i = 1; i < pos && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null)
            return;

        if (temp == tail) {
            delete_at_end();
            return;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    // Delete by key/value
    void delete_by_key(int key) {
        if (head == null)
            return;

        Node temp = head;

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Key not found");
            return;
        }

        if (temp == head) {
            delete_at_start();
        } else if (temp == tail) {
            delete_at_end();
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    // Display forward
    void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    // Display reverse
    void reverseDisplay() {
        Node temp = tail;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }

        System.out.println();
    }
}

public class doublylinkedlist {
    public static void main(String[] args) {
        doubly a = new doubly();

        a.insert(10);
        a.insert(20);
        a.insert(30);
        a.insert(40);
        a.insert(50);

        System.out.println("Original List:");
        a.display();

        a.insert_at_start(5);
        a.insert_at_end(60);
        a.insert_at_position(25, 4);

        System.out.println("After Insertions:");
        a.display();

        System.out.println("Reverse Display:");
        a.reverseDisplay();

        a.delete_at_start();
        System.out.println("After deleting first:");
        a.display();

        a.delete_at_end();
        System.out.println("After deleting last:");
        a.display();

        a.delete_at_position(3);
        System.out.println("After deleting position 3:");
        a.display();

        a.delete_by_key(40);
        System.out.println("After deleting key 40:");
        a.display();
    }
}