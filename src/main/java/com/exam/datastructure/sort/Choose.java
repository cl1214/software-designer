package com.exam.datastructure.sort;

/**
 * @description 选择排序
 * @author chenlin
 * @date 2023/2/8 17:46
 */
public class Choose implements Sort {

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int k = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[k]) {
                    k = j;
                }
            }
            if (k != i) {
                int tem = arr[i];
                arr[i] = arr[k];
                arr[k] = tem;
            }
        }
    }

    public static void main(String[] args) {
        Choose choose = new Choose();
        Detector.check(choose);
        int i = 1;
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(arr[i]);
        System.out.println(arr[++i]);
    }
}
