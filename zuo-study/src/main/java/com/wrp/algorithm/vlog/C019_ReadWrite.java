package com.wrp.algorithm.vlog;

import java.io.*;

/**
 * @author wrp
 * @since 2025-05-06 21:55
 **/
public class C019_ReadWrite {

    public static void main(String[] args) throws IOException {
        // 一次性读取所有测试用例
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 一个一个读数字
        StreamTokenizer st = new StreamTokenizer(br);

        // 缓存输出，一次性写出
        PrintWriter out = new PrintWriter(System.out);
        while(st.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int)st.nval;
            st.nextToken();
            int m = (int) st.nval;

            out.println("xxx");
        }
        // 一次性写出
        out.flush();
        out.close();
    }
}
