package com.wrp.algorithm.vlog;


/**
 * @author wrp
 * @since 2025年04月20日 15:04
 */
public class TreeNode {

    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this(value, null, null);
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
