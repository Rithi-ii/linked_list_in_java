class Node {
    int data;
    Node next;

    Node(int x) {
        this.data = x;
        this.next = null;
    }
}

class Link {
    Node head, tail;

    void insert(int x) {
        Node newnode = new Node(x);

        if (head == null) {
            head = newnode;
            tail = newnode;
        } else {
            tail.next = newnode;
            tail = newnode;
        }
    }
    void insert_at_beginning(int x){
        Node newnode=new Node(x);
        if (head == null) {
            head = newnode;
            tail = newnode;
        }else{
            newnode.next=head;
            head=newnode;
        }

    }
    void insert_at_position(int x,int a){
        if(head==null){
            insert(x);
        }else{
            Node newnode=new Node(x);
            Node temp=head;
            for(int i=1;i<a;i++){
                temp=temp.next;
            }
            newnode.next=temp.next;
            temp.next=newnode;

        }
    }
    void delete_at_last(){
        if(head==null){
            return;
        }
        if(head.next==null){
            head=null;
            return;
        }
        Node temp=head;

        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
    }
    void delete_at_begnning(){
        if(head==null){
            return;
        }
        head=head.next;
    }
    void delete_at_position(int x){
        Node temp=head;
        for(int i=1;i<i-1;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
    }
    void delete_particular_element(int x){
        if(head==null){
            return;
        }
        if(head.data == x){
            delete_at_begnning();
            return;
        }
        Node temp=head.next;
        while(temp.next!=null && temp.next.data!=x){
            temp=temp.next;
        }
        temp.next=temp.next.next;
    }
    void update_at_first(int x){
        if(head==null){
            Node newnode=new Node(x);
            return;
        }
        Node newnode=new Node(x);
        newnode.next=head;
        head=newnode;

    }
    void update_at_last(int x){
        if(head==null){
            insert_at_beginning(x);
        }
        
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.data=x;
    }
    void update_at_position(int x,int a){
        if(head==null){
            insert_at_beginning(x);

        }
        Node temp=head;
        for(int i=1;i<a;i++){
            temp=temp.next;
        }
        temp.data=x;

    }

    void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data+" " );
            temp = temp.next;
        }
        System.out.println();
    }

}

public class Singlylinkedlist {
    public static void main(String[] args) {
        Link list = new Link();

        list.insert(10);
        list.insert(20);
        list.display();
        list.insert(30);
        list.display();
        list.insert(50);

        list.display();
        list.insert_at_beginning(0);
        list.display();
        list.insert_at_position(40,4 );
        list.display();
        list.delete_at_last();
        list.display();
        list.delete_at_last();
        list.display();
        list.delete_at_position(3);
        list.display();
        list.delete_particular_element(30);
        list.display();
        list.update_at_first(100);
        list.display();
        list.update_at_last(200);
        list.display();
        list.update_at_position(10, 3);
        list.display();
    }
}