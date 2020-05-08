package com.zhengxl.trie;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        this.root = new TrieNode();
    }

    /**
     * @param keyWord 要插入的关键词
     * @return void
     * @description 将一个关键词插入到Trie树
     * @author 郑晓龙
     * @createTime 2020/5/7 10:07
     **/
    public void insert(String keyWord) {
        if (keyWord == null || keyWord.length() == 0) {
            return;
        }
        TrieNode current = root;
        char[] chars = keyWord.toCharArray();
        for (char c : chars) {
            // 不包含该字符就构造一个节点并插入
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }
            // 游标指向子节点
            current = current.children.get(c);
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

    /**
     * @param text 需要替换敏感词的字符串
     * @return java.lang.String
     * @description 将字符串中的敏感词替换为 ‘*’
     * @author 郑晓龙
     * @createTime 2020/5/7 10:16
     **/
    public String replaceSensitiveWordsWithStar(String text) {
        char[] chars = text.toCharArray();
        TrieNode current = root;
        StringBuilder sensitiveWord = new StringBuilder();
        for (char c : chars) {
            if (!current.children.containsKey(c)) {
                continue;
            }

            // 非结束节点，记录敏感字符并将游标指向子节点
            if (!current.isEndingChar()) {
                sensitiveWord.append(c);
                current = current.children.get(c);
            }
            // 是结束节点，替换敏感词为*
            if (current.isEndingChar()) {
                StringBuilder stars = new StringBuilder();
                for (int i = 0; i < sensitiveWord.length(); i++) {
                    stars.append("*");
                }
                text = text.replaceAll(sensitiveWord.toString(), stars.toString());
                // 匹配完一个敏感词后游标回到root，继续匹配
                current = root;
                sensitiveWord.delete(0,sensitiveWord.length());
            }

        }
        return text;
    }

    /**
     * @param preWord
     * @return java.util.List<java.lang.String>
     * @description 根据前缀模糊匹配
     * @author 郑晓龙
     * @createTime 2020/5/7 10:15
     **/
    public List<String> prefixMatching(String preWord) {
        List<String> resList = new ArrayList<>();
        StringBuilder wordStringBuilder = new StringBuilder(preWord);
        TrieNode current = root;
        char[] chars = preWord.toCharArray();
        for (char c : chars) {
            if (!current.children.containsKey(c)) {
                return resList;
            }
            current = current.children.get(c);
        }
        // 深度优先遍历
        dfs(current, wordStringBuilder, resList);

        return resList;
    }

    /**
     * @param current 当前节点引用
     * @param word    匹配到的词
     * @param resList 需要返回的结果列表
     * @return void
     * @description 深度优先遍历Trie树
     * @author 郑晓龙
     * @createTime 2020/5/7 16:49
     **/
    private void dfs(TrieNode current, StringBuilder word, List<String> resList) {
        if (current.isEndingChar()) {
            resList.add(word.toString());
            if (current.children.size() <= 0) {
                return;
            }
        }
        for (Map.Entry<Character, TrieNode> entry : current.children.entrySet()) {
            word.append(entry.getKey());
            dfs(entry.getValue(), word, resList);
            // DFS之后回到父级，删除子节点的字符
            word.delete(word.length() - 1, word.length());
        }
    }
}
