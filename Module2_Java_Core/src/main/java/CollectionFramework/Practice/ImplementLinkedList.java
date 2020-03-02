package CollectionFramework.Practice;


public class ImplementLinkedList {
    private Node head;
    private int numNodes;

    public ImplementLinkedList(Object data) {
        this.head = new Node(data);
    }
    public class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }
    public void add (int index , Object data) {
        Node temp = head;
        Node holder;

        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }

    //Phương thức add first: thêm đối tượng vào vị trí đầu tiên trong ds

    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }





    //Phương thức printList: Hiển thị ds các phần tử trong ds.

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    // Phương thức get: lấy phần tử thứ index trong ds
    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println("TESTING");
        ImplementLinkedList ll = new ImplementLinkedList(10);
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(13);

        ll.add(4,9);
        ll.add(2,8);


        ll.printList();

        System.out.println("Value at index: ");
        System.out.println(ll.get(3).getData());
    }
}
