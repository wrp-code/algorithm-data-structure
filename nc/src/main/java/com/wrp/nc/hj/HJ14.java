package com.wrp.nc.hj;

    import java.util.*;

/**
 * @author wrp
 * @since 2025年02月21日 23:48
 */
public class HJ14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.next());
        }
        list.stream().sorted((a,b) -> {
            int l1 = a.length();
            int l2 = b.length();
                    for (int i = 0; i < Math.min(l1, l2); i++) {
                        char c1 = a.charAt(i);
                        char c2 = b.charAt(i);
                        if(c1 > c2) {
                            return 1;
                        }else if(c1 < c2) {
                            return -1;
                        }
                    }
                    if(l1 > l2) {
                        return 1;
                    } else {
                        return -1;
                    }
                })
                .forEach(System.out::println);
    }
}
