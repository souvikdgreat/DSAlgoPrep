package gsPractice;

import gsPractice.trainMap.Visited;

import java.util.*;

public class InfectedBst {
    static Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
    static Set<Integer> visited = new HashSet<>();


    private static void traverse(Integer prev, TreeNode root) {
        if (root == null) {
            return;
        }

        int curr = root.data;
        if (prev != null) {
            List<Integer> l1 = adjacencyMap.getOrDefault(prev, new ArrayList<>());
            l1.add(curr);
            adjacencyMap.put(prev, l1);

            List<Integer> l2 = adjacencyMap.getOrDefault(curr, new ArrayList<>());
            l2.add(prev);
            adjacencyMap.put(curr, l2);
        }
        traverse(curr, root.left);
        traverse(curr, root.right);
    }


    public static int getNoOfInfectedNodes(TreeNode root, int start) {
        int result = 0;
        traverse(null, root);
        System.out.println(adjacencyMap);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                List<Integer> adjList = adjacencyMap.getOrDefault(curr, new ArrayList<>());
                for (int j = 0; j < adjList.size(); j++) {
                    if (visited.contains(adjList.get(j))) {
                        continue;
                    }
                    visited.add(adjList.get(j));
                    queue.add(adjList.get(j));
                }
            }
        }
        return result - 1;
    }


    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rootLeft = new TreeNode(5);
        TreeNode rootRight = new TreeNode(3);
        root.left = rootLeft;
        root.right = rootRight;

        TreeNode rootLeftRight = new TreeNode(4);
        rootLeft.right = rootLeftRight;


        TreeNode rootRightLeft = new TreeNode(10);
        TreeNode rootRightRight = new TreeNode(6);
        rootRight.left = rootRightLeft;
        rootRight.right = rootRightRight;

        TreeNode rootLeftRightLeft = new TreeNode(9);
        TreeNode rootLeftRightRight = new TreeNode(2);
        rootLeftRight.left = rootLeftRightLeft;
        rootLeftRight.right = rootLeftRightRight;

        System.out.println(getNoOfInfectedNodes(root, 3));
    }
}
