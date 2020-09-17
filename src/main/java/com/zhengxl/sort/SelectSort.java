package com.zhengxl.sort;

/**
 * @description:
 * @projectName:algorithm
 * @see:com.zhengxl.sort
 * @author:郑晓龙
 * @createTime:2020/9/9 10:35
 * @version:1.0
 */
public class SelectSort implements Sort {
    @Override
    public void sortDesc(int[] array) {
        if (array == null) {
            return;
        }
        int size = array.length;
        if (size <= 1) {
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }


        return;
    }
}
