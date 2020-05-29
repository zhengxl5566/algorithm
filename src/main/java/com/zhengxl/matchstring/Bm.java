package com.zhengxl.matchstring;

/**
 * @description:
 * @projectName:algorithm
 * @see:com.zhengxl.matchstring
 * @author:郑晓龙
 * @createTime:2020/5/29 9:38
 * @version:1.0
 */
public class Bm {
    private static final int SIZE = 256;

    public int bm(char[] a, int n, char[] b, int m) {
        int[] bc = new int[SIZE];
        generateBC(b, m, bc);
        // 记录每次主串和模式串比对的起始位置
        int i = 0;
        while (i <= n - m) {
            // j代表坏字符的index
            int j;
            // 模式串从后往前和主串匹配
            for (j = m - 1; j >= 0; j--) {
                if (a[i + j] != b[j]) {
                    // 不相等时记录坏字符index
                    break;
                }
            }
            // j小于0表示都遍历完了没有坏字符，存在匹配串
            // 返回主串中和模式串匹配的第一个字符的index
            if (j < 0) {
                return i;
            }
            // 坏字符在模式串中的位置
            int xi = bc[a[i + j]];
            // 向后滑动
            i = i + (j - xi);

        }
        return -1;
    }

    private void generateBC(char[] b, int m, int[] bc) {
        for (int i = 0; i < SIZE; i++) {
            bc[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            int ascii = b[i];
            bc[ascii] = i;
        }

    }

}
