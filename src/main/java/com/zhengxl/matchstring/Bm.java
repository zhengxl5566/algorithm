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
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateGS(b, m, suffix, prefix);
        // 记录每次主串和模式串比对的起始位置
        int currentIndex = 0;
        while (currentIndex <= n - m) {
            // si代表模式串中坏字符的索引
            int si;
            // 模式串从后往前和主串匹配
            for (si = m - 1; si >= 0; si--) {
                if (a[currentIndex + si] != b[si]) {
                    // 不相等时记录坏字符索引si
                    break;
                }
            }
            // j小于0表示都遍历完了没有坏字符，存在匹配串
            // 返回主串中和模式串匹配的第一个字符的index
            if (si < 0) {
                return currentIndex;
            }
            // xi表示坏字符在模式串中的位置
            int xi = bc[a[currentIndex + si]];

            // 坏字符规则计算出的向后滑动位数
            int x = currentIndex + (si - xi);
            int y = 0;
            if (si < m - 1) {
                y = moveByGS(si,m,suffix,prefix);
            }
            currentIndex = currentIndex + Math.max(x,y);
        }

        // 未查到模式串，返回-1
        return -1;
    }

    private int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
        // 好后缀长度
        int k = m - 1 - j;
        if (suffix[k] != -1) {
            return j - suffix[k] + 1;
        }
        for (int r = j + 2; r <= m - 1; ++r) {
            if (prefix[m - r] == true) {
                return r;
            }
        }
        return m;
    }

    private void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
        // 初始化数组
        for (int i = 0; i < m; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }
        for (int i = 0; i < m - 1; i++) {
            int j = i;
            // 公共后缀子串长度
            int k = 0;
            while (j >= 0 && b[j] == b[m - 1 - k]) {
                j--;
                k++;
                suffix[k] = j + 1;
            }
            if (j == -1) {
                prefix[k] = true;
            }
        }
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
