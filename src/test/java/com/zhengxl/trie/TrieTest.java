package com.zhengxl.trie;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

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
        t.insert("中印战争");
        t.insert("中印");
        t.insert("中华");


        t.insert("战争中印");


        t.insert("中华");
        t.insert("中华民族");
        t.insert("中华民国");
        t.insert("中国队");
        t.insert("中国人");
        t.insert("中国");
        t.insert("棒子");
        t.insert("骄傲");
        t.insert("hello，world！");
        t.insert("hello，friend！");
    }
    @Test
    public void containsTest(){
        Assert.assertFalse(t.contains("民族"));
        Assert.assertTrue(t.contains("中国人"));
        Assert.assertTrue(t.contains("中国人民"));
        Assert.assertTrue(t.contains("中国"));
    }

    @Test
    public void checkKeyword(){
        Set<String> res = t.checkKeyword2("中印战争");
        System.out.println(res);
    }
}
