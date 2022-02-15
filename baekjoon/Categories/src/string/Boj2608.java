package string;

import java.util.Scanner;

public class Boj2608 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		
		int ret = func(a) + func(b);
		System.out.println(ret);
		System.out.println(function(ret));
	}

	public static int func(String x) {
		int sum = 0;
		
		for(int i = 0; i < x.length(); i++) {
			if(x.charAt(i) == 'I') {
				if(i + 1 < x.length() && x.charAt(i + 1) == 'V') {
					sum += 4;
					i++;
				} else if(i + 1 < x.length() && x.charAt(i + 1) == 'X') {
					sum += 9;
					i++;
				}
				else sum += 1;
			} else if(x.charAt(i) == 'V') {
				sum += 5;
			} else if(x.charAt(i) == 'X') {
				if(i + 1 < x.length() && x.charAt(i + 1) == 'L') {
					sum += 40;
					i++;
				} else if(i + 1 < x.length() && x.charAt(i + 1) == 'C') {
					sum += 90;
					i++;
				}
				else sum += 10;
			} else if(x.charAt(i) == 'L') {
				sum += 50;
			} else if(x.charAt(i) == 'C') {
				if(i + 1 < x.length() && x.charAt(i + 1) == 'D') {
					sum += 400;
					i++;
				} else if(i + 1 < x.length() && x.charAt(i + 1) == 'M') {
					sum += 900;
					i++;
				}
				else sum += 100;
			} else if(x.charAt(i) == 'D') {
				sum += 500;
			} else if(x.charAt(i) == 'M') {
				sum += 1000;
			} 
			
		}
			
		return sum;
	}
	
	public static StringBuilder function(int x) {
		StringBuilder sb = new StringBuilder();
		// 1000의 경우는 얄짤이 없다 무조건 M으로 처리된다.
		for(int i = 0; i < x/1000; i++) sb.append('M');
		x %= 1000;
		// 100 단위를 보자 다음과 같다
		/*
		 * 100 -> C 200 -> CC 300 -> CCC
		 * 400 -> CD 500 -> D
		 * 600 -> DC 700 -> DCC 800 -> DCCC
		 * 900 -> CM
		 * 이걸 싹다 처리하는게 맞는듯 하다.
		 */
		int tmp = x/100;
		if(tmp < 4) {
			for(int i = 0; i < tmp; i++) sb.append('C');
		} else if(tmp == 4) {
			sb.append("CD");
		} else if(tmp < 9){
			sb.append('D');
			for(int i = 0; i < tmp - 5; i++) sb.append('C');
		} else if(tmp == 9) {
			sb.append("CM");
		}
		x %= 100;
		// 10 단위를 보자 다음과 같다
		/*
		 * 10 -> X 20 -> XX 30 -> XXX
		 * 40 -> XL 50 -> L
		 * 60 -> LX 70 -> LXX 80 -> LXXX
		 * 90 -> XC
		 */
		tmp = x/10;
		if(tmp < 4) {
			for(int i = 0; i < tmp; i++) sb.append('X');
		} else if(tmp == 4) {
			sb.append("XL");
		} else if(tmp < 9){
			sb.append('L');
			for(int i = 0; i < tmp - 5; i++) sb.append('X');
		} else if(tmp == 9) {
			sb.append("XC");
		}
		x %= 10;
		// 1 단위를 보자 다음과 같다
		/*
		 * 1 -> I 2 -> II 3 -> III
		 * 4 -> IV 5 -> V
		 * 6 -> VI 7 -> VII 8 -> VIII
		 * 9 -> IX
		 */
		tmp = x/1;
		if(tmp < 4) {
			for(int i = 0; i < tmp; i++) sb.append('I');
		} else if(tmp == 4) {
			sb.append("IV");
		} else if(tmp < 9){
			sb.append('V');
			for(int i = 0; i < tmp - 5; i++) sb.append('I');
		} else if(tmp == 9) {
			sb.append("IX");
		}
		return sb;
	}
	
}
