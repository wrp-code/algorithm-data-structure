package com.wrp.algorithm.my.basic.recursive;

/**
 * @author wrp
 * @since 2025-03-17 21:30
 **/
public class MaxValueInWeight {

    public static int maxValue(int[] weights, int[] values, int rag) {
        return process(weights, values, 0, 0, rag);
    }

    public static int process(int[] weights, int[] values, int idx, int alreadyWeight, int rag) {
        // 超出包的重量
        if(alreadyWeight > rag) {
            return 0;
        }

        if(idx == weights.length) {
            // 此位置已经拿不到价值了
            return 0;
        }

        return Math.max(process(weights, values, idx + 1, alreadyWeight, rag),
                values[idx] + process(weights, values, idx + 1, alreadyWeight + weights[idx], rag));
    }
}
