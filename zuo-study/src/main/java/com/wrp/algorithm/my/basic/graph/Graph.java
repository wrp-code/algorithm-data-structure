package com.wrp.algorithm.my.basic.graph;

import java.util.*;

/**
 * 图
 * @author wrp
 * @since 2025-03-08 17:30
 **/
public class Graph {
    /**
     * key: 节点序号
     * value: 节点信息
     */
    public Map<Integer, Node> nodes;
    /**
     * 所有的边
     */
    public Set<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }

    /**
     * 宽度优先遍历
     * @param node 任意节点
     */
    public void bfs(Node node) {

    }

    /**
     * 深度优先遍历
     * @param node 任意节点
     */
    public void dfs(Node node) {
        if(node == null) return;
        Stack<Node> stack = new Stack<>();
        Set<Node> set = new HashSet<>();
        stack.push(node);
        set.add(node);
        while(!stack.isEmpty()) {
            node = stack.pop();
            System.out.println(node.value);
            for (Node next : node.nexts) {
                if(!set.contains(next)) {
                    stack.push(next);
                    set.add(next);
                }
            }
        }
    }

    /**
     * 拓扑排序
     * 要求有向图，且有入度为0的节点，且没有环
     * @param graph 图
     * @return 排序后的Node集合
     */
    public static List<Node> topologySort(Graph graph) {
        return null;
    }

    /**
     * kruskal最小生成数
     * TODO 并查集实现K算法，获取最小生成树
     * @param graph 图
     * @return 最小生成树的边
     */
    public static Set<Edge> kruskalMST(Graph graph) {

        return null;
    }

    /**
     * prim 最小生成树
     * @param graph 图
     * @return 最小生成树的边
     */
    public static Set<Edge> primMST(Graph graph) {
        return null;
    }

    public static class MyUnionSet {
        public Map<Node, List<Node>> maps = new HashMap<>();

        public static MyUnionSet create(List<Node> nodes) {
            MyUnionSet myUnionSet = new MyUnionSet();
            for (Node node : nodes) {
                List<Node> list = new ArrayList<>();
                list.add(node);
                myUnionSet.maps.put(node, list);
            }
            return myUnionSet;
        }

        public boolean isSame(Node from, Node to) {
            return maps.get(from) == maps.get(to);
        }

        public void union(Node from, Node to) {
            List<Node> fromList = maps.get(from);
            List<Node> toList = maps.get(to);
            for (Node node : toList) {
                fromList.add(node);
                maps.put(node, fromList);
            }
        }
    }

    // 自己实现的用于K算法，有问题。
    // 因为存在两个分开的整体边需要相连，这种情况会导致连接失效。
//    public static class MyUnionSet {
//        public static final Integer PLACE_HOLDER = 0;
//
//        public Map<Node, Integer> maps = new HashMap<>();
//
//        public static MyUnionSet create(List<Node> nodes) {
//            MyUnionSet myUnionSet = new MyUnionSet();
//            for (Node node : nodes) {
//                myUnionSet.maps.put(node, null);
//            }
//            return myUnionSet;
//        }
//
//        public boolean isSame(Node from, Node to) {
//            return maps.get(from) == null || maps.get(to) == null;
//        }
//
//        public void union(Node from, Node to) {
//            maps.put(from, PLACE_HOLDER);
//            maps.put(to, PLACE_HOLDER);
//        }
//    }

}
