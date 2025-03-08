package com.wrp.algorithm.my.basic.chp5;

import com.wrp.algorithm.my.common.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 找到两个节点的最低公共祖先
 * @author wrp
 * @since 2025-03-08 14:36
 **/
public class Q3_LCA {

    public static void main(String[] args) {

    }

    public TreeNode lca(TreeNode head, TreeNode node1, TreeNode node2) {
        // 找 node1 或 node2，没找到就返回 null
        if(head == null || head == node1 || head == node2) {
            return head;
        }
        TreeNode left = lca(head.left(), node1, node2);
        TreeNode right = lca(head.right(), node1, node2);
        // node1 和 node2 同时找到了就返回当前节点
        if(left != null && right != null) {
            return head;
        }

        // 谁不为null，返回谁，可能都为空
        return left != null ? left : right;
    }


    public TreeNode lcaWithMap(TreeNode head, TreeNode node1, TreeNode node2) {
        // 准备所有节点与父节点的映射
        Map<TreeNode, TreeNode> fatherMap = new HashMap<>();
        fatherMap.put(head, null);
        postMap(fatherMap, head);

        // 准备node1的所有祖先节点
        Set<TreeNode> set1 = new HashSet<>();
        TreeNode cur = fatherMap.get(node1);
        while(cur != null) {
            set1.add(cur);
            cur = fatherMap.get(cur);
        }

        cur = fatherMap.get(node2);
        while(cur != null) {
            if(set1.contains(cur)) {
                return cur;
            }
            cur = fatherMap.get(cur);
        }
        return head;
    }

    public void postMap(Map<TreeNode, TreeNode> fatherMap, TreeNode head) {
        if(head == null) return;
        fatherMap.put(head.left(), head);
        fatherMap.put(head.right(), head);
        postMap(fatherMap, head.left());
        postMap(fatherMap, head.right());
    }
}
