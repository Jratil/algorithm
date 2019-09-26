package com.example.algorithm.tree;

/**
 * @author wen
 * @version 1.0.0
 * @date 2019-09-25 15:44
 */
public class TreeNode {
    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode (int val) {
        this.val = val;
    }

    /**         1
     *        /  \
     *       2    3
     *     /  \    \
     *    4    5    6
     *  /       \
     * 7         8
     * 下面构造的二叉树
     */
    public static TreeNode getTree() {
        TreeNode node1 = new TreeNode(1);
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
        node5.right = node8;

        //TreeNode node = deserialize("1-2-4-7-#-8-#-#-#-5-#-#-3-#-6-#-#-");
        return node1;
    }
}
