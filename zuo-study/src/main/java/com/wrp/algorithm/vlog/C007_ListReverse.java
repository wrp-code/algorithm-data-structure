package com.wrp.algorithm.vlog;

/**
 * @author wrp
 * @since 2025-03-26 07:39
 **/
public class C007_ListReverse {

    public static class Number {
        int val;

        public Number(int val) {
            this.val = val;
        }
    }


    // 反转单链表
    public static Node reverse(Node head) {
        Node prev = null;
        Node next;
        while(head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    // 反转双向链表
    public static DeNode reverse(DeNode head) {
        DeNode prev = null;
        DeNode next;
        while(head != null) {
            next = head.next;
            head.next = prev;
            head.prev = next;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        int a = 10;
        f1(a);
        System.out.println(a);

        Number b = new Number(5);
        g1(b);
        System.out.println(b.val);
        g2(b);
        System.out.println(b.val);
    }

    // 不影响
    public static void f1(int a) {
        a = 0;
    }

    // 不影响 !!!
    public static void g1(Number a) {
        a = null;
    }

    // 影响
    public static void g2(Number a) {
        a.val = 10;
    }
}
