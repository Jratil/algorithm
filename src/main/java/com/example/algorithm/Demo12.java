package com.example.algorithm;


import org.junit.Test;

import java.util.*;

/**
 * @author wenjj2@meicloud.com
 * @version 1.0.0
 * @date 2019-09-19 17:30
 * 获取树的最大深度
 */
public class Demo12 {

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    private List<Integer> list = new ArrayList<>();

    @Test
    public void main(String[] args) {
        find(new TreeNode(1), 1);
        List<Integer> list = new LinkedList<>();

        System.out.println(Collections.max(list));
    }

    private void find(TreeNode root, int deep) {
        if (root.left == null && root.right == null) {
            list.add(deep);
            return;
        }
        if(root.left != null) {
            find(root.left, deep + 1);
        }
        if(root.right != null) {
            find(root.right, deep + 1);
        }
    }
}
