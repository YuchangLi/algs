package com.liyc.algs.datastructure.tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 树遍历
 */
public class TreeTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        root.left = two;
        root.right = three;

        Node four = new Node(4);
        Node five = new Node(5);
        two.left = four;
        two.right = five;

        Node six = new Node(6);
        Node seven = new Node(7);
        three.left = six;
        three.right = seven;

        Node eight = new Node(8);
        four.left = eight;

//        inorderTraversal(root);

//        levelTraversalUseRecursion(root);
        levelTraversalUseIteration(root);
    }

    /**
     * 层序遍历-迭代
     *
     * @param root
     */
    private static void levelTraversalUseIteration(Node root) {
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data+" ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    /**
     * 层序遍历时存放元素
     */
    private static Queue<Node> queue = new LinkedBlockingQueue<>();

    /**
     * 层序遍历（递归方式）
     *
     * @param root
     */
    private static void levelTraversalUseRecursion(Node root) {
        if (root == null) {
            return;
        }
        queue.add(root);
        levelTraversal();
    }

    private static void levelTraversal() {
        if (queue.isEmpty()) {
            return;
        }
        Node root = queue.poll();
        System.out.print(root.data + " ");
        if (root.left != null) {
            queue.add(root.left);
        }
        if (root.right != null) {
            queue.add(root.right);
        }
        levelTraversal();
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    private static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorderTraversal(root.left);
        }
        System.out.print(root.data + " ");
        if (root.right != null) {
            inorderTraversal(root.right);
        }
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}
