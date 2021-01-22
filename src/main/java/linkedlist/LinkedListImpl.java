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
        for (int i = 1; current != null && i < position - 1; i++) {
            current = current.nextNode;
        }
        if (current == null || current.nextNode == null) {
            return;
        }
        current.nextNode = current.nextNode.nextNode;
    }

    public int findLength(Node node) {
        int length = 0;
        while (node != null) {
            node = node.nextNode;
            length++;
        }
        return length;
    }

    public int findLengthRec(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + findLength(node.nextNode);
    }

    public boolean isAvailable(Node node, int data) {
        while (node != null) {
            if (node.data == data) {
                return true;
            }
            node = node.nextNode;
        }
        return false;
    }

    public boolean isAvailableRec(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (node.data == data) return true;
        return isAvailable(node.nextNode, data);
    }

    public int getDataAt(Node node, int position) {
        int count = 0;
        while (node != null) {
            if (count == position) return node.data;
            count++;
            node = node.nextNode;
        }
        return -1;
    }

    public int getDataAtRec(Node node, int position) {
        if (node == null) {
            return -1;
        }
        if (position == 0) return node.data;
        return getDataAtRec(node.nextNode, position - 1);
    }

    /**
     * option 1
     */
    public int findMiddleElement(Node node) {
        if (node != null) {
            Node slowPointer = node;
            Node fastPointer = node;
            while (fastPointer != null && fastPointer.nextNode != null) {
                slowPointer = slowPointer.nextNode;
                fastPointer = fastPointer.nextNode.nextNode;
            }
            return slowPointer.data;
        }
        return -1;
    }

    public int findMiddleElement2(Node node) {
        if (node != null) {
            Node mid = node;
            int count = 0;
            while (node != null) {
                if (count % 2 == 1) mid = mid.nextNode;
                node = node.nextNode;
                count++;
            }
            return mid.data;
        }
        return -1;
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
        System.out.println();
        System.out.println("length");
        System.out.println(list.findLength(list.head));
        System.out.println(list.findLengthRec(list.head));
        System.out.println(list.isAvailable(list.head, 7));
        System.out.println(list.isAvailableRec(list.head, 4));
        System.out.println("find data");
        System.out.println(list.getDataAt(list.head, 3));
        System.out.println(list.getDataAtRec(list.head, 2));
        list.insertAtEnd(5);
        list.insertAtEnd(6);
        list.insertAtEnd(7);
        list.traverseNode();
        System.out.println("find middle element");
        System.out.println(list.findMiddleElement(list.head));
        System.out.println(list.findMiddleElement2(list.head));
    }
}
