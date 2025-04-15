package com.wrp.algorithm.my.improve;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wrp
 * @since 2025年04月07日 7:57
 */
public class SingleStack {

    record MaxInfo(int curIdx, int leftNearMaxIdx, int rightNearMaxIdx){}

    public static List<MaxInfo> getMaxInfo(int[] arr) {
        Stack<Integer> data = new Stack<>();
        List<MaxInfo> maxInfos = new ArrayList<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            while(data.isEmpty() || arr[data.peek()] > arr[i]) {
                data.push(i);
            }
            int curIdx = data.pop();
            maxInfos.add(new MaxInfo(curIdx, data.isEmpty() ? -1 : data.peek(),i));
            data.push(i);
        }

        while(!data.isEmpty()) {
            Integer curIdx = data.pop();
            maxInfos.add(new MaxInfo(curIdx, data.isEmpty() ? -1 : data.peek(), -1));
        }

        return maxInfos;
    }
}
