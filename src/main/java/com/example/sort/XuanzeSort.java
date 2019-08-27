package com.example.sort;

/**
 * @create 2019-07-24 11:58
 */
public class XuanzeSort extends PrintResult{
    public static void main(String[] args) {
        new XuanzeSort().print();
    }

    /**
     * 选择排序
     * 最开始先假定第一个下标的数是最小的，然后从i + 1开始，判断依次判断后面的数是否有比这个小的
     * 如果有，则记录最小的下标
     * 全部循环完成后将那个数和i位置的数交换
     * 好像和冒泡排序差不多，冒泡排序是每次发小最小的就交换，
     * 而选择排序是每次只记录下最小的下标，到第二层循环结束才交换一次
     * O(n^2)
     *
     * @param a
     */
    @Override
    public void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = a[minIndex];
                a[minIndex] = a[i];
                a[i] = temp;
            }
        }
    }
}
