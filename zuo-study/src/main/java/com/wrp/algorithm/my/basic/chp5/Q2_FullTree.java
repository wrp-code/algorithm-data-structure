package com.wrp.algorithm.my.basic.chp5;

import com.wrp.algorithm.my.common.TreeNode;

/**
 * 是否为满二叉树
 * @author wrp
 * @since 2025-03-06 23:09
 **/
public class Q2_FullTree {

    public boolean ifFull(TreeNode node) {
        ReturnData process = process(node);

        return process.nodes == (1 << process.height - 1);
    }

    public ReturnData process(TreeNode node) {
        if(node == null) {
            return new ReturnData(0,0);
        }

        ReturnData left = process(node.left());
        ReturnData right = process(node.right());

        int height = Math.max(left.height, right.height) + 1;
        int nodes = left.nodes + right.nodes + 1;
        return new ReturnData(height, nodes);
    }

    public record ReturnData(int height, int nodes) {}
}
