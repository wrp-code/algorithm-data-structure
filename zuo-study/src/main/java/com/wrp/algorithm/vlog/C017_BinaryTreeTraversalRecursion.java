package com.wrp.algorithm.vlog;

/**
 * 递归实现二叉树的三种遍历
 * @author wrp
 * @since 2025年04月20日 15:09
 */
public class C017_BinaryTreeTraversalRecursion {

    // 先序
    public static void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.println(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序
    public static void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
    }

    // 后序
    public static void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);
    }

    // 递归序
    public static void f(TreeNode root) {
        if(root == null) {
            return;
        }
        // 1.
        f(root.left);
        // 2.
        f(root.right);
        // 3.
    }
}
