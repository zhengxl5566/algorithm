package com.zhengxl.trie;

/**
 * @description:
 * @projectName:algorithm
 * @see:com.zhengxl.trie
 * @author:郑晓龙
 * @createTime:2020/5/6 8:57
 * @version:1.0
 */
public class TrieNode {
    public boolean isEndingChar;
    public char data;
    public TrieNode[] children = new TrieNode[26];

    public TrieNode(char data) {
        this.data = data;
    }
}
