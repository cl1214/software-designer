package com.exam.datastructure.sort;

/**
 * @description 堆排序
 * @author chenlin
 * @date 2023/2/10 16:56
 */
public class Heap implements Sort {

    @Override
    public void sort(int[] arr) {
        // 构建大根堆
        build(arr);
        swap(arr, 0, arr.length - 1);
        for (int i = arr.length - 2; i >= 0; i--) {
            heap(arr, 0, i);
            swap(arr, 0, i);
        }
    }

    public void build(int[] arr) {
        int length = arr.length;
        for (int i = (length >> 1) - 1; i >= 0; i--) {
            heap(arr, i, length - 1);
        }
    }

    public void heap(int[] arr, int start, int end) {
        int index = arr[start];
        int left = 2 * start + 1;
        int right = left + 1;
        int max = left;
        if (left > end) {
            return;
        }
        if (right <= end && arr[left] < arr[right]) {
            max = right;
        }
        if (index > arr[max]) {
            return;
        }
        swap(arr, start, max);
        heap(arr, max, end);
    }

    public void swap(int[] arr, int a, int b) {
        int tem = arr[a];
        arr[a] = arr[b];
        arr[b] = tem;
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 3, 5, 9};
        Heap heap = new Heap();
        heap.sort(arr);
        Detector.check(heap);
    }
}
