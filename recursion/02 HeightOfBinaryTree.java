/*
Problem: Height of Binary Tree
Given the root of a binary tree, find the maximum depth of the tree.

Note: The maximum depth or height of the tree is the number of edges in the tree from the root to the deepest node.

# Example 01:
Input: root = [12, 8, 18, 5, 11]
Output: 2
Explanation: One of the longest path from the root(node 12) goes through node 8 to node 5, which has 2 edges.

# Example 02:
Input: root = [1, 2, 3, 4, N, 10, 5, N, N, N, N, 6, 7]
Output: 3
Explanation: The longest path from the root(node 1) to a leaf node 6 with 3 edges.

# Constraints:
    -> 1 ≤ size of binary tree ≤ 3*104
    -> 0 ≤ node.data ≤ 105
 */

class Node {

    // int data;
    Node left, right;

    Node(int val) {
        // data = val;
        left = right = null;
    }
}

class HeightOfBinaryTree {

    public static void main(String[] args) {
        HeightOfBinaryTree s = new HeightOfBinaryTree();
        // [12, 8, 18, 5, 11]
        // [1, 2, 3, 4, N, 10, 5, N, N, N, N, 6, 7]
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);

        root.right.left = new Node(10);
        root.right.right = new Node(5);

        root.right.left.left = new Node(6);
        root.right.left.right = new Node(7);

        System.out.println(s.height(root));
    }

    public int height(Node root) {
        if (root == null) {
            return -1;
        }

        int left = height(root.left);
        int right = height(root.right);

        return 1 + Math.max(left, right);
    }
}
