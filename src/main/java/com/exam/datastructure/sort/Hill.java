package com.exam.datastructure.sort;

/**
 * @description 希尔排序
 * @author chenlin
 * @date 2023/2/9 10:16
 */
public class Hill implements Sort {

    public static void main(String[] args) {
        Hill hill = new Hill();
        Detector.check(hill);
    }

    @Override
    public void sort(int[] arr) {
        int length = arr.length;
        int gap = length / 2;
        for (; gap > 0; gap = gap / 2) {
            for (int j = gap; j < length; j++) {
                int tem = arr[j];
                int i = j - gap;
                for (; i >= 0 && arr[i] > tem; i -= gap) {
                    arr[i + gap] = arr[i];
                }
                arr[i + gap] = tem;
            }
        }
    }
}
