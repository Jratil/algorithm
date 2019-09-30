package com.example.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jun
 * @version 1.0.0
 * @date 2019-09-26 16:14
 * 用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子
 */
public class Demo17 {

    @Test
    public void test() {
        System.out.println(hasPath("ABCESFCSADEE".toCharArray(), 3, 4, "ABCCED".toCharArray()));
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] flag = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (solution(matrix, rows, cols, i, j, str, flag, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean solution(char[] ch, int rows, int cols, int row, int col, char[] str, boolean[] flag, int k) {
        int index = row * cols + col;
        if (row < 0 || row >= rows || col < 0 || col >= cols || flag[index] || ch[index] != str[k]) {
            return false;
        }

        if (k == str.length - 1) {
            return true;
        }
        flag[index] = true;
        if (solution(ch, rows, cols, row, col - 1, str, flag, k + 1) ||
                solution(ch, rows, cols, row, col + 1, str, flag, k + 1) ||
                solution(ch, rows, cols, row - 1, col, str, flag, k + 1) ||
                solution(ch, rows, cols, row + 1, col, str, flag, k + 1)) {
            return true;
        }
        flag[index] = false;
        return false;
    }
}
