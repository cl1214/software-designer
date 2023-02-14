package com.exam.datastructure.sort;

/**
 * @description 冒泡排序
 * @author chenlin
 * @date 2023/2/8 17:18
 */
public class Bubble implements Sort {

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean sorted = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int tem = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tem;
                    sorted = false;
                }
            }
            // 一次冒泡未发生位置交换，则序列有序
            if (sorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Bubble bubble = new Bubble();
        Detector.check(bubble);
    }
}
