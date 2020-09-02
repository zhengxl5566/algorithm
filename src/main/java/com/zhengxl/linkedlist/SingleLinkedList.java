package com.zhengxl.linkedlist;

/**
 * @description: 单链表
 * @projectName:algorithm
 * @see:com.zhengxl.linkedlist
 * @author:郑晓龙
 * @createTime:2020/9/2 13:59
 * @version:1.0
 */
public class SingleLinkedList {
    private Node head;
    private int size;

    public SingleLinkedList() {
        head = null;
        size = 0;
    }

    public Node addFromHead(Node node) {
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
        return head;
    }

    public Node append(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node pre = head;
            while (pre.next != null) {
                pre = pre.next;
            }
            pre.next = node;
        }
        size++;
        return head;
    }

    public void travelList() {
        if (head == null) {
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.value);
            curr = curr.next;
        }
    }

    public Node findValue(int value) {
        Node curr = head;
        while (curr != null) {
            if (curr.value == value) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    public int getSize() {
        return size;
    }

}
