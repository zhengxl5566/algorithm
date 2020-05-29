package com.zhengxl.matchstring;

/**
 * @description:
 * @projectName:algorithm
 * @see:com.zhengxl.matchstring
 * @author:郑晓龙
 * @createTime:2020/5/29 16:41
 * @version:1.0
 */
public class Client {
    public static void main(String[] args) {
        Bm bm = new Bm();
        char[] a = {'a','b','a','c','d'};
        char[] b = {'a','c','d'};
        System.out.println(bm.bm(a,5,b,3));
    }
}
