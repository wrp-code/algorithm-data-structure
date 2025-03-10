package com.wrp.algorithm.my.basic.pretrie;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀树节点
 * @author wrp
 * @since 2025-03-10 19:19
 **/
public class TrieNode {
    public int pass;
    public int end;
    public Map<Character, TrieNode> nexts;// TrieNode[] nexts;字符不多时可以用

    public TrieNode() {
        pass = 0;
        end = 0;
        nexts = new HashMap<>();
    }
}
