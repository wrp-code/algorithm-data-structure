package com.wrp.algorithm.vlog;

/**
 * @author wrp
 * @since 2025年03月29日 22:35
 */
public class C010_PartitionList {

    public static Node partition(Node head, int x) {
        Node leftHead = null, leftTail = null;
        Node rightHead = null, rightTail = null;
        Node next;
        while(head != null) {
            next = head.next;
            head.next = null;
            if(head.val >= x) {
                if(rightHead == null) {
                    rightHead = head;
                }else {
                    rightTail.next = head;
                }
                rightTail = head;
            } else {
                if(leftHead == null) {
                    leftHead = head;
                }else {
                    leftTail.next = head;
                }
                leftTail = head;
            }
            head = next;
        }

        if(leftHead == null){
            return rightHead;
        }
        leftTail.next = rightHead;
        return leftHead;
    }
}
