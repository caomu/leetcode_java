package com.caomu.util;

/**
 * @author : CAOMU
 * @version : 1.0
 * @project : leetcode_java
 * @since : 2021/02/11, Thu, 12:14
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
