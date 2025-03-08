package com.wrp.algorithm.my.basic.chp5;

import java.util.LinkedList;
import java.util.List;

/**
 * 节点的后继节点
 * @author wrp
 * @since 2025-03-08 15:08
 **/
public class Q4_PostNode {

    public static class Node {
        int value;
        Node left;
        Node right;
        Node parent;

        public Node(int value, Node left, Node right, Node parent) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }


    public Node postNode(Node head, Node node) {
        if(head == null) {
            return null;
        }

        // 有右子树，返回右子树最左节点
        if(node.right != null) {
            return getLeftMost(node.right);
        } else {// 无右子树，如果是最后一个节点，则返回null，否则直到当前节点是父节点的左孩子。
            Node parent = node.parent;
            // parent == null，找到根节点
            // parent.left != node，直到左节点
            while(parent != null && parent.left != node) {
                node = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    public Node getLeftMost(Node node) {
        if(node == null) return null;
        while(node.left != null) {
            node = node.left;
        }

        return node;
    }

    // 使用list
    public Node postNodeWithList(Node head, Node node) {
        List<Node> list = new LinkedList<>();
        post(head, list);

        boolean cur = false;
        for (int i = 0; i < list.size(); i++) {
            if(cur) {
                return list.get(i);
            }
            if(node == list.get(i)) {
                cur = true;
            }
        }
        return null;
    }

    public void post(Node head, List<Node> list) {
        if(head == null) {
            return;
        }

        post(head.left, list);
        list.add(head);
        post(head.right, list);
    }
}
