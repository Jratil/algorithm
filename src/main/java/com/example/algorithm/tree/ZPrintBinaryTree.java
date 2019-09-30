package com.example.algorithm.tree;

import org.junit.Test;

import java.util.*;

/**
 * @author jun
 * @version 1.0.0
 * @date 2019-09-26 9:29
 */
public class ZPrintBinaryTree {

    @Test
    public void zPrintTree() {
        TreeNode root = TreeNode.getTree();
        zPrint(root);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.println(list.get(i).get(j));
            }
        }
    }

    private List<List<Integer>> list = new ArrayList<>();

    private void zPrint(TreeNode root) {
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            if (level == list.size()) {
                list.add(new ArrayList<>());
            }

            for (int i = queue.size() - 1; i >= 0; i--) {
                TreeNode node = queue.remove(i);
                list.get(level).add(node.val);
                if (level % 2 != 0) {
                    if(node.right != null) queue.add(node.right);
                    if(node.left != null) queue.add(node.left);
                } else {
                    if(node.left != null) queue.add(node.left);
                    if(node.right != null) queue.add(node.right);
                }
            }
            level++;
        }
    }
}
