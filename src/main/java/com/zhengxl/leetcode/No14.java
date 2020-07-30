package com.zhengxl.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * @description:
 * @projectName:algorithm
 * @see:com.zhengxl.leetcode
 * @author:郑晓龙
 * @createTime:2020/7/30 20:02
 * @version:1.0
 */
public class No14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;

        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);

            for (int j = 1; j < count; j++) {
                if (i >= strs[j].length() ||c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        No14 no14 = new No14();
        String[] strs = {"abc","abcd","ab"};
        System.out.println(no14.longestCommonPrefix(strs));
    }
}
