package com.zhengxl.trie;

import org.junit.Assert;
import org.junit.Test;

/**
 * @description:
 * @projectName:algorithm
 * @see:com.zhengxl.trie
 * @author:郑晓龙
 * @createTime:2020/5/6 9:36
 * @version:1.0
 */
public class TrieTest {
    @Test
    public void trieTest(){
        Trie t = new Trie();
        t.insert(new char[]{'a','b','c','d'});
        t.insert(new char[]{'a','b','c','e'});
        boolean b = t.find(new char[]{'a', 'b', 'c','d'});

        Assert.assertTrue(b);
    }
}
