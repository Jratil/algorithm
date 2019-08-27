package com.example.sort;

/**
 * @create 2019-07-24 14:06
 */
public class QuickSort extends PrintResult{

    public static void main(String[] args) {
        new QuickSort().print();
    }

    @Override
    public void sort(int[] a) {
        sort(a, 0, 7);
    }

    /**
     * @see com.example.study.Demo3
     *
     * 快速排序
     * 原理：不知道
     * 思路：将数组第一个数作为最原始比较，两个指针指向头尾
     * 先从最尾部指针判断是否比这个key小，找到比这个小的，填到key所在下标处
     * 然后i++，再依次判断i比key大的数，填到刚刚的j处
     * 这样第一次后就是比key小的都在key坐标，比key大的都在key右边，而key就相当于已经排好序了
     * 再利用递归，把key左右两边的数全再这样做
     * O(n*lgn)
     *
     * @param a
     * @param l
     * @param r
     */
    public void sort(int[] a, int l, int r) {
        if(l > r) {return;}
        int i = l, j = r, key = a[l];

        while (i < j) {
            while (i < j && a[j] >= key) {
                j--;
            }
            if(i < j) {
                a[i] = a[j];
                i++;
            }
            while (i < j && a[i] < key) {
                i ++;
            }
            if(i < j) {
                a[j] = a[i];
                j--;
            }
        }
        a[i] = key;
        sort(a, l, i - 1);
        sort(a, i + 1, r);
    }
}
