package linkedlist;

/**
 * Basics
 * https://www.geeksforgeeks.org/linked-list-set-1-introduction/
 * https://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/
 * https://www.geeksforgeeks.org/linked-list-set-3-deleting-node/
 */
public class LinkedListImpl {
    Node head;

    public LinkedListImpl() {
        this.head = null;
    }

    public void traverseNode() {
        Node data = head;
        while (data != null) {
            System.out.print(data.data + " -> ");
            data = data.nextNode;
        }
    }

    public void pushAtHead(int data) {
        Node newNode = new Node(data);
        newNode.nextNode = head;
        head = newNode;
    }

    public void insertAtEnd(int data) {
        Node newNode = head;
        if (newNode == null) {
            head = new Node(data);
            return;
        }
        while (newNode.nextNode != null) {
            newNode = newNode.nextNode;
        }
        newNode.nextNode = new Node(data);
    }

    public void insetAfter(Node previousNode, int data) {
        if (previousNode == null) {
            return;
        }
        Node newNode = new Node(data);
        newNode.nextNode = previousNode.nextNode;
        previousNode.nextNode = newNode;
    }

    public void deleteNode(int data) {
        Node node = head;
        if (node == null) {
            return;
        }
        if (node.data == data) {
            head = node.nextNode;
            return;
        }
        while (node.nextNode != null) {
            if (data == node.nextNode.data) {
                node.nextNode = node.nextNode.nextNode;
                return;
            }
            node = node.nextNode;
        }

    }

    public void deleteNodeAt(int position) {
        Node current = head;
        if (current == null) {
            return;
        }
        if (position == 1) {
            head = current.nextNode;
            return;
        }
        for (int i = 1; current != null && i < position-1; i++) {
            current = current.nextNode;
        }
        if (current == null || current.nextNode == null) {
            return;
        }
        current.nextNode = current.nextNode.nextNode;
    }

    public static void main(String[] args) {
        LinkedListImpl list = new LinkedListImpl();
        list.head = new Node(1);
        list.head.nextNode = new Node(2);
        list.head.nextNode.nextNode = new Node(3);
        list.pushAtHead(0);
        list.insertAtEnd(4);
        list.insetAfter(list.head.nextNode.nextNode, 5);
        list.traverseNode();
        System.out.println();
        list.deleteNode(5);
        list.traverseNode();
        System.out.println();
        list.deleteNodeAt(3);
        list.traverseNode();
    }
}
