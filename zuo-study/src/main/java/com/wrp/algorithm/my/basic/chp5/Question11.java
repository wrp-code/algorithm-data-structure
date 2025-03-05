package com.wrp.algorithm.my.basic.chp5;

import com.wrp.algorithm.my.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wrp
 * @since 2025-03-04 21:33
 **/
public class Question11 {

    /**
     * 如果两个链表相交，请返回相交的 第一个节点。如果不相交，返回null
     * @param head1 头1
     * @param head2 头2
     * @return 相交返回相交节点，反之null.
     */
    public ListNode getIntersectNode(ListNode head1, ListNode head2) {
        if(head1 == null || head2 == null) {
            return null;
        }
        // 获取两个链表的入环节点
        ListNode loopNode1 = getInNodeIfHasCircleWithSlowFastNode(head1);
        ListNode loopNode2 = getInNodeIfHasCircleWithSlowFastNode(head2);
        // 如果两个都没环
        if(loopNode1 == null && loopNode2 == null) {
            return getIntersectionNodeOfNoCircle(head1, head2);
        }
        // 如果两个都有环
        if(loopNode1 != null && loopNode2 != null) {
            return getIntersectionNodeOfCircle(head1, loopNode1, head2, loopNode2);
        }
        // 其他情况不可能相交
        return null;
    }

    /**
     * 判断单链表是否有环，方式1：使用哈希表
     * @param head 头
     * @return 入环节点，无环时返回null
     */
    public ListNode getInNodeIfHasCircleWithMap(ListNode head) {
        Set<ListNode> usedNodes = new HashSet<>();
        ListNode currentNode = head;
        while(currentNode != null) {
            if(usedNodes.contains(currentNode)) {
                return currentNode;
            }
            usedNodes.add(currentNode);
            currentNode = currentNode.next();
        }
        return null;
    }

    /**
     * 判断单链表是否有环，方式2：快慢指针
     * @param head 头
     * @return 入环节点，无环时返回null
     */
    public ListNode getInNodeIfHasCircleWithSlowFastNode(ListNode head) {
        if(head == null || head.next() == null) {
            return null;
        }
        ListNode fast = head.next().next();
        ListNode slow = head.next();
        while(fast != slow) {
            if(fast == null || fast.next() == null) {
                return null;
            }
            fast = fast.next().next();
            slow = slow.next();
        }
        fast = head;
        while(slow != fast) {
            slow = slow.next();
            fast = fast.next();
        }
        return slow;
    }

    /**
     * 判断两个无环链表是否相交，如果相交返回首个相交节点
     * @param head1 头
     * @param head2 头
     * @return 相交节点，如果不相交返回null
     */
    public ListNode getIntersectionNodeOfNoCircle(ListNode head1, ListNode head2) {
        if(head1 == null || head2 == null) {
            return null;
        }
        ListNode cur1 = head1;
        // n代表两个链表的差值
        int n = 0;
        while(cur1.next() != null) {
            n++;
            cur1 = cur1.next();
        }

        ListNode cur2 = head2;
        while(cur2.next() != null) {
            n--;
            cur2 = cur2.next();
        }

        // 如果两个尾节点不同，则不相交
        if(cur1 != cur2) {
            return null;
        }

        cur1 = n > 0 ? head1 : head2;// 长链表
        cur2 = cur1 == head1 ? head2 : head1;//短链表
        n = Math.abs(n);
        // 长的链表先走n
        while(n-- > 0) {
            cur1 = cur1.next();
        }
        // 两个链表首次相遇时，相交
        while(cur1 != cur2) {
            cur1 = cur1.next();
            cur2 = cur2.next();
        }

        return cur1;
    }

    /**
     * 判断两个有环链表是否相交，如果相交返回首个相交节点
     * @param head1 头1
     * @param node1 入环节点1
     * @param head2 头2
     * @param node2 入环节点2
     * @return 相交节点
     */
    public ListNode getIntersectionNodeOfCircle(ListNode head1, ListNode node1, ListNode head2, ListNode node2) {
        if(node1 == node2) {
            return getIntersectionNodeOfCircleWithEqualInNode(head1, head2, node1);
        }
        return getIntersectionNodeOfCircleWithNoEqualInNode(head1, node1, head2, node2);
    }

    public ListNode getIntersectionNodeOfCircleWithEqualInNode(ListNode head1, ListNode head2, ListNode inNode) {
        if(head1 == null || head2 == null) {
            return null;
        }
        ListNode cur1 = head1;
        // n代表两个链表的差值
        int n = 0;
        while(cur1.next() != inNode) {
            n++;
            cur1 = cur1.next();
        }

        ListNode cur2 = head2;
        while(cur2.next() != inNode) {
            n--;
            cur2 = cur2.next();
        }

        // 如果两个尾节点不同，则不相交
        if(cur1 != cur2) {
            return null;
        }

        cur1 = n > 0 ? head1 : head2;// 长链表
        cur2 = cur1 == head1 ? head2 : head1;//短链表
        n = Math.abs(n);
        // 长的链表先走n
        while(n-- > 0) {
            cur1 = cur1.next();
        }
        // 两个链表首次相遇时，相交
        while(cur1 != cur2) {
            cur1 = cur1.next();
            cur2 = cur2.next();
        }

        return cur1;
    }

    public ListNode getIntersectionNodeOfCircleWithNoEqualInNode(ListNode head1, ListNode node1, ListNode head2, ListNode node2) {
        ListNode cur = node1.next();
        while(cur != node1) {
            if(cur == node2) {
                // 任意返回node1，node2
                return node1;
            }
            cur = cur.next();
        }
        return null;
    }
}
