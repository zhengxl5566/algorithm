package com.zhengxl.trie;

import org.junit.Assert;
import org.junit.Test;

/**
 * @description:
 * @projectName:algorithm
 * @see:com.zhengxl.trie
 * @author:郑晓龙
 * @createTime:2020/5/6 11:30
 * @version:1.0
 */
public class TrieTest {
    @Test
    public void test(){
        Trie t = new Trie();
        t.insert("中华民族");
        t.insert("中华民国");
        t.insert("中国队");
        t.insert("中国人");
        t.insert("棒子");
        t.insert("骄傲");
        t.insert("hello，world！");
        t.insert("hello，friend！");
        Assert.assertTrue(t.contains("中国队"));
        Assert.assertTrue(t.contains("中国人"));
        System.out.println(t.prefixMatching("中"));
        System.out.println(t.prefixMatching("h"));
        System.out.println(t.replaceSensitiveWordsWithStar("我是中国人我骄傲"));
        System.out.println(t.replaceSensitiveWordsWithStar("狗熊掰棒子都是棒子货"));
    }
}
