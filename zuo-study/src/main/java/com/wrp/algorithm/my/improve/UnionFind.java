package com.wrp.algorithm.my.improve;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 并查集， 1964年发明，1984年
 * @author wrp
 * @since 2025-03-30 10:01
 **/
public class UnionFind {

    public static class Element<V> {
        V value;

        public Element(V value) {
            this.value = value;
        }
    }

    public static class UnionFindSet<V> {
        // 原数据，与包装数据的对应关系
        Map<V, Element<V>> nodes;
        // 包装数据与 父节点的对应
        Map<Element<V>, Element<V>> fathers;
        // 父节点的大小
        Map<Element<V>, Integer> counts;

        public UnionFindSet(List<V> list) {
            nodes = new HashMap<>();
            fathers = new HashMap<>();
            counts = new HashMap<>();

            for (V v : list) {
                Element<V> element = new Element<>(v);
                nodes.put(v, element);
                fathers.put(element, element);
                counts.put(element, 1);
            }
        }

        // 数据必须要求被注册过
        public boolean isSameSet(V a, V b) {
            if(!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return false;
            }
            return fathers.get(nodes.get(a)) == fathers.get(nodes.get(b));
        }

        // 合并两个数据在同一个集合中
        public void union(V a, V b) {
            if(!nodes.containsKey(a) || !nodes.containsKey(b) || isSameSet(a, b)) {
                return;
            }

            Element<V> aF = fathers.get(nodes.get(a));
            Element<V> bF = fathers.get(nodes.get(b));
            Element<V> big = counts.get(aF) >= counts.get(bF) ? aF : bF;
            Element<V> small = aF == big ? bF : aF;
            fathers.put(small, big);
            counts.put(big, counts.get(small) + counts.get(big));
            // 不再需要small了
            fathers.remove(small);
        }

        // 查询a数据的父节点 ， 由扁平化处理优化
        private Element<V> findHead(V a) {
            if(!nodes.containsKey(a)) {
                return null;
            }
            Stack<Element<V>> stack = new Stack<>();
            Element<V> element = nodes.get(a);
            while(element != fathers.get(element)) {
                stack.push(element);
                element = fathers.get(element);
            }

            // 扁平化处理，防止 a找父节点的路径太长
            while(!stack.isEmpty()) {
                fathers.put(stack.pop(), element);
            }

            return element;
        }
    }
}
