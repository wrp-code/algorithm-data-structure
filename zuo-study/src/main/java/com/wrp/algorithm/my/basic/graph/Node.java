package com.wrp.algorithm.my.basic.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 图的节点
 * @author wrp
 * @since 2025-03-08 17:25
 **/
public class Node {
    /**
     * 点的值，或者点的序号
     */
    public int value;
    /**
     * 出度
     */
    public int in;
    /**
     * 入度
     */
    public int out;
    /**
     * 由当前点发散出去的边所在的终点
     */
    public List<Node> nexts;
    /**
     * 由当前节点发散出去的所有边
     */
    public List<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
