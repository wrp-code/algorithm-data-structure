package com.wrp.algorithm.my.common;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wrp
 * @since 2025-03-05 21:06
 **/
public class QueueTest {
    @Test
    public void add() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        while(!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }

    @Test
    public void offer() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
