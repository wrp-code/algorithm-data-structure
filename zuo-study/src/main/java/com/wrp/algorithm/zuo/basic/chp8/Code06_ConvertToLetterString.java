package com.wrp.algorithm.zuo.basic.chp8;

import com.wrp.algorithm.my.basic.recursive.ConvertLetterResult;

public class Code06_ConvertToLetterString {

	public static int number(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		return process(str.toCharArray(), 0);
	}

	public static int process(char[] chs, int i) {
		if (i == chs.length) {
			return 1;
		}
		if (chs[i] == '0') {
			return 0;
		}
		if (chs[i] == '1') {
			int res = process(chs, i + 1);
			if (i + 1 < chs.length) {
				res += process(chs, i + 2);
			}
			return res;
		}
		if (chs[i] == '2') {
			int res = process(chs, i + 1);
			if (i + 1 < chs.length && (chs[i + 1] >= '0' && chs[i + 1] <= '6')) {
				res += process(chs, i + 2);
			}
			return res;
		}
		return process(chs, i + 1);
	}

	public static void main(String[] args) {
		String number = "11111";
		System.out.println(number(number));
		System.out.println(ConvertLetterResult.convert(number));
	}

}
