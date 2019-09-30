package com.example.test;

import org.junit.Test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author jun
 * @version 1.0.0
 * @date 2019-09-29 14:32
 */
public class TestDemo {

    @Test
    public void run() {
        Insert(1);
        System.out.println(GetMedian());
        Insert(4);
        System.out.println(GetMedian());
        Insert(8);
        System.out.println(GetMedian());
        Insert(2);
        System.out.println(GetMedian());
        Insert(3);
        System.out.println(GetMedian());
    }

    int count = 0;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, Comparator.reverseOrder());

    /**
     * 插入为奇数则插在小顶堆，偶数插入大顶堆
     * 当插入的大顶堆的数比大顶堆最大的大，则插在小顶堆
     * 当插入小顶堆的数比小顶堆最小的数小，则插入大顶堆
     * 维持小顶堆最小元素大于大顶堆最大元素
     * 维持小顶堆和大顶堆元素个数一样
     * 这样当为偶数就是连个堆顶元素之和的一半
     * 奇数的时候就是最大堆堆顶元素
     * @param num
     */
    public void Insert(Integer num) {
        count++;
        if ((count & 1) == 0) {
            if (!maxHeap.isEmpty() && maxHeap.peek() > num) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        } else {
            if (!minHeap.isEmpty() && minHeap.peek() < num) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }

    public Double GetMedian() {
        if (count == 0) {
            return (double) 0;
        }
        if ((count & 1) == 1) {
            return (double) maxHeap.peek();
        } else {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        }
    }
}
