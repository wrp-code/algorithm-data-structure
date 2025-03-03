package com.wrp.nc.hj;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wrp
 * @since 2025-03-03 17:50
 **/
public class HJ41 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int count = in.nextInt();
        List<Fm> fms = new ArrayList<>();
        for (int i = 0; i < count; i++){ // 注意 while 处理多个 case
            fms.add(new Fm(in.nextInt()));
        }
        for (int i = 0; i < count; i++){ // 注意 while 处理多个 case
            fms.get(i).num = in.nextInt();
        }

        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 0; i < fms.size(); i++) {
            Fm fm = fms.get(i);
            set.addAll(set.stream().flatMap(num-> {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j <= fm.num; j++) {
                    list.add(fm.weight * j + num);
                }
                return list.stream();
            }).collect(Collectors.toSet()));
        }
        System.out.println(set.size());
    }


    static class Fm {
        int weight;
        int num;

        public Fm(int weight) {
            this.weight = weight;
        }

        public Fm(int weight, int num) {
            this.weight = weight;
            this.num = num;
        }
    }
}
