package com.example.algorithm;

import org.junit.Test;

/**
 * @author jun
 * @version 1.0.0
 * @date 2019-09-29 11:39
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 */
public class Demo18 {

    @Test
    public void test() {
        movingCount(5, 10, 10);
    }

    public void movingCount(int threshold, int rows, int cols) {
        boolean[][] flag = new boolean[rows][cols];
        solution(threshold, rows, cols, flag, 0, 0);
        System.out.println(count);
    }

    int count = 0;

    public void solution(int max, int rows, int cols, boolean[][] flag, int row, int col) {
        int sRow = 0;
        int r = row;
        while (r > 0) {
            sRow += r % 10;
            r = r / 10;
        }
        int sCol = 0;
        int c = col;
        while (c > 0) {
            sCol += c % 10;
            c = c / 10;
        }
        if (row >= rows || col >= cols || flag[row][col] || sRow + sCol > max) {
            return;
        }
        count++;
        flag[row][col] = true;
        solution(max, rows, cols, flag, row + 1, col);
        solution(max, rows, cols, flag, row, col + 1);
    }
}
