package com.wrp.algorithm.my.improve;

/**
 * @author wrp
 * @since 2025-04-01 20:46
 **/
public class Manacher {


    public int maxReversibleTextLength(String str) {
        if(str == null || str.isEmpty()) {
            return 0;
        }

        String manacherStr = getManagerString(str);
        int r = -1;// 最大回文右边界的下一个位置
        int c = -1;// 最大回文中心点
        int[] arr = new int[manacherStr.length()];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < manacherStr.length(); i++) {
            // 不用验证的半径
            // 2 * c - i, i'彻底在r'范围内
            // r - i，i'刚好在r范围边上
            // 1，暴力扩，排除自己
            arr[i] = r > i ? Math.min(arr[2 * c - i], r - i) : 1;

            // 往外扩
            while(i + arr[i] < manacherStr.length() && i - arr[i] > - 1) {
                if(manacherStr.charAt(i + arr[i]) != manacherStr.charAt(i - arr[i])) {
                    break;
                }
                arr[i]++;
            }

            // 如果回文右边界比之前大，则更新
            if(i+arr[i] > r) {
                r = i + arr[i];
                c = i;
            }
            max = Math.max(max, arr[i]);
        }

        return max - 1;
    }

    private String getManagerString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append("#").append(str.charAt(i));
        }
        return sb.append("#").toString();
    }
}
