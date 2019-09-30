package com.example.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jun
 * @version 1.0.0
 * @date 2019-09-26 14:45
 * 数组滑动窗口的最大值
 * {2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}
 */
public class Demo16 {

    @Test
    public void test() {
        int[] arr = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(realize(arr, 3));
    }

    private List<Integer> realize(int[] arr, int size) {
        List<Integer> list = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            // 每次将队列中最后一个储存的下标的值与当前的数组的值比较
            // 依次把当前队列小于当前值的下标移除
            // 这样每次滑动窗口，队列中最前的数就是当前窗口最大值得那个下标了
            while (!queue.isEmpty() && arr[queue.peekLast()] < arr[i]) {
                queue.pollLast();
            }
            // 因为已经将队列中比这个小的下标移除，所以直接添加
            // 之后每个窗口中最大的值就是peekFirst()
            queue.addLast(i);
            // 滑动窗口滑过了这个下标，则要将该下标移除
            if(queue.peekFirst() == i - size) {
                queue.pollFirst();
            }
            // i到达size - 1开始，每次讲队列最前面（最大）的数加入
            if (i >= size - 1) {
                list.add(arr[queue.peekFirst()]);
            }
        }
        return list;
    }
}
