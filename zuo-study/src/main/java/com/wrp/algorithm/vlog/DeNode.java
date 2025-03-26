package com.wrp.algorithm.vlog;

/**
 * @author wrp
 * @since 2025-03-26 08:14
 **/
public class DeNode {
    int val;
    DeNode prev;
    DeNode next;

    public DeNode(int val, DeNode prev, DeNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}
