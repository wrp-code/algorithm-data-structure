package com.wrp.algorithm.my.basic.chp5;

import com.wrp.algorithm.my.common.TreeNode;

/**
 * @author wrp
 * @since 2025-03-08 16:28
 **/
public class Q5_SubNode {
    public boolean isSub(TreeNode head, TreeNode node) {
        if(head == null || node == null) return false;
        if(head == node) return true;
        return isSub(head.left(), node) || isSub(head.right(), node);
    }
}
