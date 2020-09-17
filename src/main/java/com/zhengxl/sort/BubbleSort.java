package com.zhengxl.sort;

/**
 * @description:
 * @projectName:algorithm
 * @see:com.zhengxl.sort
 * @author:郑晓龙
 * @createTime:2020/9/9 10:35
 * @version:1.0
 */
public class BubbleSort implements Sort {

    /**
     * @param array
     * @return int[]
     * @description 冒泡排序算法实现
     * @author 郑晓龙
     * @createTime 2020/9/9 11:46
     **/
    @Override
    public void sortDesc(int[] array) {
        if (array == null) {
            return;
        }
        int size = array.length;
        if (size <= 1) {
            return;
        }
        for (int i = 0; i < size; i++) {
            // 是否发生了数据交换的标志位
            boolean hasSwitched = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    hasSwitched = true;
                }
            }
            // 本轮未发生数据交换说明已经全部有序，不需要在比较了
            if (!hasSwitched) {
                break;
            }
        }
        return;
    }
}
