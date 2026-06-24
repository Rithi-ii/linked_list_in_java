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

class CircularDoubly {
    Node head, tail;

    CircularDoubly() {
        head = null;
        tail = null;
    }

    // Insert at End
    void insert(int x) {
        Node newnode = new Node(x);

        if (head == null) {
            head = tail = newnode;
            head.next = head;
            head.prev = head;
        } else {
            newnode.prev = tail;
            newnode.next = head;

            tail.next = newnode;
            head.prev = newnode;

            tail = newnode;
        }
    }

    // Insert at Beginning
    void insert_at_start(int x) {
        Node newnode = new Node(x);

        if (head == null) {
            head = tail = newnode;
            head.next = head;
            head.prev = head;
            return;
        }

        newnode.next = head;
        newnode.prev = tail;

        head.prev = newnode;
        tail.next = newnode;

        head = newnode;
    }

    // Insert at End
    void insert_at_end(int x) {
        insert(x);
    }

    // Insert at Position
    void insert_at_position(int x, int pos) {
        if (pos <= 1 || head == null) {
            insert_at_start(x);
            return;
        }

        Node temp = head;
        int count = 1;

        while (count < pos - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        if (temp == tail) {
            insert_at_end(x);
            return;
        }

        Node newnode = new Node(x);

        newnode.next = temp.next;
        newnode.prev = temp;

        temp.next.prev = newnode;
        temp.next = newnode;
    }

    // Delete at Beginning
    void delete_at_start() {
        if (head == null) {
            System.out.println("List Empty");
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        head = head.next;
        head.prev = tail;
        tail.next = head;
    }

    // Delete at End
    void delete_at_end() {
        if (head == null) {
            System.out.println("List Empty");
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        tail = tail.prev;
        tail.next = head;
        head.prev = tail;
    }

    // Delete at Position
    void delete_at_position(int pos) {
        if (head == null) {
            System.out.println("List Empty");
            return;
        }

        if (pos == 1) {
            delete_at_start();
            return;
        }

        Node temp = head;
        int count = 1;

        while (count < pos && temp.next != head) {
            temp = temp.next;
            count++;
        }

        if (count != pos) {
            System.out.println("Invalid Position");
            return;
        }

        if (temp == tail) {
            delete_at_end();
            return;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    // Delete by Key
    void delete_by_key(int key) {
        if (head == null) {
            System.out.println("List Empty");
            return;
        }

        Node temp = head;

        do {
            if (temp.data == key) {

                if (head == tail) {
                    head = tail = null;
                    return;
                }

                if (temp == head) {
                    delete_at_start();
                    return;
                }

                if (temp == tail) {
                    delete_at_end();
                    return;
                }

                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;

                return;
            }

            temp = temp.next;

        } while (temp != head);

        System.out.println("Key Not Found");
    }

    // Display Forward
    void display() {
        if (head == null) {
            System.out.println("List Empty");
            return;
        }

        Node temp = head;

        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }

    // Display Reverse
    void reverseDisplay() {
        if (tail == null) {
            System.out.println("List Empty");
            return;
        }

        Node temp = tail;

        do {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        } while (temp != tail);

        System.out.println();
    }
}

public class circulardoublylinkedlist {

    public static void main(String[] args) {

        CircularDoubly a = new CircularDoubly();

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
        System.out.println("After deleting first node:");
        a.display();

        a.delete_at_end();
        System.out.println("After deleting last node:");
        a.display();

        a.delete_at_position(3);
        System.out.println("After deleting position 3:");
        a.display();

        a.delete_by_key(40);
        System.out.println("After deleting key 40:");
        a.display();
    }
}