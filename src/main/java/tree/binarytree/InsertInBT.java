package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/insertion-in-a-binary-tree-in-level-order/
 */
public class InsertInBT {
    Node root;

    public InsertInBT(int key) {
        root = new Node(key);
    }

    //left root right
    void printInOrder(Node node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.printf("%d ", node.key);
        printInOrder(node.right);
    }

    /**
     * Insert in level order
     */
    public void insertNode(Node node, int key) {
        if (root == null) {
            root = new Node(key);
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.left == null) {
                poll.left = new Node(key);
                break;
            } else {
                queue.add(poll.left);
            }

            if (poll.right == null) {
                poll.right = new Node(key);
                break;
            } else {
                queue.add(poll.right);
            }
        }
    }

    public static void main(String[] args) {
        InsertInBT insertInBT = new InsertInBT(10);
        insertInBT.root.left = new Node(11);
        insertInBT.root.left.left = new Node(7);
        insertInBT.root.right = new Node(9);
        insertInBT.root.right.left = new Node(15);
        insertInBT.root.right.right = new Node(8);
        /*
                    10
                   / \
                 11   9
                /     / \
              7     15  8
         */
        System.out.println("before");
        insertInBT.printInOrder(insertInBT.root);
        insertInBT.insertNode(insertInBT.root, 12);
        System.out.printf("%nafter%n ");
        insertInBT.printInOrder(insertInBT.root);

        /*
                    10
                   / \
                 11    9
                / \   / \
              7  12   15  8
         */
    }
}
