package com.example.study;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author wen
 * @date 2019-08-19 16:54
 */
public class Demo3 {

    private int[] arr = new int[]{8, 6, 3, 31, 2, 9, 2};
    
    @Test
    public void insert() {
        for (int i = 1 ; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void select() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void sort() {
        merge(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void merge(int[] a, int start, int end) {
        if(start == end) return;
        int mid = start + (end - start) / 2;
        merge(a, start, mid);
        merge(a, mid + 1, end);

        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        for (int l = 0; l < temp.length; l++) {
            if(i <= mid  && j <= end) {
                if (a[i] < a[j]) {
                    temp[l] = a[i++];
                } else {
                    temp[l] = a[j++];
                }
            } else if(i == mid + 1) {
                temp[l] = a[j++];
            } else if(j == end + 1) {
                temp[l] = a[i++];
            }
        }
        for (int k = 0; k < temp.length; k++) {
            a[k + start] = temp[k];
        }
    }

    @Test
    public void quickSort() {
        quick(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void quick(int[] a, int start, int end) {
        HashSet<String> set = new HashSet<>();

        if(start >= end) {return;}
        int i = start, j = end;
        while (i < j) {
            if(a[i] > a[j]) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            } else {
                j--;
            }
        }
        quick(a, start, i);
        quick(a, i + 1, end);
    }

    class Node {
        Node next;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }

    @Test
    public void reverseList() {
        Node node1 = new Node(0);
        Node node2 = new Node(1);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Node head = node1;
        Node p = head.next;
        Node q = p;
        Node f = head;
        f.next = null;
        while (q != null) {
            q = p.next;
            if (q == null) {
                p.next = f;
            } else {
                p.next = f;
            }
            f = p;
            p = q;
        }
        while (f != null) {
            System.out.println(f.val);
            f = f.next;
        }
    }
}
