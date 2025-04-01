package com.wrp.algorithm.my.improve;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wrp
 * @since 2025-04-01 21:17
 **/
public class SlidingWindowMaxArray {



    public int[] maxArray(int[] data, int width) {
        if(data == null || data.length < width){
            return new int[0];
        }
        // 存储窗口内最大值的下标
        List<Integer> list = new LinkedList<>();
        int[] maxArray = new int[data.length];
        for (int i = width; i < data.length; i++) {
            // 删除比当前值小的所有
            while(!list.isEmpty() && data[list.getLast()] <= data[i]) {
                list.removeLast();
            }
            list.addLast(i);
            // 判断是否国旗
            if(i - width == list.getFirst()) {
                list.removeFirst();
            }
            // 过滤前w-1个最大值
            if(i >= width - 1) {
                maxArray[i] = list.getFirst();
            }
        }
        return maxArray;
    }
}
