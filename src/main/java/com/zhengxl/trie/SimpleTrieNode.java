package com.zhengxl.trie;

/**
 * @description:
 * @projectName:algorithm
 * @see:com.zhengxl.trie
 * @author:郑晓龙
 * @createTime:2020/5/6 8:57
 * @version:1.0
 */
public class SimpleTrieNode {
    public boolean isEndingChar;
    public char data;
    public SimpleTrieNode[] children = new SimpleTrieNode[26];

    public SimpleTrieNode(char data) {
        this.data = data;
    }
}
