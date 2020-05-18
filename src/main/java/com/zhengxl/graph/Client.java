package com.zhengxl.graph;

/**
 * @description:
 * @projectName:algorithm
 * @see:com.zhengxl.graph
 * @author:郑晓龙
 * @createTime:2020/5/9 9:06
 * @version:1.0
 */
public class Client {
    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(2,5);
        graph.addEdge(5,7);
        graph.addEdge(6,7);
    }
}
