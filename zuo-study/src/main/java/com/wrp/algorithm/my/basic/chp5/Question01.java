package com.wrp.algorithm.my.basic.chp5;

import com.sun.source.tree.Tree;
import com.wrp.algorithm.my.common.TreeNode;

import java.util.*;

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

    public void widthSearch(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            root = queue.remove();
            System.out.println(root.value());
            if(root.left() != null) {
                queue.add(root.left());
            }
            if(root.right() != null) {
                queue.add(root.right());
            }
        }
    }

    public void maxWidthWithMap(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Map<TreeNode, Integer> levelMap = new TreeMap<>();
        levelMap.put(root, 1);
        int curLevel = 1;
        int curNodes = 0;
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()) {
            root = queue.remove();
            if(curLevel == levelMap.get(root)) {
                curNodes++;
            } else {
                max = Math.max(max, curNodes);
                curNodes = 1;
                curLevel++;
            }

            if(root.left() != null) {
                queue.add(root.left());
                levelMap.put(root.left(), curLevel + 1);
            }
            if(root.right() != null) {
                queue.add(root.right());
                levelMap.put(root.right(), curLevel + 1);
            }
        }
    }

    public void maxWidthNoMap(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode curEnd = root;
        TreeNode nextEnd = null;
        int curNodes = 0;
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()) {
            root = queue.remove();
            if(root == curEnd) {
                // 结算当前行
                max = Math.max(max, curNodes);
                curNodes = 0;
                curEnd = nextEnd;
                nextEnd = null;
            } else {
                curNodes++;
            }

            if(root.left() != null) {
                queue.add(root.left());
                nextEnd = root.left();
            }
            if(root.right() != null) {
                queue.add(root.right());
                nextEnd = root.right();
            }
        }
    }
}
