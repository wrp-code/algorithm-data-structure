package com.wrp.algorithm.vlog;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 双端队列：
 * 1. 双向链表实现
 * 2. 固定数组实现
 * @author wrp
 * @since 2025-04-15 19:23
 **/
public class C016_DoubleQueue {

    static class MyCircularDeque1 {
        public Deque<Integer> deque = new LinkedList<>();
        public int limit;

        public MyCircularDeque1(int limit) {
            this.limit = limit;
        }

        public boolean insertFront(int value) {
            if(isFull()) {
                return false;
            }
            deque.offerFirst(value);
            return true;
        }

        public boolean insertLast(int value) {
            if(isFull()) {
                return false;
            }
            deque.offerLast(value);
            return true;
        }

        public boolean deleteFront() {
            if(isEmpty()) {
                return false;
            }
            deque.pollFirst();
            return true;
        }

        public boolean deleteLast() {
            if(isEmpty()) {
                return false;
            }
            deque.pollLast();
            return true;
        }

        public int getFront() {
            return deque.peekFirst();
        }

        public int getRear() {
            return deque.peekLast();
        }

        public int size() {
            return deque.size();
        }

        public boolean isEmpty() {
            return deque.isEmpty();
        }

        public boolean isFull() {
            return deque.size() == limit;
        }
    }

    // 固定数组实现
    static class MyCircularDeque2 {
        int[] data;
        public int size;
        public int limit;
        int r;
        int l;

        public MyCircularDeque2(int limit) {
            size = r = l = 0;
            this.limit = limit;
            data = new int[limit];
        }

        public boolean insertFront(int value) {
            if(isFull()) {
                return false;
            }
            if(isEmpty()) {
                l = r = 0;
            } else {
                l = l==0 ? limit - 1 : l-1;
            }
            data[l] = value;
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if(isFull()) {
                return false;
            }
            if(isEmpty()) {
                l = r = 0;
            } else {
                r = r==limit-1 ? 0 : r + 1;
            }
            data[r] = value;
            size++;
            return true;
        }

        public boolean deleteFront() {
            if(isEmpty()) {
                return false;
            }
            l = l==limit-1 ? 0: l+1;
            size--;
            return true;
        }

        public boolean deleteLast() {
            if(isEmpty()) {
                return false;
            }
            r = r==0 ? limit-1: l-1;
            size--;
            return true;
        }

        public int getFront() {
            if(isEmpty()) {
                return -1;
            }
            return data[l];
        }

        public int getRear() {
            if(isEmpty()) {
                return -1;
            }
            return data[r];
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }
}
