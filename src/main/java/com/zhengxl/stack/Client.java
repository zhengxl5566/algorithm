package com.zhengxl.stack;

/**
 * @description:
 * @projectName:algorithm
 * @see:com.zhengxl.stack
 * @author:郑晓龙
 * @createTime:2020/9/7 15:07
 * @version:1.0
 */
public class Client {
    public static void main(String[] args) {
        MyStack myStack = new MyStack(100);
        myStack.push(1);
        myStack.push(55);
        System.out.println(myStack.pop());
    }
}
