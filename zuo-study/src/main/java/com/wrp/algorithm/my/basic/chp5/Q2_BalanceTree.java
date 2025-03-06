package com.wrp.algorithm.my.basic.chp5;

import com.wrp.algorithm.my.common.TreeNode;

/**
 * @author wrp
 * @since 2025-03-06 22:53
 **/
public class Q2_BalanceTree {

    public boolean isBalance(TreeNode node) {
        ReturnType returnType = process(node);
        return returnType.balance;
    }

    public ReturnType process(TreeNode node) {
        if(node == null) {
            return new ReturnType(true, 0);
        }

        ReturnType left = process(node.left());
        ReturnType right = process(node.right());

        int height = Math.max(left.height, right.height) + 1;
        boolean balance = left.balance && right.balance && (Math.abs(left.height - right.height) < 2);

        return new ReturnType(balance, height);
    }

    public record ReturnType(boolean balance, int height){}
}
