package com.wrp.algorithm.vlog;

import java.util.Arrays;

/**
 * 基尼系数
 * @author wrp
 * @since 2025-03-17 08:16
 **/
public class C001_Gini {

    public static void main(String[] args) {
        int personCount = 100;
        int initMoney = 100;
        int circleCount = 100000;
        int[] wealth = generate(personCount, initMoney, circleCount);
        double gini = calculateGini(wealth);
        System.out.println(gini);
    }

    /**
     * 生成财富数组
     * @param personCount 人数
     * @param initMoney 初始金额
     * @param circleCount 循环次数
     * @return 循环指定次数后，所有人的金额
     */
    public static int[] generate(int personCount, int initMoney, int circleCount) {
        int[] arr = new int[personCount];
        Arrays.fill(arr, initMoney);

        for (int i = 0; i < circleCount; i++) {
            for (int j = 0; j < personCount; j++) {
                if(arr[j] == 0) {
                    continue;
                }

                int otherIndex;
                do {
                    otherIndex = (int) (Math.random() * personCount);
                } while (otherIndex == j);

                arr[j]--;
                arr[otherIndex]++;
            }
        }

        return arr;
    }

    /**
     * 计算基尼系数
     * @param arr 财富数组
     * @return 基尼系数 [0，1]， 越大财富越不均匀
     */
    public static double calculateGini(int[] arr) {
        double sumOfWealth = 0;
        double sumOfAbsoluteDifference = 0;
        for (int k : arr) {
            sumOfWealth += k;
            for (int i : arr) {
                sumOfAbsoluteDifference += Math.abs(k - i);
            }
        }

        return sumOfAbsoluteDifference / (2 * arr.length * sumOfWealth);
    }
}
