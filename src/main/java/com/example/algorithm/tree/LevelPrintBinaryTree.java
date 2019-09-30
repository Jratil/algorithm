package com.example.algorithm.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wen
 * @version 1.0.0
 * @date 2019-09-26 8:45
 */
public class LevelPrintBinaryTree {

    private List<List<Integer>> list = new ArrayList<>();

    @Test
    public void levelPrintTest() {
        TreeNode root = TreeNode.getTree();
        // 递归方式
        // dfs(root, 0);
        // 迭代方式
        list.clear();
        iterate(root);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.println(list.get(i).get(j));
            }
        }
    }

    /**
     * dfs递归
     *
     * @param node
     * @param level
     */
    private void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (list.size() == level) {
            list.add(new ArrayList<Integer>());
        }

        list.get(level).add(node.val);
        if (node.left != null) {
            dfs(node.left, level + 1);
        }
        if (node.right != null) {
            dfs(node.right, level + 1);
        }
    }

    // 迭代方法
    private void iterate(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            if (level == list.size()) {
                list.add(new ArrayList<>());
            }

            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.remove();
                list.get(level).add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            level++;
        }
    }
}
