package com.zhengxl.trie;

import java.util.*;

/**
 * @description:
 * @projectName:algorithm
 * @see:com.zhengxl.trie
 * @author:郑晓龙
 * @createTime:2020/5/27 14:21
 * @version:1.0
 */
public class ACAutoMata {
    private ACNode root;

    public ACAutoMata() {
        this.root = new ACNode("/");
    }

    public static Set<String> match(String text, String[] patterns) {
        ACAutoMata acAutoMata = new ACAutoMata();
        for (String pattern : patterns) {
            acAutoMata.insert(pattern);
        }

        acAutoMata.buildFailurePointer();
        return acAutoMata.match(text);
    }

    private void buildFailurePointer() {
        ACNode root = this.root;
        LinkedList<ACNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            ACNode p = queue.pop();

            for (ACNode pc : p.children.values()) {
                if (Objects.isNull(pc)) {
                    continue;
                }

                if (p == root) {
                    pc.fail = root;
                } else {
                    ACNode q = p.fail;
                    while (Objects.nonNull(q)) {
                        ACNode qc = q.children.get(pc.data);
                        if (Objects.nonNull(qc)) {
                            pc.fail = qc;
                            break;
                        }
                        q = q.fail;
                    }
                    if (Objects.isNull(q)) {
                        pc.fail = root;
                    }
                }
                queue.add(pc);
            }
        }
    }

    private Set<String> match(String text) {
        ACNode root = this.root;
        ACNode p = root;

        Set<String> keyWordList = new HashSet<>();
        StringBuilder sensitiveWord = new StringBuilder();
        int n = text.length();
        for (int i = 0; i < n; i++) {
            String c = text.charAt(i) + "";
            while (Objects.isNull(p.children.get(c)) && p != root) {
                p = p.fail;
            }

            p = p.children.get(c);
            if (Objects.isNull(p)) {
                p = root;
            }


            ACNode tmp = p;
            while (tmp != root) {
                // 是结束节点
                if (tmp.isEndingChar == true) {
                    String matchedWord = sensitiveWord.append(text, i - tmp.length + 1, i + 1).toString();
                    // ①没有子节点了，把该关键词放入结果集并返回
                    if(tmp.children.size() == 0){
                        keyWordList.add(matchedWord);
                        tmp = tmp.fail;
                        sensitiveWord.delete(0, matchedWord.length());
                        continue;
                    }
                    // ②还有子节点，把关键词放入结果集，清空关键词缓存，继续走失败节点之后的代码
                    keyWordList.add(matchedWord);
                    sensitiveWord.delete(0, matchedWord.length());
                }
                tmp = tmp.fail;
            }
        }

        return keyWordList;
    }

    private void insert(String pattern) {
        ACNode node = this.root;
        int len = pattern.length();
        for (int i = 0; i < len; i++) {
            String c = pattern.charAt(i) + "";
            if (Objects.isNull(node.children.get(c))) {
                node.children.put(c, new ACNode(c));
            }
            node = node.children.get(c);
        }

        node.isEndingChar = true;
        node.length = pattern.length();
    }

    private class ACNode {
        private String data;
        private Map<String, ACNode> children;
        private Boolean isEndingChar;
        private Integer length;
        private ACNode fail;

        public ACNode(String data) {
            this.data = data;
            this.children = new HashMap<>();
            this.isEndingChar = false;
            this.length = 0;
            this.fail = null;
        }
    }
}
