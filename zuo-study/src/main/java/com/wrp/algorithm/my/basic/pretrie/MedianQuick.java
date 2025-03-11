package com.wrp.algorithm.my.basic.pretrie;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wrp
 * @since 2025-03-11 20:50
 **/
public class MedianQuick {
    Queue<Integer> minQ = new PriorityQueue<>();
    Queue<Integer> maxQ = new PriorityQueue<>((a, b) -> b - a);


    public void add(int num) {
        if (maxQ.isEmpty() || num <= maxQ.peek()) {
            maxQ.add(num);
        } else {
            minQ.add(num);
        }

        if(maxQ.size() == minQ.size() + 2){
            minQ.add(maxQ.poll());
        }
        if(minQ.size() == maxQ.size() + 2){
            maxQ.add(minQ.poll());
        }
    }

    public int getMedian() {
        if(minQ.isEmpty() && maxQ.isEmpty()){
            return -1;
        }
        int minS = minQ.size();
        int maxS = maxQ.size();
        if(((maxS + minS) & 1) == 0) {
            return (minQ.peek() + maxQ.peek()) / 2;
        }
        return minS > maxS ? minQ.peek() : maxQ.peek();
    }
}
