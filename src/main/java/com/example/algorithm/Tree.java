package com.example.algorithm;

import org.junit.Before;
import org.junit.Test;

/**
 * @author wen
 * @date 2019-08-20 9:58
 */
public class Tree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode node1 = new TreeNode(1);

    @Before
    public void before() {
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node4.left = node7;
        node7.right = node8;
    }

    @Test
    public void pre() {
        startPre(node1);
    }

    public void startPre(TreeNode node) {
        if(node == null) return;
        System.out.println(node.val);
        startPre(node.left);
        startPre(node.right);
    }

    @Test
    public void mid() {
    }

    public void startMid(TreeNode node) {
        if(node == null) return;
    }

    @Test
    public void rear() {
        startRear(node1);
    }
    public void startRear(TreeNode node) {
        if(node == null) return;
        startRear(node.left);
        startRear(node.right);
        System.out.println(node.val);
    }
}
