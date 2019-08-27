package com.example.fastjson;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @create 2019-07-25 8:55
 */
public class Reflection {


    public static void main(String[] args) throws IllegalAccessException {

        Entity t = new Entity();
        t.setCode(1);
        t.setName("11");
        Class testClazz = t.getClass();
        Field[] fields = testClazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
            field.setAccessible(true);
            System.out.println(field.get(t));
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 前序遍历： {1,2,4,7,3,5,6,8}
     * 中序遍历： {4,7,2,1,5,3,8,6}
     */
    public class Solution {
        public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
            return add(pre, 0, pre.length - 1, in, 0, in.length - 1);
        }
        private TreeNode add(int[] pre, int preLeft, int preRight, int[] in, int inLeft, int inRight) {
            if (preLeft > preRight || inLeft > inRight) {
                return null;
            }
            TreeNode root = new TreeNode(pre[preLeft]);
            for (int i = inLeft; i <= inRight; i++) {
                if (pre[preLeft] == in[i]) {
                    // 先前面的把前序遍历的头节点左边的放进去，再把中序遍历头结点左边的放进去
                    root.left = add(pre, preLeft + 1, preLeft + i - inLeft, in, inLeft, i - 1);
                    root.right = add(pre, preLeft + i + 1 - inLeft, preRight, in, i + 1, inRight);
                }
            }
            return root;
        }
    }
}
