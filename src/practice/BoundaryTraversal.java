package practice;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {
    /*
     *  in order traversal gives the result in sorted order
     * */
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        Node n1 = new Node(8);
        Node n2 = new Node(22);
        Node n3 = new Node(4);
        Node n4 = new Node(12);
        Node n5 = new Node(25);
        Node n6 = new Node(10);
        Node n7 = new Node(14);

        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.right = n5;
        n4.left = n6;
        n4.right = n7;
        List<Integer> result = new ArrayList<>();
        printBoundary(root, result);
        System.out.println(result);
    }

    public static void printBoundary(Node root, List<Integer> result) {
        //print the left
        //print the leaves for left
        //print the leaves for right
        //print the right
        if (root == null) {
            return;
        }
        result.add(root.data);
        System.out.println(root.data);
        printBoundaryLeft(root.left,result);
        printLeaves(root.left,result);
        printLeaves(root.right,result);
        printBoundaryRight(root.right,result);
    }


    static void printBoundaryLeft(Node node, List<Integer> result) {
        if (node == null)
            return;

        if (node.left != null) {
            result.add(node.data);
            System.out.println(node.data + " ");
            printBoundaryLeft(node.left, result);
        } else if (node.right != null) {
            result.add(node.data);
            System.out.println(node.data + " ");
            printBoundaryLeft(node.right, result);
        }
    }

    static void printLeaves(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        printLeaves(node.left, result);
        if (node.left == null && node.right == null) {
            result.add(node.data);
            System.out.println(node.data);
        }
        printLeaves(node.right, result);
    }

    static void printBoundaryRight(Node node, List<Integer> result) {
        if (node == null)
            return;

        if (node.right != null) {
            result.add(node.data);
            System.out.print(node.data + " ");
            printBoundaryRight(node.right, result);
        } else if (node.left != null) {
            System.out.print(node.data + " ");
            result.add(node.data);
            printBoundaryRight(node.left, result);
        }
    }
}
