package com.wrp.algorithm.my.basic.graph;

/**
 * 图的边
 * @author wrp
 * @since 2025-03-08 17:29
 **/
public class Edge {
    /**
     * 权重
     */
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
