package com.exam.datastructure.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @description 算法校验器
 * @author chenlin
 * @date 2023/2/8 16:16
 */
public class Detector {

    public static boolean check(Sort sort) {
        // 用于生成随机数
        Random random = new Random();
        // 样本容量
        int sampleSize = 10;
        // 校验的次数
        int frequency = 100;
        for (int i = 0; i < frequency; i++) {
            int[] arr1 = new int[sampleSize];
            int[] arr2 = new int[sampleSize];
            int[] arr3 = new int[sampleSize];
            // 生成随机数数组
            for (int j = 0; j < sampleSize; j++) {
                arr1[j] = random.nextInt(sampleSize);
            }
            // 将数组复制一份，一份使用Java自带的Arrays.sort排序，一份使用我们的算法排序
            System.arraycopy(arr1, 0, arr2, 0, arr1.length);
            System.arraycopy(arr1, 0, arr3, 0, arr1.length);
            Arrays.sort(arr1);
            //这里让你的类继承BaseSort，然后重写sort方法，就是调用你的排序算法啦
            sort.sort(arr2);
            for (int k = 0; k < arr1.length; k++) {
                if(arr1[k] != arr2[k]) {
                    //如果排序的结果出现不一致，表示算法错误
                    System.out.println("校验失败");
                    return false;
                }
            }
        }
        // 通过校验，算法正确
        System.out.println("校验通过");
        return true;
    }

    public static void print(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length -1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ",");
            }
        }
        System.out.println("]");
    }

}
