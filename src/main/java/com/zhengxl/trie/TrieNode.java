package com.zhengxl.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:Trie树节点
 * @projectName:algorithm
 * @see:com.zhengxl.trie
 * @author:郑晓龙
 * @createTime:2020/5/6 10:31
 * @version:1.0
 */
public class TrieNode {
    private boolean endingChar;
    public Map<Character, TrieNode> children;

    public TrieNode() {
        this.children = new HashMap<>();
        this.endingChar = false;
    }

    public TrieNode(char data) {
        Map<Character, TrieNode> newNode = new HashMap<>();
        newNode.put(data,new TrieNode());
        this.children = newNode;
        this.endingChar = false;
    }

    public boolean isEndingChar() {
        return endingChar;
    }

    public void setEndingChar(boolean endingChar) {
        this.endingChar = endingChar;
    }


}
