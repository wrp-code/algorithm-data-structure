package com.wrp.algorithm.my.basic.pretrie;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wrp
 * @since 2025-03-11 08:20
 **/
public class MostProfits {

    public record Program(int c, int p) {}

    public int mostProfile(int m, int k, int[] programs, int[] profits) {
        Queue<Program> custQueue = new PriorityQueue<>((o1, o2) -> o1.c - o2.c);
        Queue<Program> profitsQueue = new PriorityQueue<>((o1, o2) -> o2.p - o1.p);
        for (int i = 0; i < programs.length; i++) {
            custQueue.add(new Program(programs[i], profits[i]));
        }
        while(k-- > 0) {
            while(!custQueue.isEmpty() && custQueue.peek().c <= m) {
                profitsQueue.add(custQueue.poll());
            }

            if(!profitsQueue.isEmpty()) {
                m += profitsQueue.poll().p;
            }
        }
        return m;
    }
}
