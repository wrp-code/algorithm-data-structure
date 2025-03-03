package com.wrp.nc;

/**
 * @author wrp
 * @since 2025年02月20日 20:26
 */
public class NC3 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead.next == null) {
            return null;
        }
        if(pHead.next == pHead) {
            return pHead;
        }

        ListNode fast = pHead.next;
        ListNode slow = pHead.next.next;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next.next;
        }

        fast = pHead;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
