package com.wrp.algorithm.my.basic.pretrie;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wrp
 * @since 2025-03-11 08:15
 **/
public class LowestMoneySplitGold {
    public int minMoney(int[] arr) {
        if(arr == null || arr.length <= 1) {
            return 0;
        }
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }
        int res = 0;
//        while(!queue.isEmpty()) {
        // 仅有一个数时，不需要再分
        while(queue.size() > 1) {
            Integer a = queue.poll();
            Integer b = queue.poll();
            res += a + b;
            queue.offer(a + b);
        }
        return res;
    }
}
