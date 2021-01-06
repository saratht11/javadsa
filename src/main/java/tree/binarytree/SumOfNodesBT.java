package tree.binarytree;

/**
 * https://www.geeksforgeeks.org/sum-nodes-binary-tree/
 */
public class SumOfNodesBT {
    Node root;

    public SumOfNodesBT(int key) {
        root = new Node(key);
    }

    public int sumOfNodes(Node node) {
        if (node == null) return 0;
        return node.key + sumOfNodes(node.left) + sumOfNodes(node.right);
    }

    public static void main(String[] args) {
        SumOfNodesBT treeTraversals = new SumOfNodesBT(1);
        treeTraversals.root.left = new Node(2);
        treeTraversals.root.right = new Node(3);
        treeTraversals.root.left.left = new Node(4);
        treeTraversals.root.left.right = new Node(5);
        //1+2+3+4+5=15
        System.out.println(treeTraversals.sumOfNodes(treeTraversals.root));
    }

}
