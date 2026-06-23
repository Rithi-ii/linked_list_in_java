class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class circular {
    Node head, tail;

    circular() {
        head = null;
        tail = null;
    }

    // Insert at beginning
    void insert_at_beginning(int x) {
        Node newnode = new Node(x);

        if (head == null) {
            head = tail = newnode;
            tail.next = head;
        } else {
            newnode.next = head;
            head = newnode;
            tail.next = head;
        }
    }

    // Insert at end
    void insert_at_end(int x) {
        Node newnode = new Node(x);

        if (head == null) {
            head = tail = newnode;
            tail.next = head;
        } else {
            tail.next = newnode;
            tail = newnode;
            tail.next = head;
        }
    }

    // Insert at position (1-based)
    void insert_at_position(int x, int pos) {
        if (pos == 1 || head == null) {
            insert_at_beginning(x);
            return;
        }

        Node newnode = new Node(x);
        Node temp = head;

        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        newnode.next = temp.next;
        temp.next = newnode;

        if (temp == tail) {
            tail = newnode;
            tail.next = head;
        }
    }

    // Delete at beginning
    void delete_at_beginning() {
        if (head == null)
            return;

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
    }

    // Delete at end
    void delete_at_end() {
        if (head == null)
            return;

        if (head == tail) {
            head = tail = null;
            return;
        }

        Node temp = head;

        while (temp.next != tail) {
            temp = temp.next;
        }

        temp.next = head;
        tail = temp;
    }

    // Delete at position (1-based)
    void delete_at_position(int pos) {
        if (head == null)
            return;

        if (pos == 1) {
            delete_at_beginning();
            return;
        }

        Node temp = head;

        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        Node del = temp.next;

        if (del == tail) {
            tail = temp;
        }

        temp.next = del.next;
        tail.next = head;
    }

    // Delete by key
    void delete_by_key(int key) {
        if (head == null)
            return;

        if (head.data == key) {
            delete_at_beginning();
            return;
        }

        Node prev = head;
        Node curr = head.next;

        while (curr != head && curr.data != key) {
            prev = curr;
            curr = curr.next;
        }

        if (curr == head) {
            System.out.println("Key not found");
            return;
        }

        if (curr == tail) {
            tail = prev;
        }

        prev.next = curr.next;
        tail.next = head;
    }

    // Search
    void search(int key) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        int pos = 1;

        do {
            if (temp.data == key) {
                System.out.println(key + " found at position " + pos);
                return;
            }
            temp = temp.next;
            pos++;
        } while (temp != head);

        System.out.println("Key not found");
    }

    // Display
    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }
}

public class circularlinkedlist {
    public static void main(String[] args) {
        circular a = new circular();

        a.insert_at_beginning(20);
        a.insert_at_beginning(10);
        a.insert_at_end(40);
        a.insert_at_position(30, 3);
        a.insert_at_end(50);

        System.out.println("Original List:");
        a.display();

        a.delete_at_beginning();
        System.out.println("After deleting first:");
        a.display();

        a.delete_at_end();
        System.out.println("After deleting last:");
        a.display();

        a.delete_at_position(2);
        System.out.println("After deleting position 2:");
        a.display();

        a.delete_by_key(40);
        System.out.println("After deleting key 40:");
        a.display();

        a.search(30);
    }
}