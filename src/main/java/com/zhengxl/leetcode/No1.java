package com.zhengxl.leetcode;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * @description:
 * @projectName:algorithm
 * @see:com.zhengxl.leetcode
 * @author:郑晓龙
 * @createTime:2020/7/30 19:43
 * @version:1.0
 */
public class No1 {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length <= 0) {
            return null;
        }
        int[] res = {0,0};
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int diff = target - current;
            if(map.containsKey(diff)){
                res[0] = map.get(diff);
                res[1] = i;
                return res;
            }
            map.put(current,i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums ={2,7,11,15};
        int target = 9;
        No1 no1 = new No1();
        int[] inits = no1.twoSum(nums, target);
        if(inits!=null){
            System.out.println(inits);
        }

    }
}
