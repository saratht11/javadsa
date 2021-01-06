package tree.binarytree;

/**
 * https://www.geeksforgeeks.org/binary-tree-set-1-introduction/
 */
public class BinaryTreeImpl {
    Node root;

    public BinaryTreeImpl(int key) {
        root = new Node(key);
    }

    public BinaryTreeImpl() {
        root = null;
    }

    public static void main(String[] args) {
        BinaryTreeImpl tree = new BinaryTreeImpl();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        /* 4 becomes left child of 2
                    1
                /       \
               2          3
             /   \       /  \
            4    null  null  null
           /   \
          null null
         */
    }
}
