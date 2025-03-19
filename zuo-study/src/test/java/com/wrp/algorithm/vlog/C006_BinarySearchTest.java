package com.wrp.algorithm.vlog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


/**
 * @author wrp
 * @since 2025-03-18 23:35
 **/
class C006_BinarySearchTest {

    int n = 100;
    int v = 1000;
    int test = 10000;

    @Test
    void exist() {
        int[] arr;
        int[] copyArr;
        for (int i = 0; i < test; i++) {
            int r = (int) (Math.random() * n);
            int num = (int) (Math.random() * v);
            arr = C005_Validator.randomArray(r, v);
            Arrays.sort(arr);
            copyArr = C005_Validator.copyArray(arr);
            if(C006_BinarySearch.existX(arr, num) !=
                    C006_BinarySearch.exist(copyArr, num)) {
                C005_Validator.printArray(arr);
                System.out.println(num);
            }
            Assertions.assertEquals(C006_BinarySearch.existX(arr, num),
                    C006_BinarySearch.exist(copyArr, num));
        }
    }

    @Test
    void findLeft() {
        int[] arr;
        int[] copyArr;
        for (int i = 0; i < test; i++) {
            int r = (int) (Math.random() * n);
            int num = (int) (Math.random() * v);
            arr = C005_Validator.randomArray(r, v);
            Arrays.sort(arr);
            copyArr = C005_Validator.copyArray(arr);
            if(C006_BinarySearch.findLeftX(arr, num) !=
                    C006_BinarySearch.findLeft(copyArr, num)) {
                C005_Validator.printArray(arr);
                System.out.println(num);
            }
            Assertions.assertEquals(C006_BinarySearch.findLeftX(arr, num),
                    C006_BinarySearch.findLeft(copyArr, num));
        }
    }

    @Test
    void findLeftM() {
        int[] arr = {79,239,652};
        int num = 440;
        C006_BinarySearch.findLeft(arr, num);
    }

    @Test
    void findRight() {
        int[] arr;
        int[] copyArr;
        for (int i = 0; i < test; i++) {
            int r = (int) (Math.random() * n);
            int num = (int) (Math.random() * v);
            arr = C005_Validator.randomArray(r, v);
            Arrays.sort(arr);
            copyArr = C005_Validator.copyArray(arr);
            if(C006_BinarySearch.findRightX(arr, num) !=
                    C006_BinarySearch.findRight(copyArr, num)) {
                C005_Validator.printArray(arr);
                System.out.println(num);
            }
            Assertions.assertEquals(C006_BinarySearch.findRightX(arr, num),
                    C006_BinarySearch.findRight(copyArr, num));
        }
    }

    @Test
    void findRightM() {
        int[] arr = {3,26,57,116,139,189,263,355,391,457,518,534,575,659,762,898,958,997};
        int num = 990;
        C006_BinarySearch.findRightX(arr, num);
    }
}