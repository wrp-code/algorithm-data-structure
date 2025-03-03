package com.wrp.leetcode.ms;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wrp
 * @since 2025-03-03 16:57
 **/
public class MS0808 {
    Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        new MS0808().permutation("qqe");
        System.out.println();
    }

    public String[] permutation(String S) {
        search(S.toCharArray(), 0);
        return set.toArray(new String[0]);
    }

    public void search(char[] arr, int idx) {
        if(idx == arr.length) {
            set.add(new String(arr));
            return;
        }

        Set<Character> used = new HashSet<>();
        for (int i = idx; i < arr.length; i++) {
            if(!used.contains(arr[i])) {
                used.add(arr[i]);
                swap(arr, i, idx);
                search(arr, i+ 1);
                swap(arr,i, idx);
            }
        }
    }

    public void swap(char[] arr, int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
