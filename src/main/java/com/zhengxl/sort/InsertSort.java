package com.zhengxl.sort;

/**
 * @description:
 * @projectName:algorithm
 * @see:com.zhengxl.sort
 * @author:郑晓龙
 * @createTime:2020/9/9 10:35
 * @version:1.0
 */
public class InsertSort implements Sort{

    @Override
    public int[] sortDesc(int[] array) {
        if (array == null) {
            return null;
        }
        int size = array.length;
        if (size <= 1) {
            return array;
        }
        for (int i = 1; i < size; i++) {
            int value = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > value) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = value;
        }
        return array;
    }
}
