package com.zhengxl.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @projectName:algorithm
 * @see:com.zhengxl.trie
 * @author:郑晓龙
 * @createTime:2020/5/6 15:22
 * @version:1.0
 */
public class Test {
    /**
     * @Title: Node
     * @Description: trie树的节点
     */
    private class Node {
        // 节点是否为叶子节点的标志；true：叶子节点，false：非叶子节点（用于子节点的节点）
        public boolean isWord;
        // 当前节点拥有的孩子节点，使用hashmap进行存储，在查找子节点时的时间复杂度为O(1)
        public HashMap<Character, Node> children;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.children = new HashMap<>();
        }

        public Node() {
            this(false);
        }
    }

    // trie树的根节点
    private Node root;
    // trie树中拥有多少分枝（多少个敏感词）
    private int size;

    public Test() {
        this.root = new Node();
        this.size = 0;
    }

    /**
     * @Description: 返回trie树中分枝树（敏感词树）
     */
    public int getSize() {
        return size;
    }

    /**
     * @param word 添加的敏感词
     * @Description: 向trie树中添加分枝/敏感词
     */
    public void addBranchesInTrie(String word) {
        // 设置当前节点为根节点
        Node cur = root;
        char[] words = word.toCharArray();

        for (char c : words) {
            // 判断当前节点的子节点中是否存在字符c
            if (!cur.children.containsKey(c)) {
                // 如果不存在则将其添加进行子节点中
                cur.children.put(c, new Node());
            }
            // 当前节点进行变换，变换为新插入到节点 c
            cur = cur.children.get(c);
        }
        // 分枝添加完成后，将分枝中的最后一个节点设置为叶子节点
        if (!cur.isWord) {
            cur.isWord = true;
            // 分枝数（敏感词数）加1
            size++;
        }
    }

    /**
     * @param word
     * @return
     * @Description: 判断trie树中是否存在某分枝/敏感词
     */
    public boolean contains(String word) {
        Node cur = root;
        char[] words = word.toCharArray();

        for (char c : words) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        // 如果存在并且遍历到trie树中某个分支最后一个节点了，那此节点就是叶子节点，直接返回true
        return cur.isWord;
    }

    /**
     * @param word 一段话，如果有敏感词需要被替换的词
     * @return
     * @Description: 如果一段话中有trie树中存储的敏感词则需将其进行替换为 **; 例如：尼玛的，替换为 **的
     */
    public String sensitiveWordReplace(String word) {
        System.out.println("敏感词替换前：" + word);

        Node cur = root;
        char[] words = word.toCharArray();
        // 需要被替换的敏感词
        StringBuilder oldTemp = new StringBuilder();
        // 需要替换成的星号
        StringBuilder starTemp = new StringBuilder();

        for (char c : words) {
            if (!cur.children.containsKey(c)) {
                // 如果当前节点的孩子节点中没有此单词则直接跳过此循环，进入下次循环
                continue;
            }
            if (!cur.isWord) {
                // 拼接上word和trie树都有的字符
                oldTemp.append(c);
                starTemp.append("*");
                cur = cur.children.get(c);
            }
            if (cur.isWord) {
                // 进行敏感词替换
                word = word.replaceAll(oldTemp.toString(), starTemp.toString());
                // 清空StringBuilder中内容
                oldTemp.delete(0, oldTemp.length());
                starTemp.delete(0, starTemp.length());
                // 查找一个敏感词并替换后，需要重新从根节点进行遍历，所以当前节点指向root
                cur = root;
            }
        }
        System.out.println("敏感词替换后：" + word);
        return word;
    }

    // 存放trie树中查询到的联想词
    private List<String> list = new ArrayList<String>();

    /**
     * @param word
     * @Description: 利用trie的公共前缀特性，可以实现关键词自动联想
     */
    public void prefixMatching(String word, Node root) {
        Node cur = root;
        char[] words = word.toCharArray();
        StringBuilder str = new StringBuilder();
        str.append(word);

        for (int i = 0; i < words.length; i++) {
            if (!cur.children.containsKey(words[i])) {
                System.out.println("无关联词！");
                return;
            }
            cur = cur.children.get(words[i]);
        }
        dfs(str, cur);
        System.out.println("[ " + word + " ]在trie树中的联想词：" + Arrays.toString(list.toArray()));
    }

    /**
     * @param word 需要查找的词
     * @param root 开始遍历的根节点
     * @Description: 节点遍历
     */
    public void dfs(StringBuilder word, Node root) {
        Node cur = root;
        if (cur.isWord) {
            list.add(word.toString());
            if (cur.children.size() == 0) {
                return;
            }
        }
        for (Character s : cur.children.keySet()) {
            word.append(s);
            // 递归调用
            dfs(word, cur.children.get(s));
            word.delete(word.length() - 1, word.length());
        }
    }

    // test
    public static void main(String[] args) {
        Test t = new Test();
        // 插入敏感词
        t.addBranchesInTrie("麻痹");
        t.addBranchesInTrie("尼玛的");
        t.addBranchesInTrie("狗日的");

        // 插入联想词
        t.addBranchesInTrie("联想云科技");
        t.addBranchesInTrie("联盟");
        t.addBranchesInTrie("联和利泰扩招了");

        System.out.println("trie树中分枝的个数：" + t.size);

        String word = "尼玛的";
        System.out.println("Trie树中是否存在[ " + word + " ]敏感词: " + t.contains(word));
        // 敏感词替换测试
        t.sensitiveWordReplace("衮，尼玛的傻子，你麻痹的，你各狗日的，早晚揍死你。");

        // trie树实现联想测试
        t.prefixMatching("联", t.root);
    }
}
