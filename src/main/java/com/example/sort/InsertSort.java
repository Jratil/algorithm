package com.example.sort;

/**
 * @create 2019-07-24 11:25
 */
public class InsertSort extends PrintResult{

    public static void main(String[] args) {
        new InsertSort().print();
    }

    /**
     * 第一个循环从第一个数到最后一个数
     * 第二个循环从i + 1开始，慢慢递减，将每次排序完的数与前面排好序的每个数做比较
     * 第二个循环，每次循环完相当于将前面的数排序完了
     * O(n^2)
     *
     * @param a
     */
    @Override
    public void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
    }
}
