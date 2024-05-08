package gsPractice;

public class BST {
    Node root;

    public Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        } else {
            if (node.data > root.data) {
                node.right = insert(root.right, data);
            } else {
                node.left = this.insert(root.left, data);
            }
        }
        return node;
    }

    public Node search(Node root, int data) {
        if (root == null || root.data == data) {
            return root;
        }

        if (data > root.data) {
            return search(root.right, data);
        }

        return search(root.left, data);
    }

    public boolean contains(int data) {
        return search(root, data) != null;
    }

    public void preorder(Node root) {
        if (root == null) {
            return;
        }
        preorder(root.left);
        System.out.println(root.data);
        preorder(root.right);
    }

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}