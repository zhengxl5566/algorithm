package com.zhengxl.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * 给你一个目标数组 target 和一个整数 n。每次迭代，需要从  list = {1,2,3..., n} 中依序读取一个数字。
 *
 * 请使用下述操作来构建目标数组 target ：
 *
 * Push：从 list 中读取一个新元素， 并将其推入数组中。
 * Pop：删除数组中的最后一个元素。
 * 如果目标数组构建完成，就停止读取更多元素。
 * 题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
 *
 * 请返回构建目标数组所用的操作序列。
 *
 * 题目数据保证答案是唯一的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/build-an-array-with-stack-operations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
