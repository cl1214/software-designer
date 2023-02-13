package com.exam.datastructure.sort;

/**
 * @description 直接插入排序
 * @author chenlin
 * @date 2023/2/8 14:59
 */
public class InsertDirect implements Sort{

    public static void main(String[] args) {
        Sort sort = new InsertDirect();
        int[] arr = {2,3,7,8,8,9,5,3,3,0};
        //sort.sort(arr);
        Detector.check(sort);
    }

    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 当前位置数据与前一个位置数据比较，大于前一个位置数据时直接进行下一轮比较
            if (arr[i] > arr[i -1]) {
                continue;
            }
            int tem = arr[i];
            int j = i - 1;
            for (; j >= 0 && arr[j] > tem; j--) {
                // 遍历有序序列，与有序序列每个位置数据比较，小于的时候有序序列数据后移动一个位置
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = tem;
        }
        Detector.print(arr);
    }

}
