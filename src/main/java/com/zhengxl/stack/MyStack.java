package com.zhengxl.stack;

/**
 * @description:
 * @projectName:algorithm
 * @see:com.zhengxl.stack
 * @author:郑晓龙
 * @createTime:2020/9/7 14:57
 * @version:1.0
 */
public class MyStack {

    private int[] items;
    private int count;
    private int stackSize;

    public MyStack(int size) {
        this.items = new int[size];
        this.count = 0;
        this.stackSize = size;
    }

    public boolean push(int value) {
        if(count == stackSize){
            return false;
        }
        items[count] = value;
        count++;
        return true;
    }

    public Integer pop() {
        if(count == 0){
            return null;
        }
        return items[--count];
    }
}
