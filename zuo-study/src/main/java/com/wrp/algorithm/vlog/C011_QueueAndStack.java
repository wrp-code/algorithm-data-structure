package com.wrp.algorithm.vlog;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author wrp
 * @since 2025年03月29日 22:51
 */
public class C011_QueueAndStack {

    public static class Queue1 {
        // 双端队列
        Queue<Integer> queue = new LinkedList<>();

        public boolean isEmpty() {
            return queue.isEmpty();
        }

        public void offer(Integer integer) {
            queue.offer(integer);
        }

        public Integer poll() {
            return queue.poll();
        }

        public Integer peek() {
            return queue.peek();
        }
    }

    public static class Queue2 {
        int[] arr;
        int head;
        int tail;

        public Queue2(int n) {
            arr = new int[n];
            head = 0;
            tail = 0;
        }

        public boolean isEmpty() {
            return head == tail;
        }

        public void offer(Integer integer) {
            arr[tail++] = integer;
        }

        public Integer poll() {
            return arr[head--];
        }

        public Integer peek() {
            return arr[head];
        }

        public int size() {
            return tail - head;
        }
    }

    public static class Stack1 {
        Stack<Integer> stack = new Stack<>();
    }

    public static class Stack2 {
        int[] arr;
        int size;
        public Stack2(int n) {
            arr = new int[n];
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void push(int num) {
            arr[size++] = num;
        }

        public int pop() {
            return arr[--size];
        }

        public int peek() {
            return arr[size - 1];
        }

        public int size(){
            return size;
        }
    }

    public static class MyCircleQueue {
        int[] arr;
        int head;
        int tail;
        int size;
        int limit;

        public MyCircleQueue(int n) {
            arr = new int[n];
            head = 0;
            tail = 0;
            size = 0;
            limit = n;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }

        public boolean enQueue(int num) {
            if(isFull()){
                return false;
            } else {
                arr[tail] = num;
                tail = tail == limit -1 ? 0 : tail + 1;
                size++;
                return true;
            }
        }

        public int deQueue() {
            if(isEmpty()) {
                return -1;
            } else {
                int temp = arr[head];
                head = head == limit - 1 ? 0 : head + 1;
                size--;
                return temp;
            }
        }

        public int front() {
            if(isEmpty()) {
                return -1;
            }
            return arr[head];
        }

        public int tail() {
            if(isEmpty()) {
                return -1;
            }
            int index = tail == 0 ? limit -1 : tail - 1;
            return arr[index];
        }
    }
}
