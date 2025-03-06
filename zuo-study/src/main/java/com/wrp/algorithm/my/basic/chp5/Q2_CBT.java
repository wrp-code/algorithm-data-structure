package com.wrp.algorithm.my.basic.chp5;

import com.wrp.algorithm.my.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * CBT 完全二叉树
 * @author wrp
 * @since 2025-03-06 21:58
 **/
public class Q2_CBT {

    public boolean isCBT(TreeNode node) {
        if(node == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        boolean leaf = false;
        while(!queue.isEmpty()) {
            node = queue.poll();

            // 有右无左，遇到不全的节点后（leaf == true）再次遇到非叶子节点
            if((node.right() != null && node.left() == null) ||
                    (leaf && (node.left() != null || node.right() != null))) {
                return false;
            }

            if(node.left() != null) {
                queue.offer(node.left());
            }
            if(node.right() != null) {
                queue.offer(node.right());
            }

            if(node.right() == null || node.left() == null) {
                leaf = true;
            }
        }
        return true;
    }
}
