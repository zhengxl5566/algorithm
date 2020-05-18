package com.zhengxl.backtracking;

/**
 * @description:
 * @projectName:algorithm
 * @see:com.zhengxl.backtracking
 * @author:郑晓龙
 * @createTime:2020/5/11 11:34
 * @version:1.0
 */
public class Client {
    public static void main(String[] args) {
//        new EightQueen();
        Knapsack knapsack = new Knapsack();
        int[] items = {1,5,3,9,4,6,7,8};
        knapsack.func(0,0,items,20);
        System.out.println(knapsack.maxW);
    }
}
