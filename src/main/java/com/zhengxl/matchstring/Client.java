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
        char[] a = {'c','a','b','c','a','b'};
        char[] b = {'b','c','a'};
        int[] suffix = new int[b.length];
        boolean[] prefix = new boolean[b.length];

        System.out.println(bm.bm(a,a.length,b,b.length));
    }
}
