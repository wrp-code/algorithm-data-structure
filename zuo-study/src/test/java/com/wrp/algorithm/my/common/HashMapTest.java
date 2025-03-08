package com.wrp.algorithm.my.common;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.HashMap;

/**
 * @author wrp
 * @since 2025-02-23 17:36
 **/
public class HashMapTest {

    @Test
    public void test1() {
        HashMap<String, Object> map = new HashMap<>();
        String str = "abc";
        Object obj = new Object();
        map.put(str, obj);
        map.forEach((key, value) -> Assert.isTrue(key.equals(str), "String不会拷贝"));
    }

    @Test
    public void test2() {
        HashMap<Integer, Object> map = new HashMap<>();
        Integer num = 300;
        Object obj = new Object();
        map.put(num, obj);
        map.forEach((key, value) -> Assert.isTrue(key.equals(num), "Integer不会拷贝"));
    }

    @Test
    public void test3() {
        HashMap<Integer, Integer> map = new HashMap<>();
        int a = map.get(1);
        System.out.println(a);
    }
}
