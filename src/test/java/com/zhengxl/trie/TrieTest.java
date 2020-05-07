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
        t.insert("中华人民共和国");
        t.insert("中国");
        t.insert("中国人");
        t.insert("我的祖国");
        Assert.assertTrue(t.find("我的祖国"));
        Assert.assertTrue(t.find("中国"));
        Assert.assertTrue(t.find("中国人"));
    }
}
