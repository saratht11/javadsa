package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
 */
public class BinaryTreeTraversals {
    Node root;

    public BinaryTreeTraversals(int key) {
        root = new Node(key);
    }

    /**
     * Inorder (Left, Root, Right)
     */
    void printInOrder(Node node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.printf("%d ", node.key);
        printInOrder(node.right);
    }

    /**
     * Preorder (Root, Left, Right) :
     */
    void printPreOrder(Node node) {
        if (node == null) return;
        System.out.printf("%d ", node.key);
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    /**
     * Postorder (Left, Right, Root)
     */
    void printPostOrder(Node node) {
        if (node == null) return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.printf("%d ", node.key);
    }

    /**
     * t.c O(n^2)
     */
    void printLevelOrder(Node node) {
        int h = getHeight(node);
        for (int i = 0; i <= h; i++) {
            printCurrentNode(node, i);
        }
    }

    private int getHeight(Node node) {
        if (node == null) return 0;
        else {
            int lheight = getHeight(node.left);
            int rheight = getHeight(node.right);
            if (lheight > rheight)
                return lheight + 1;
            else
                return rheight + 1;

        }
    }

    private void printCurrentNode(Node node, int current) {
        if (node == null) return;
        if (current == 1) System.out.printf("%d", node.key);
        if (current > 1) {
            printCurrentNode(node.left, current - 1);
            printCurrentNode(node.right, current - 1);
        }
    }

    /**
     * t.c O(n)
     */
    public void printLevelOrderUsingQueue(Node node) {
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(node);
        while (!nodeQueue.isEmpty()) {
            Node tempNode = nodeQueue.poll();
            System.out.printf("%d", tempNode.key);
            if (tempNode.left != null) {
                nodeQueue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                nodeQueue.add(tempNode.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeTraversals treeTraversals = new BinaryTreeTraversals(1);
        treeTraversals.root.left = new Node(2);
        treeTraversals.root.right = new Node(3);
        treeTraversals.root.left.left = new Node(4);
        treeTraversals.root.left.right = new Node(5);

        System.out.println("printInOrder ->LRRi");
        treeTraversals.printInOrder(treeTraversals.root);
        System.out.printf("%nprintPostOrder -> lRiR%n");
        treeTraversals.printPostOrder(treeTraversals.root);
        System.out.printf("%nprintPreOrder -> RLRi%n");
        treeTraversals.printPreOrder(treeTraversals.root);
        System.out.printf("%nLevelOrder%n");
        treeTraversals.printLevelOrder(treeTraversals.root);
        System.out.printf("%nLevelOrderEff%n");
        treeTraversals.printLevelOrderUsingQueue(treeTraversals.root);
    }
}
