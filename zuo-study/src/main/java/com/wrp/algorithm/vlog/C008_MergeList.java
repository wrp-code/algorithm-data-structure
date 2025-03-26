package com.wrp.algorithm.vlog;

/**
 * @author wrp
 * @since 2025-03-26 08:13
 **/
public class C008_MergeList {

    // 合并两个有序链表
    public static Node merge(Node head1, Node head2) {
        if(head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        Node head = head1.val <= head2.val ? head1 : head2;
        Node cur1 = head == head1 ? head2.next : head1.next;
        Node cur2 = head.next;
        Node prev = head;
        while(cur1 != null && cur2 != null) {
            if(cur1.val <= cur2.val) {
                prev.next = cur1;
                cur1 = cur1.next;
            } else  {
                prev.next = cur2;
                cur2 = cur2.next;
            }
            prev = prev.next;
        }

        prev.next = cur1 == null ? cur2 : cur1;
        return head;
    }
}
