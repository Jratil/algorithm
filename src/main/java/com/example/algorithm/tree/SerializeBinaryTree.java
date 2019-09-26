package com.example.algorithm.tree;

import com.example.algorithm.tree.TreeNode;

/**
 * @author wen
 * @version 1.0.0
 * @date 2019-09-25 15:43
 * 序列化和反序列化二叉树
 */
public class SerializeBinaryTree {

    public static void main(String[] args) {
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
//        System.out.println(serialize(node1));

        //          1
        //        /  \
        //       2    3
        //     /  \    \
        //    4    5    6
        //  /       \
        // 7         8
        // 下面构造的二叉树
        TreeNode node = deserialize("1-2-4-7-#-8-#-#-#-5-#-#-3-#-6-#-#-");
        beforeFind(node);
    }

    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private static void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#").append("-");
            return;
        }
        sb.append(node.val).append("-");
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    public static TreeNode deserialize(String str) {
        return deserialize(str.split("-"));
    }

    private static int index = -1;
    private static TreeNode deserialize(String[] str) {
        index++;
        if (!str[index].equals("#")) {
            int val = Integer.valueOf(str[index]);
            TreeNode node = new TreeNode(val);
            node.left = deserialize(str);
            node.right = deserialize(str);
            return node;
        }
        return null;
    }

    // 前序遍历
    private static void beforeFind(TreeNode node) {
        if(node == null) {
            return;
        }

        System.out.println(node.val);
        beforeFind(node.left);
        beforeFind(node.right);
    }
}
