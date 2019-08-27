package com.example.sort;

/**
 * @create 2019-07-24 11:42
 */
public class MaopaoSort extends PrintResult {

    public static void main(String[] args) {
        new MaopaoSort().print();
    }


    /**
     * 冒泡排序
     * 每次将后面最小的数放到最前面来
     * 第一次循环的i就是每次所放的后面最小的数的位置
     * 第二个循环每次都找到最小的数，然后与i位置的数交换，如果后面还有更小的数，就再交换放到i位置来
     * O(n^2)
     *
     * @param a
     */
    @Override
    public void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
    }
}
