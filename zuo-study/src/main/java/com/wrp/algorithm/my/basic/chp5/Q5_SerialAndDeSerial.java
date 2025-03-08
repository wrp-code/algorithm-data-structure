package com.wrp.algorithm.my.basic.chp5;

import com.wrp.algorithm.my.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化和反序列化
 * @author wrp
 * @since 2025-03-08 15:43
 **/
public class Q5_SerialAndDeSerial {

    public String serialByPre(TreeNode treeNode) {
        if(treeNode == null) return "#_";

        String res = treeNode.value() + "_";
        res += serialByPre(treeNode.left());
        res += serialByPre(treeNode.right());

        return res.substring(0, res.length() - 1);
    }

    public TreeNode deserialize(String str) {
        String[] split = str.split("_");
        Queue<String> queue = new LinkedList<>();
        for (String s : split) {
            queue.offer(s);
        }
        return deserialize(queue);
    }

    public TreeNode deserialize(Queue<String> queue) {
        String str = queue.poll();
        if(str == null || "#".equals(str)) {
            return null;
        }
        return new TreeNode(Integer.parseInt(str), deserialize(queue), deserialize(queue));
    }
}
