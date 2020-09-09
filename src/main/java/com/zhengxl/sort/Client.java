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
        int[] array = {1,5,4,3,2};
        Sort sort = new SelectSort();
        int[] sortResult = sort.sortDesc(array);

        for (int i = 0; i < sortResult.length; i++) {
            System.out.println(sortResult[i]);
        }
    }
}
