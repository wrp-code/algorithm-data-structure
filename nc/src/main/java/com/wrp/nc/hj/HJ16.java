package com.wrp.nc.hj;

import java.util.*;

/**
 * @author wrp
 * @since 2025年02月22日 10:16
 */
public class HJ16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int money = in.nextInt();
        int count = in.nextInt();
        List<Product> products = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            products.add(new Product(in.nextInt(), in.nextInt(), in.nextInt()));
        }

//        int money =50;
//        List<Product> products = new ArrayList<>();
//        products.add(new Product(20, 3, 5));
//        products.add(new Product(20, 3, 5));
//        products.add(new Product(10, 3, 0));
//        products.add(new Product(10, 2, 0));
//        products.add(new Product(10, 1, 0));
        products.forEach(product -> {
            if(product.mainId != 0) {
                Product main = products.get(product.mainId - 1);
                if(main.p1 == null) {
                    main.p1 = product;
                } else {
                    main.p2 = product;
                }
            }
        });
        // 所有主件
        List<Product> list = products.stream().filter(product -> product.mainId != 0).toList();

        int[] dp = new int[money + 1];
        for (Product product : list) {
            for (int j = money; j > 0; j--) {
                if (j >= product.price) {
                    dp[j] = Math.max(dp[j], dp[j - product.price] + product.value());
                }
                if (product.p1 != null && j >= product.price + product.p1.price) {
                    dp[j] = Math.max(dp[j], dp[j - product.price - product.p1.price] + product.value() + product.p1.value());
                }
                if (product.p2 != null && j >= product.price + product.p2.price) {
                    dp[j] = Math.max(dp[j], dp[j - product.price - product.p2.price] + product.value() + product.p2.value());
                }
                if (product.p1 != null && product.p2 != null && j >= product.price + product.p1.price + product.p2.price) {
                    dp[j] = Math.max(dp[j], dp[j - product.price - product.p1.price - product.p2.price] + product.value() + product.p1.value() + product.p2.value());
                }
            }
        }
        System.out.println(dp[money]);
    }

    static class Product {
        int price;
        // 满意度
        int ok;
        int mainId;
        // 附件1
        Product p1;
        // 附件2
        Product p2;

        public Product(int price, int ok, int mainId) {
            this.price = price;
            this.ok = ok;
            this.mainId = mainId;
        }

        public int value() {
            return ok * price;
        }
    }
}
