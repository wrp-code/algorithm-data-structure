package com.wrp.nc.bh;

/**
 * @author wrp
 * @since 2025-03-04 19:47
 **/
public class BH6 {
    public static void main(String[] args) {
        System.out.println(screenEnd("111"));
    }

    public static int screenEnd(String s) {
        String screen = "";
        String clip = "";
        boolean select = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // a -> 1
            if(ch == '1') {
                if(select) {
                    screen = "a";
                } else {
                    screen += "a";
                }
            }
            // ctrl + c -> 2
            else if(ch == '2' && select) {
                clip = screen;
            }
            // // ctrl + x -> 3
            else if(ch == '3' && select) {
                select = false;
                clip = screen;
                screen = "";
            }
            // ctrl + v -> 4
            else if(ch == '4') {
                if(select) {
                    screen = clip;
                } else {
                    screen += clip;
                }
            }
            // ctrl + a -> 5
            else if(ch == '5') {
                select = true;
            }
        }

        return screen.length();
    }
}
