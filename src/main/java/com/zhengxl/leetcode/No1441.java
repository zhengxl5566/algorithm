package com.zhengxl.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @projectName:algorithm
 * @see:com.zhengxl.leetcode
 * @author:郑晓龙
 * @createTime:2020/5/19 14:01
 * @version:1.0
 */
public class No1441 {
    private static final String PUSH = "push";
    private static final String POP = "pop";

    public List<String> buildArray(int[] target, int n) {
        List<String> resList = new ArrayList<>();
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (i > target[target.length - 1]) {
                return resList;
            }
            if (i == target[index]) {
                resList.add(PUSH);
                index++;
            } else {
                resList.add(PUSH);
                resList.add(POP);
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        No1441 no1441 = new No1441();
        int[] target = {1, 3};
        System.out.println(no1441.buildArray(target, 3));
    }
}
