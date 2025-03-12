package com.wrp.algorithm.my.common;


/**
 * @author wrp
 * @since 2025-03-12 19:52
 **/
public class CharTest {

    public static void main(String[] args) {
        char[] ch = new char[3];
        ch[0] = 'a';
        ch[1] = 0;
        ch[2] = 'c';
        System.out.println(String.valueOf(ch));//a c
        for (int i = 0; i < ch.length; i++) {
            if(ch[i] == 0) {
                continue;
            }
            System.out.print(ch[i]);//a 0 c
        }

        char c = '王';
        System.out.println(c);
    }
}
