package com.zhengxl.backtracking;

/**
 * @description: 0-1 背包问题
 * @projectName:algorithm
 * @see:com.zhengxl.backtracking
 * @author:郑晓龙
 * @createTime:2020/5/18 10:05
 * @version:1.0
 */
public class Knapsack {
    public int maxW = Integer.MIN_VALUE;

    public void func(int currentItem, int currentWeight, int[] items, int weight) {
        if (currentItem == items.length || currentWeight == weight) {
            if (currentWeight > maxW) {
                maxW = currentWeight;
            }
            return;
        }
        func(currentItem + 1, currentWeight, items, weight);
        if (currentWeight + items[currentItem] <= weight) {
            func(currentItem + 1, currentWeight + items[currentItem], items, weight);
        }
    }
}
