package com.zhengxl.sort;

import java.util.stream.Stream;

/**
 * @description:
 * @projectName:algorithm
 * @see:com.zhengxl.sort
 * @author:郑晓龙
 * @createTime:2020/9/9 10:45
 * @version:1.0
 */
public class Client {
    public static void main(String[] args) {
        int[] array = {};
        BubbleSort bubbleSort = new BubbleSort();
        int[] sort = bubbleSort.sort(array);
        for (int i = 0; i < sort.length; i++) {
            System.out.println(sort[i]);
        }
    }
}
