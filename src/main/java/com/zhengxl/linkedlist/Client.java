package com.zhengxl.linkedlist;

/**
 * @description:
 * @projectName:algorithm
 * @see:com.zhengxl.linkedlist
 * @author:郑晓龙
 * @createTime:2020/9/2 14:08
 * @version:1.0
 */
public class Client {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);


        list.append(node1);
        list.append(node2);
        System.out.println(list.getSize());
        list.travelList();
    }
}
