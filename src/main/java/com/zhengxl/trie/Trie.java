package com.zhengxl.trie;

import com.sun.deploy.util.StringUtils;

import java.util.*;

/**
 * @description:使用 HashMap 实现，支持任何字符的 Trie 树
 * @projectName:algorithm
 * @see:com.zhengxl.trie
 * @author:郑晓龙
 * @createTime:2020/5/6 10:31
 * @version:1.0
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public static class TrieNode {
        private boolean endingChar;
        public Map<String, TrieNode> children;

        public TrieNode() {
            this.children = new HashMap<>();
            this.endingChar = false;
        }

        public boolean isEndingChar() {
            return endingChar;
        }

        public void setEndingChar(boolean endingChar) {
            this.endingChar = endingChar;
        }

    }

    public Set<String> checkKeyWord(String content) {
        Set<String> keyWordList = new HashSet<>();
        char[] chars = content.toCharArray();

        TrieNode current = root;
        StringBuilder sensitiveWord = new StringBuilder();
        for (char c : chars) {
            if (!current.children.containsKey(c)) {
                current = root;
                continue;
            }
            current = current.children.get(c);
            // 非结束节点，记录敏感字符
            sensitiveWord.append(c);


            // 是结束节点，把敏感词放入结果集
            if (current.isEndingChar()) {
                // 是结束节点并且是末尾节点
                if (current.children.size() <= 0) {
                    // 匹配完一个敏感词后游标回到root，继续匹配
                    current = root;
                    keyWordList.add(sensitiveWord.toString());
                    sensitiveWord.delete(0, sensitiveWord.length());
                    continue;
                }
                // 不是末尾节点继续循环匹配子节点
                keyWordList.add(sensitiveWord.toString());
            }

        }

        return keyWordList;
    }

    public Set<String> checkKeyword2(String content){
        Set<String> sensitiveWordSet = new HashSet<>();
        TrieNode current = root;
        while(true){
            if(content.length() == 0){
                return sensitiveWordSet;
            }

            String chr = content.substring(0,1);

            // 首字符不匹配Trie树
            if(current.children.get(chr) == null){
                content = content.substring(1);
                continue;
            }

            // 匹配上了
            int maxLength = getSensitiveWord(content, current, sensitiveWordSet);
            content = content.substring(maxLength);
        }
    }

    /**
     * @param current
     * @param content
     * @param keyWordSet
     * @return java.lang.Long 返回最长的那个关键词的长度
     * @description
     * @author 郑晓龙
     * @createTime 2020/10/21 17:06
     **/
    private int getSensitiveWord(String content,TrieNode current,Set<String> sensitiveWordSet) {
        int maxLength = 0;
        StringBuilder sensitiveWord = new StringBuilder();

        while(true){
            String chr = content.substring(0,1);
            if(current.children.get(chr) == null){
                break;
            }
            current = current.children.get(chr);
            sensitiveWord.append(chr);
            if(current.isEndingChar()){
                String str = sensitiveWord.toString();
                if(current.children.size() == 0){
                    sensitiveWordSet.add(str);
                    Math.max(maxLength,str.length());
                    break;
                }
                // 不是末尾节点继续循环匹配子节点
                Math.max(maxLength,str.length());
                sensitiveWordSet.add(str);
            }
        }


        return maxLength;
    }

    /**
     * @param keyword 要插入的关键词
     * @return void
     * @description 将一个关键词插入到Trie树
     * @author 郑晓龙
     * @createTime 2020/5/7 10:07
     **/
    public void insert(String keyword) {
        if (keyword == null || keyword.length() == 0) {
            return;
        }
        buildTrie(keyword);
    }

    private void buildTrie(String keyword) {
        if (keyword == null || keyword.length() == 0) {
            return;
        }
        TrieNode current = root;
        while (true) {
            if (keyword.length() == 0) {
                break;
            }
            String firstStr = keyword.substring(0, 1);

            if (!current.children.containsKey(firstStr)) {
                current.children.put(firstStr, new TrieNode());
            }
            current = current.children.get(firstStr);
            // 字符往后走一位
            keyword = keyword.substring(1);
        }
        // 插入完成之后将该词的最后一个字符设置为结束节点
        current.setEndingChar(true);

    }

    /**
     * @param keyWord 要查询的关键词
     * @return boolean
     * @description 查询某个关键词是否存在
     * @author 郑晓龙
     * @createTime 2020/5/7 10:01
     **/
    public boolean contains(String keyWord) {
        TrieNode current = root;
        char[] chars = keyWord.toCharArray();
        for (char c : chars) {
            // 不包含该字符直接结束，返回false
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }
        // 全词匹配，是结束节点才返回true
        return current.isEndingChar();
    }
}
