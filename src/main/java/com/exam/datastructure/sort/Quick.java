package com.exam.datastructure.sort;
/**
 * @description 快速排序
 * @author chenlin
 * @date 2023/2/9 16:22
 */
public class Quick implements Sort {

    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        if (i >= j) {
            return;
        }
        int index = arr[i];
        while (i < j) {
            while (i < j && arr[j] >= index) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
            }
            while(i < j && arr[i] <= index) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
            }
        }
        arr[i] = index;
        sort(arr, low, i - 1);
        sort(arr, i + 1, high);
    }

    public static void main(String[] args) {
        Quick quick = new Quick();
        Detector.check(quick);
        int[] arr = {4, 0, 7, 4, 1, 2, 8, 9, 0, 9};
        quick.sort(arr);
        Detector.print(arr);
    }
}
