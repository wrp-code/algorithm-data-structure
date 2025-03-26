package com.wrp.algorithm.vlog;

/**
 * @author wrp
 * @since 2025-03-26 22:22
 **/
public class C009_AddNode {

    public static Node add(Node head1, Node head2) {
        Node res = null;
        Node cur = null;
        int carry = 0;
        int sum;
        for(Node p1 = head1,p2 = head2; p1 != null || p2 != null;
            p1 = p1==null ? null : p1.next, p2 = p2==null ? null : p2.next) {
            sum = (p1 == null ? 0 : p1.val) +
                    (p2 == null ? 0 : p2.val) + carry;
            carry = sum / 10;
            sum = sum % 10;
            if(res == null) {
                res = new Node(sum, null);
                cur = res;
            } else {
                cur.next = new Node(sum, null);
                cur = cur.next;
            }
        }
        if(carry > 0) {
            cur.next = new Node(carry, null);
        }
        return res;
    }
}
