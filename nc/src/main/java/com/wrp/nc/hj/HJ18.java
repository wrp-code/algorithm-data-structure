package com.wrp.nc.hj;

import java.util.Scanner;

/**
 * @author wrp
 * @since 2025年02月23日 12:26
 */
public class HJ18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Out out = new Out();

    }

    static class Out {
        int a;
        int b;
        int c;
        int d;
        int e;
        int err;
        int self;

        public void addAIf(String ip, String mask) {
            String[] split = ip.split("\\.");
            for (int i = 0; i < split.length; i++) {
                if(split[i].isEmpty()) {
                    return;
                }
            }
            int num = Integer.parseInt(split[0]);
            if(num >=1 && num <= 126) {
                a++;
            }
        }

        public void addBIf(String ip, String mask) {
            String[] split = ip.split("\\.");
            for (int i = 0; i < split.length; i++) {
                if(split[i].isEmpty()) {
                    return;
                }
            }
            int num = Integer.parseInt(split[0]);
            if(num >=128 && num <= 191) {
                b++;
            }
        }

        public void addCIf(String ip, String mask) {
            String[] split = ip.split("\\.");
            for (int i = 0; i < split.length; i++) {
                if(split[i].isEmpty()) {
                    return;
                }
            }
            int num = Integer.parseInt(split[0]);
            if(num >=192 && num <= 223) {
                c++;
            }
        }

        public void addDIf(String ip, String mask) {
            String[] split = ip.split("\\.");
            for (int i = 0; i < split.length; i++) {
                if(split[i].isEmpty()) {
                    return;
                }
            }
            int num = Integer.parseInt(split[0]);
            if(num >=224 && num <= 239) {
                d++;
            }
        }
        public void addEIf(String ip, String mask) {
            String[] split = ip.split("\\.");
            for (int i = 0; i < split.length; i++) {
                if(split[i].isEmpty()) {
                    return;
                }
            }
            int num = Integer.parseInt(split[0]);
            if(num >=240 && num <= 255) {
                e++;
            }
        }
        public boolean checkAndAddErrMaskIf(String mask) {
            if(mask == null || mask.isEmpty()) {
                err++;
                return false;
            }
            String[] split = mask.split("\\.");
            for (int i = 0; i < split.length; i++) {
                if(split[i] == null || split[i].isEmpty()) {
                    err++;
                    return  false;
                }
            }
            if(split[0].equals("0") || split[0].equals("127")) {
                err++;
                return false;
            }

            return true;
        }
        public void addSelfIf(String ip, String mask) {
            String[] split = ip.split("\\.");
            for (int i = 0; i < split.length; i++) {
                if(split[i].isEmpty()) {
                    return;
                }
            }
            int num = Integer.parseInt(split[0]);
            int num2 = Integer.parseInt(split[1]);
            if(num == 10 || (num == 172 && num2 >= 16 && num2 <=31) ||
                num == 192 && num2 == 168) {
                self++;
            }
        }

        @Override
        public String toString() {
            return a +
                    " " + b +
                    " " + c +
                    " " + d +
                    " " + e +
                    " " + err +
                    " " + self;
        }
    }
}
