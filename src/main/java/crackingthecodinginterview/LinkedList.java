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

    public void remove(int index) {
        if (head == null) {
            return;
        }

        Node node = head;
        Node prev = head;
        while(index > 0) {
            if (node == null) {
                throw new IllegalArgumentException("Index greater than size of list");
            }
            prev = node;
            node = node.next;
            index--;
        }
        prev.next = node.next;
    }

    public void subList(int inclusizeStartIndex, int exclusiveEndIndex) {
        if (head == null) {
            return;
        }

        Node node = head;
        int i = 0;
        for (; i < inclusizeStartIndex; i++, node = node.next) {}
        head = node;
        for (; i < exclusiveEndIndex - 1; i++, node = node.next) {}
        node.next = null;
    }

    public int getValueAt(int index) {
        Node node = head;
        for (int i = 0; i < index; i++, node = node.next) {}
        return node.data;
    }

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
