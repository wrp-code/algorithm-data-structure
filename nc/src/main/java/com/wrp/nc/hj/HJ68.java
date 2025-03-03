package com.wrp.nc.hj;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wrp
 * @since 2025-03-03 16:11
 **/
public class HJ68 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int num = in.nextInt();
        int order = in.nextInt();
        in.nextLine();
        List<Student> students = new LinkedList<>();
        while(in.hasNext()) {
            String s = in.nextLine();
            int idx = s.lastIndexOf(" ");
            students.add(new Student(s.substring(0, idx), Integer.parseInt(s.substring(idx + 1))));
        }

        students.stream().sorted((a,b)-> {
            int res = a.score - b.score;
            return order == 1 ? res : -res;
        }).forEach(System.out::println);
    }

    static class Student {
        String name;
        int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return name + " " + score;
        }
    }
}
