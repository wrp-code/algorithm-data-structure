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
     * 采用队列
     * @param node 任意节点
     */
    public void bfs(Node node) {
        if(node == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        Set<Node> visitedNodes = new HashSet<>();
        queue.offer(node);
        visitedNodes.add(node);
        while(!queue.isEmpty()) {
            node = queue.poll();
            System.out.println(node.value);
            for (Node next : node.nexts) {
                if(!visitedNodes.contains(next)) {
                    queue.offer(next);
                    visitedNodes.add(next);
                }
            }
        }
    }

    /**
     * 深度优先遍历
     * 采用栈
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
        // node对应的入度in
        Map<Node, Integer> inMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        graph.nodes.forEach((k,v) -> {
            inMap.put(v, v.in);
            if(v.in == 0) {
                queue.offer(v);
            }
        });

        List<Node> nodes = new ArrayList<>();
        Node zeroInNode;
        while(!queue.isEmpty()) {
            zeroInNode = queue.poll();
            nodes.add(zeroInNode);
            for (Node next : zeroInNode.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if(inMap.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }
        return nodes;
    }

    public static List<Node> topologySortMy(Graph graph) {
        // node对应的入度in
        Map<Node, Integer> inMap = new HashMap<>();
        graph.nodes.forEach((k,v) -> inMap.put(v, v.in));

        List<Node> nodes = new ArrayList<>();
        Node zeroInNode;
        while((zeroInNode = getZeroInNode(inMap)) != null) {
            nodes.add(zeroInNode);
            for (Node next : zeroInNode.nexts) {
                inMap.put(next, inMap.get(next) - 1);
            }
        }
        return nodes;
    }

    private static Node getZeroInNode(Map<Node, Integer> inMap) {
        Node res = null;
        for (Node node : inMap.keySet()) {
            if(inMap.get(node) == 0) {
                res = node;
                break;
            }
        }
        if(res != null) {
            inMap.remove(res);
        }
        return res;
    }

    /**
     * kruskal最小生成数
     * 从边考虑，每次找到最小的一个边
     * TODO 并查集实现K算法，获取最小生成树
     * @param graph 图
     * @return 最小生成树的边
     */
    public static Set<Edge> kruskalMST(Graph graph) {
        MyUnionSet myUnionSet = MyUnionSet.create(graph.nodes.values());
        PriorityQueue<Edge> queue = new PriorityQueue<>(GraphEdgeComparator.INSTANCE);
        graph.edges.forEach(queue::offer);
        Set<Edge> res = new HashSet<>();
        while(!queue.isEmpty()) {
            Edge edge = queue.poll();
            if(!myUnionSet.isSame(edge.from, edge.to)) {
                res.add(edge);
                myUnionSet.union(edge.from, edge.to);
            }
        }
        return res;
    }

    public static class GraphEdgeComparator implements Comparator<Edge> {

        public static final Comparator<Edge> INSTANCE = new GraphEdgeComparator();

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    /**
     * prim 最小生成树
     * 从点出发，
     * @param graph 图
     * @return 最小生成树的边
     */
    public static Set<Edge> primMST(Graph graph) {
        Queue<Edge> queue = new PriorityQueue<>(GraphEdgeComparator.INSTANCE);
        Set<Node> visitedSet = new HashSet<>();
        Set<Edge> res = new HashSet<>();
        for (Node node : graph.nodes.values()) {
            if(!visitedSet.contains(node)) {
                visitedSet.add(node);
                node.edges.forEach(queue::offer);

                while(!queue.isEmpty()) {
                    Edge edge = queue.poll();
                    Node toNode = edge.to;
                    if(!visitedSet.contains(toNode)) {
                        toNode.edges.forEach(queue::offer);
                        visitedSet.add(toNode);
                        res.add(edge);
                    }
                }
            }
        }

        return res;
    }

    /**
     * dijkstra算法求指定节点到其他所有节点的最小距离
     * @param node 指定节点
     * @return 所有节点的最小距离
     */
    public static Map<Node, Integer> dijkstra(Node node) {
        Map<Node, Integer> res = new HashMap<>();
        res.put(node, 0);


        return res;
    }

    public static class MyUnionSet {
        public Map<Node, List<Node>> maps = new HashMap<>();

        public static MyUnionSet create(Collection<Node> nodes) {
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
