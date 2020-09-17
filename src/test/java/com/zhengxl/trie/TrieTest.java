package com.zhengxl.trie;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @projectName:algorithm
 * @see:com.zhengxl.trie
 * @author:郑晓龙
 * @createTime:2020/5/6 11:30
 * @version:1.0
 */
public class TrieTest {
    private Trie t;
    @Before
    public void init(){
        t = new Trie();
        t.insert("中华民族");
        t.insert("中华民国");
        t.insert("中国队");
        t.insert("中国人");
        t.insert("棒子");
        t.insert("骄傲");
        t.insert("hello，world！");
        t.insert("hello，friend！");
    }
    @Test
    public void preFixMatchTest(){
        Assert.assertArrayEquals(t.prefixMatching("中").toArray(), Arrays.asList("中国人","中国队","中华民国","中华民族").toArray());
    }
    @Test
    public void sensitiveWordMatchTest(){
        Assert.assertEquals(t.replaceSensitiveWordsWithStar("我是中国人我骄傲"),"我是***我**");
        Assert.assertEquals(t.replaceSensitiveWordsWithStar("狗熊掰棒子都是棒子货"),"狗熊掰**都是**货");
    }
    @Test
    public void containsTest(){
        Assert.assertFalse(t.contains("民族"));
        Assert.assertTrue(t.contains("中国人"));
    }
}
