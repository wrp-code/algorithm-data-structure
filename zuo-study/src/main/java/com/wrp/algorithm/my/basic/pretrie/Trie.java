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

    }
    //统计word个数
    public int searchCount(String word) {
        return 0;
    }

    // 统计前缀个数
    public int preCount(String prefix) {
        return 0;
    }

    // 删除字符
    public void delete(String word) {
        // 需要先检查

        // 如果删除后，出现pass == 0，需要删除当前节点

    }
}
