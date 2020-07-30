package com.zhengxl.trie;

/**
 * @description:
 * @projectName:algorithm
 * @see:com.zhengxl.trie
 * @author:郑晓龙
 * @createTime:2020/5/27 14:21
 * @version:1.0
 */
public class SimpleAcNode {
    public char data;
    public SimpleAcNode[] children = new SimpleAcNode[26];
    public boolean isEndingChar =false;
    public int length = -1;
    public SimpleAcNode(char data){
        this.data = data;
    }
}
