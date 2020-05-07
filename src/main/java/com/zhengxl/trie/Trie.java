package com.zhengxl.trie;

/**
 * @description:Trie树
 * @projectName:algorithm
 * @see:com.zhengxl.trie
 * @author:郑晓龙
 * @createTime:2020/5/6 10:31
 * @version:1.0
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode('/');
    }

    public void insert(String keyWord){
        TrieNode current = root;
        char[] chars = keyWord.toCharArray();
        for (char c : chars) {
            // 不包含该字符就构造一个节点并插入
            if(!current.children.containsKey(c)){
                current.children.put(c,new TrieNode());
            }
            // 包含该字符就继续往下遍历
            current = current.children.get(c);
        }
        // 插入完成之后将该词的最后一个字符设置为结束节点
        current.setEndingChar(true);
    }

    public boolean find(String keyWord){
        TrieNode current = root;
        char[] chars = keyWord.toCharArray();
        for (char c : chars) {
            // 不包含该字符直接结束，返回false
            if(!current.children.containsKey(c)){
                return false;
            }
            // 包含该字符就继续往下遍历
            current = current.children.get(c);
        }
        // 全词匹配，是结束节点才返回true
        return current.isEndingChar();
    }
}
