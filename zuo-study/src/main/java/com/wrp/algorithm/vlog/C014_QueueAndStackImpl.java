package com.wrp.algorithm.vlog;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 栈和队列相互实现
 * @author wrp
 * @since 2025-03-31 07:29
 **/
public class C014_QueueAndStackImpl {

    public static class MyQueue {
        Stack<Integer> in;
        Stack<Integer> out;

        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        public void inToOut() {
            if(!out.isEmpty()) return;

            while(!in.isEmpty()) {
                out.push(in.pop());
            }
        }

        public void push(int x) {
            in.push(x);
            inToOut();
        }

        public int pop() {
            inToOut();
            return out.pop();
        }

        public int peek() {
            inToOut();
            return out.peek();
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }

    public static class MyStack {
        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        // O(N)
        public void push(int x) {
            int size = queue.size();
            queue.offer(x);
            for (int i = 0; i < size; i++) {
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int peek() {
            return queue.peek();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }
}
