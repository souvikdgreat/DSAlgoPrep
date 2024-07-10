package practice;

import java.util.*;

public class Solution {
    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }


        // 1.) Implementation of  Node Class
        // if a tree is unbalanced
        //to check if a tree is BST
    }

    static class BST {
        private Node root;
        // public BST() {
        //     this.root = new Node();
        // }

        public void put(int value) {
            root =put(value, root);
        }

        private Node put(int value, Node node) {
            if (node == null) {
                node = new Node(value);
                return node;
            }

            if (value > node.data) {
                node.right = put(value, node.right);
                return node;
            }
            node.left = put(value, node.left);
            return node;
        }


        public boolean contains(int value) {
            return contains(value, root);
        }

        private boolean contains(int value, Node node) {
            // 3.) Implementation on contains method
            Node searchedNode = search(value, node);
            return searchedNode != null ? true : false;
        }

        private Node search(int value, Node node) {
            Node result = null;
            if (node == null || node.data == value) {
                result = node;
            } else if (value > node.data) {
                result = search(value, node.right);
            } else {
                result = search(value, node.left);
            }
            return result;
        }


        public List<Integer> inOrderTraversal() {
            final ArrayList<Integer> arr = new ArrayList<>();
            inOrderTraversal(root, arr);
            return arr;
        }

        private void inOrderTraversal(Node node, List<Integer> arr) {
            //4.) implementation of InOrderTraversal
            if (node == null) {
                return;
            }
            inOrderTraversal(node.left, arr);
            System.out.println(node.data);
            arr.add(node.data);
            inOrderTraversal(node.right, arr);
        }

    }

    public static void main(String[] args) {
        BST searchTree = new BST();
        searchTree.put(3);
        searchTree.put(1);
        searchTree.put(2);
        searchTree.put(5);
         if(Arrays.asList(1,2,3,5).equals(searchTree.inOrderTraversal())
                 && !searchTree.contains(0)
                 && searchTree.contains(1)
                 && searchTree.contains(2)
                 && searchTree.contains(3)
                 && !searchTree.contains(4)
                 && searchTree.contains(5)
                 && !searchTree.contains(6)){
             System.out.println("All Tests Passed...");
         }else {
             System.out.println("Test Cases Failed...");
         }
    }
}