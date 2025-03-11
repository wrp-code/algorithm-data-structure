package com.wrp.algorithm.my.basic.pretrie;

/**
 * @author wrp
 * @since 2025-03-10 19:22
 **/
public class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // 插入
    public void insert(String word) {
        if(word == null) return;
        char[] arr = word.toCharArray();

        TrieNode node = root;
        node.pass++;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if(!node.nexts.containsKey(c)) {
                node.nexts.put(c, new TrieNode());
            }

            node = node.nexts.get(c);
            node.pass++;
        }

        node.end++;
    }
    //统计word个数
    public int searchCount(String word) {
        if(word == null) return 0;
        char[] arr = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if(!node.nexts.containsKey(c)) {
                return 0;
            }
            node = node.nexts.get(c);
        }
        return node.end;
    }

    // 统计前缀个数
    public int preCount(String prefix) {
        if(prefix == null) return 0;
        char[] arr = prefix.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if(!node.nexts.containsKey(c)) {
                return 0;
            }
            node = node.nexts.get(c);
        }
        return node.pass;
    }

    // 删除字符
    public void delete(String word) {
        // 需要先检查
        if(searchCount(word) == 0) {
            return;
        }

        // 如果删除后，出现pass == 0，需要删除当前节点
        char[] arr = word.toCharArray();
        TrieNode node = root;
        node.pass--;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if(--node.nexts.get(c).pass == 0) {
                node.nexts.remove(c);
                return;
            }
            node = node.nexts.get(c);
        }
        node.end--;
    }
}
