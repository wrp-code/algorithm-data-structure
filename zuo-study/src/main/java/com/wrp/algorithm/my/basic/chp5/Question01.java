package com.wrp.algorithm.my.basic.chp5;

import com.wrp.algorithm.my.common.TreeNode;

import java.util.Stack;

/**
 * @author wrp
 * @since 2025-03-05 07:33
 **/
public class Question01 {

    public void f(TreeNode root) {
        // 1
        if(root == null) {
            return;
        }
        // 1
        f(root.left());
        // 2
        // 2
        f(root.right());
        // 3
        // 3
    }

    public void preOrderRecursion(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.println(root.value());
        f(root.left());
        f(root.right());
    }

    public void preOrderUnRecursion(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            System.out.print(root.value());
            if(root.right() != null) {
                stack.push(root.right());
            }
            if(root.left() != null) {
                stack.push(root.left());
            }
        }
    }

    public void inOrderRecursion(TreeNode root) {
        if(root == null) {
            return;
        }
        f(root.left());
        System.out.println(root.value());
        f(root.right());
    }

    public void inOrderUnRecursion(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            if(root != null) {
                stack.push(root);
                root = root.left();
            } else {
                root = stack.pop();
                System.out.print(root.value());
                root = root.right();
            }
        }
    }

    public void afterOrderRecursion(TreeNode root) {
        if(root == null) {
            return;
        }
        f(root.left());
        f(root.right());
        System.out.println(root.value());
    }

    public void afterOrderUnRecursion(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> inStack = new Stack<>();
        Stack<TreeNode> outStack = new Stack<>();
        inStack.push(root);
        while(!inStack.isEmpty()) {
            root = inStack.pop();
            outStack.push(root);
            if(root.right() != null) {
                inStack.push(root.right());
            }
            if(root.left() != null){
                inStack.push(root.left());
            }
        }

        while(!outStack.isEmpty()) {
            System.out.println(outStack.pop().value());
        }
    }
}
