package com.example.algorithm;

import org.junit.Test;

/**
 * @author wenjj2@meicloud.com
 * @version 1.0.0
 * @date 2019-09-19 8:55
 *
 * N皇后问题
 */
public class N_Queens {

    int count = 0;

    @Test
    public void test() {
        int N = 8;
        // 放置每行的棋子所在位置
        int[] line = new int[N];
        int[][] line2 = new int[N][N];
        for (int i = 0; i < N; i++) {
            line[i] = -1;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                line2[i][j] = 0;
            }
        }
//        place(line, N, 0, 0);
        place2(line2, N, 0);
        System.out.println(count);
    }

    private void place2(int[][] line, int N, int x) {
        // 递归结束条件
        if (x == N) {
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (check(line, x, i)) {
                line[x][i] = 1;
                place2(line, N, x + 1);
                line[x][i] = 0;
            }
        }
    }

    private void place(int[] line, int N, int x, int y) {
        // 结束条件
        if (x == N || x < 0 || y == N) {
            if (x == N) {
                count++;
                print(line);
                // y超出列，则从上一行的下一列开始放
                place(line, N, x - 1, line[x - 1] + 1);
            } else if (x > 0 && y + 1 >= N) {
                place(line, N, x - 1, line[x - 1] + 1);
            }
            return;
        }
        if (valid(line, x, y)) {
            // 验证通过，从下一行的第一列开始放
            line[x] = y;
            place(line, N, x + 1, 0);
        } else {
            // 验证不通过，从下一列开始放
            place(line, N, x, y + 1);
        }
    }

    private boolean valid(int[] line, int x, int y) {
        for (int i = 0; i < x; i++) {
            if (Math.abs(i - x) == Math.abs(line[i] - y)
                    || line[i] == y) {
//                System.out.println("摆放在：(" + x + "," + y + ")");
//                System.out.println("第" + i + "次比较的是：(" + i + "," + line[i] + ")");
//                System.out.println("失败---------\n");
                return false;
            }
        }
//        System.out.println("成功------摆放在：(" + x + "," + y + ")\n");
        return true;
    }

    private boolean check(int[][] line, int x, int y) {
        for (int i = 0; i < x; i++) {
            if (line[i][y] == 1) {
                return false;
            }
            for (int j = 0; j < line[0].length; j++) {
                if(line[i][j] == 1 && Math.abs(y - j) == Math.abs(x - i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void print(int[] line) {
        for (int i = 0; i < line.length; i++) {
            System.out.println("所放的位置：(" + i + "," + line[i] + ")");
        }
    }
}
