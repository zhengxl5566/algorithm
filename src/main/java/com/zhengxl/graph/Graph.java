package com.zhengxl.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:无向图（邻接表实现）
 * @projectName:algorithm
 * @see:com.zhengxl.graph
 * @author:郑晓龙
 * @createTime:2020/5/9 9:00
 * @version:1.0
 */
public class Graph {
    /**
     * 顶点个数
     **/
    private int count;
    /**
     * 邻接表
     **/
    private List<Integer>[] array;

    public Graph(int count) {
        this.count = count;
        array = new LinkedList[count];
        for (int i = 0; i < array.length; i++) {
            array[i] = new LinkedList<>();
        }
    }
    public void addEdge(int start,int end){
        array[start].add(end);
        array[end].add(start);
    }
}
