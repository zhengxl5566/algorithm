package com.zhengxl.trie;

/**
 * @description: 使用数组实现，只支持英文字母的Trie树
 * @projectName:algorithm
 * @see:com.zhengxl.trie
 * @author:郑晓龙
 * @createTime:2020/5/6 8:58
 * @version:1.0
 */
public class SimpleTrie {
    private SimpleTrieNode root;

    public SimpleTrie() {
        this.root = new SimpleTrieNode('/');;
    }

    public static class SimpleTrieNode {
        public boolean isEndingChar;
        public char data;
        public SimpleTrieNode[] children = new SimpleTrieNode[26];

        public SimpleTrieNode(char data) {
            this.data = data;
        }
    }

    public void insert(char[] text) {
        SimpleTrieNode p = root;
        for (int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                p.children[index] = new SimpleTrieNode(text[i]);
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    public boolean find(char[] text) {
        SimpleTrieNode p = root;
        for (int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        return p.isEndingChar;
    }
}
