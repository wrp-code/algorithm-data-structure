package com.wrp.nc.hj;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author wrp
 * @since 2025-03-03 18:22
 **/
public class HJ48 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(" ");
        int num = Integer.parseInt(split[0]);
        Node head = new Node(Integer.parseInt(split[1]), null);
        Map<Integer, Node> map = new TreeMap<>();
        map.put(head.value, head);
        for (int i = 0; i < num - 1; i++) {
            int value = Integer.parseInt(split[(i + 1) * 2]);
            int idx = Integer.parseInt(split[(i + 1) * 2 + 1]);
            Node node = map.get(idx);
            node.next = new Node(value, node.next);
            map.put(value, node.next);
        }

        int deleted = Integer.parseInt(split[split.length - 1]);
        while(head != null) {
            if(head.value != deleted) {
                System.out.print(head.value + " ");
            }
            head = head.next;
        }
    }

    static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
