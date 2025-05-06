package com.wrp.algorithm.vlog;


import java.util.Stack;

/**
 * 非递归实现二叉树遍历
 * @author wrp
 * @since 2025年04月20日 15:27
 */
public class C018_BinaryTreeTraversal {

    public static void preOrder(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.println(pop.value);
            if(pop.right != null) {
                stack.push(pop.right);
            }
            if(pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    public static void inOrder(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        // 栈空并且root指向null时退出循环
        while(!stack.isEmpty() || root != null) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                System.out.println(pop.value);
                root = pop.right;
            }
        }
    }

    // 需要两个栈，空间复杂度O(n)
    public static void postOrder(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        // result的进栈顺序：根右左 ，出栈顺序：左右根
        Stack<TreeNode> result = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            result.push(pop);
            if(pop.left != null) {
                stack.push(pop.left);
            }
            if(pop.right != null) {
                stack.push(pop.right);
            }
        }
        while(!result.isEmpty()) {
            System.out.println(result.pop().value);
        }
    }

    // 空间复杂度O(h)树的高度
    public static void postOrderWithOneStack(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        // 标志位，上一次打印处理的位置。
        TreeNode h = root;
        while(!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if(cur.left != null &&
                h != cur.left &&
                h != cur.right) {
                stack.push(cur.left);
            } else if(cur.right != null &&
                h != cur.right) {
                stack.push(cur.right);
            } else {
                TreeNode pop = stack.pop();
                System.out.println(pop.value);
            }
        }
    }

}
