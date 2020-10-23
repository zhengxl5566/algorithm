package com.zhengxl.trie;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

/**
 * @description:
 * @projectName:algorithm
 * @see:com.zhengxl.trie
 * @author:郑晓龙
 * @createTime:2020/10/23 13:53
 * @version:1.0
 */
public class ACAutoMataTest {
    @Test
    public void preMatchTest(){
        String[] patterns = {"大中国","中国"};
        Set<String> matchRes = ACAutoMata.match("我们的大中国", patterns);
        Assert.assertTrue(matchRes.contains("大中国")&& matchRes.contains("中国"));
    }

    @Test
    public void postMatchTest(){
        String[] patterns = {"中国人","中国"};
        Set<String> matchRes = ACAutoMata.match("我是中国人", patterns);
        Assert.assertTrue(matchRes.contains("中国人")&& matchRes.contains("中国"));
    }

    @Test
    public void matchTest(){
        String[] patterns = {"中国人","中国"};
        Set<String> matchRes = ACAutoMata.match("我们都是中国人啊", patterns);
        Assert.assertTrue(matchRes.contains("中国人")&& matchRes.contains("中国"));
    }
}
