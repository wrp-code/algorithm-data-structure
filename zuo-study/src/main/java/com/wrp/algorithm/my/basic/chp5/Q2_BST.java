package com.wrp.algorithm.my.basic.chp5;

import com.sun.source.tree.Tree;
import com.wrp.algorithm.my.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wrp
 * @since 2025-03-06 08:13
 **/
public class Q2_BST {

    int preValue = Integer.MIN_VALUE;

    /**
     * 中序遍历递归改版
     * @param root 头
     * @return 是否是BST
     */
    public boolean isBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        if(!isBST(root.left())) return false;

        // 打印处处理
        if(root.value() < preValue) {
            return false;
        } else {
            preValue = root.value();
        }

        return isBST(root.right());
    }

    /**
     * 中序遍历非递归改版
     * @param root 头
     * @return 是否是BST
     */
    public boolean isBSTRecursion(TreeNode root) {
        if(root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        int preValue = Integer.MIN_VALUE;
        while(root != null || !queue.isEmpty()) {
            if(root != null) {
                queue.offer(root);
                root = root.left();
            } else {
                root = queue.poll();
                // 打印处处理
                if(root.value() < preValue) {
                    return  false;
                } else {
                    preValue = root.value();
                }

                root = root.right();
            }
        }
        return true;
    }

    public boolean isBST_DP(TreeNode node) {
        ReturnInfo returnInfo = process(node);
        return returnInfo.isBST;
    }

    public ReturnInfo process(TreeNode node) {
        if(node == null )return null;

        ReturnInfo left = process(node.left());
        ReturnInfo right = process(node.right());

        int min = node.value();
        int max = node.value();
        if(left != null) {
            min = Math.min(min, left.min);
            max = Math.max(max, left.max);
        }
        if(right != null) {
            min = Math.min(min, right.min);
            max = Math.max(max, right.max);
        }

        boolean isBST = true;
        if(left != null && (!left.isBST || left.max >= node.value())) {
            isBST = false;
        }
        if(right != null && (!right.isBST || right.min <= node.value())) {
            isBST = false;
        }

        return new ReturnInfo(isBST, min, max);

    }

    public record ReturnInfo(boolean isBST, int min, int max) {}
}
