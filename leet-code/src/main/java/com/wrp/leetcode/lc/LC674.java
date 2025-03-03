package com.wrp.leetcode.lc;

/**
 * @author wrp
 * @since 2025-03-03 17:24
 **/
public class LC674 {
    public int findLengthOfLCIS(int[] nums) {
        int max = 0;
        int tmp = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] < nums[i + 1]) {
                tmp++;
            } else {
                max = Math.max(max, tmp);
                tmp = 1;
            }
        }
        return max;
    }
}
