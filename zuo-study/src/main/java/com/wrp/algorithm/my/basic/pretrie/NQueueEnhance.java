package com.wrp.algorithm.my.basic.pretrie;

/**
 * N皇后优化
 * @author wrp
 * @since 2025-03-11 21:04
 **/
public class NQueueEnhance {

    public static int res(int n) {

        if(n < 1 || n >32) {
            return -1;
        }
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process(limit, 0, 0, 0);
    }

    public static int process(int limit, int colLim, int leftDiaLim, int rightDiaLim) {
        if(colLim == limit) {
            return 1;
        }

        int res = 0;
        // 可选位置
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        int mostRightOne = 0;
        while(pos != 0) {// 还有位置可选
            // 选择最右边的位置
            mostRightOne = pos & (~pos + 1);
            // 更新选择后剩余的位置
            pos = pos - mostRightOne;
            // dfs
            res += process(limit,
                    colLim | mostRightOne,// 列限制
                    (leftDiaLim | mostRightOne) << 1,// 左限制
                    (rightDiaLim | mostRightOne) >>> 1// 右限制
            );
        }
        return res;
    }
}
