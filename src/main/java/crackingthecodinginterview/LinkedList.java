package crackingthecodinginterview;

public class LinkedList {

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void insert(int data){
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node node = head;
        while(node.next != null) {
            node = node.next;
        }

        node.next = new Node(data);
        return;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        Node node = head;
        while(node != null) {
            sb.append(node.data);
            if (node.next != null) {
                sb.append(", ");
            }
            node = node.next;
        }

        sb.append("]");
        return sb.toString();
    }

    public void reverse() {
        if (head == null || head.next == null) {
            return;
        }

        Node prev = null;
        Node curr = head;
        Node next = head.next;
        while(next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        head = curr;
    }

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
