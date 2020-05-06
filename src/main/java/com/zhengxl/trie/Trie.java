package com.zhengxl.trie;

/**
 * @description:
 * @projectName:algorithm
 * @see:com.zhengxl.trie
 * @author:郑晓龙
 * @createTime:2020/5/6 10:31
 * @version:1.0
 */
public class Trie {
    public TrieNode root = new TrieNode('/');
    public void insert(String keyWord){
        TrieNode current = root;
        for (int i = 0; i < keyWord.length(); i++) {
            char c = keyWord.charAt(i);
            if(!current.children.containsKey(c)){
                current.children.put(c,new TrieNode());
            }
            current = current.children.get(c);
        }
        current.isEndingChar = true;
    }
    public boolean find(String keyWord){
        TrieNode current = root;
        for (int i = 0; i < keyWord.length(); i++) {
            if(!current.children.containsKey(keyWord.charAt(i))){
                return false;
            }
            current = current.children.get(keyWord.charAt(i));
        }
        return current.isEndingChar;
    }
}
