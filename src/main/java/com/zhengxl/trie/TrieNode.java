package com.zhengxl.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @projectName:algorithm
 * @see:com.zhengxl.trie
 * @author:郑晓龙
 * @createTime:2020/5/6 10:31
 * @version:1.0
 */
public class TrieNode {
    public boolean isEndingChar;
    public Map<Character, TrieNode> children;

    public TrieNode(char data) {
        Map<Character, TrieNode> newNode = new HashMap<>();
        newNode.put(data,new TrieNode());
        this.children = newNode;
        this.isEndingChar = false;
    }

    public TrieNode() {
        this.children = new HashMap<>();
        this.isEndingChar = false;
    }
}
