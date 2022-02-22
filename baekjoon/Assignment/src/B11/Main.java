package B11;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int L, C;
	static boolean[] check, isMo;
	static char[] input, mos = {'a', 'e', 'i', 'o', 'u'};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		L = sc.nextInt();
		C = sc.nextInt();
		
		// 그냥 조합 문제다 배웠던 데로 하면 그냥 풀리는 문제인줄 알았지만 최소 하나의 모음과 두개의 자음은 가지고 있어야 하는 문제 였음
		
		input = new char[C];
		check = new boolean[C]; 
		isMo = new boolean[C]; 
		for(int i = 0; i < C; i++) {
			input[i] = sc.next().charAt(0);
		}
		
		Arrays.sort(input); // 조합을 살리기 위해서 sorting을 해서 처리함
		for(int i = 0; i < C; i++) {
			char c = input[i];
			if(c == mos[0]||c == mos[1]||c == mos[2]||c == mos[3]||c == mos[4]) {
				isMo[i] = true; // 맨날 모음인거 처리하기 싫어서 배열을 하나 더 만들어서 처리 했다.
			}
		}
		
		check = new boolean[C]; 
		combination(0, 0, 0);
		System.out.println(sb.toString());
	}

	public static void combination(int mo, int ja, int now) { // 모음수 자음수도 count해서 처리하자

		if(mo + ja == L && mo >= 1 && ja >= 2) {
			for(int i = 0; i < C;i++) {
				if(check[i]) sb.append(input[i]);
			}
			sb.append("\n");
			return;
		} else if(mo + ja > L || now >= C) {
			return;
		}
		
		if(isMo[now]) {
			check[now] = true;
			combination(mo + 1, ja, now + 1);
			check[now] = false;
			combination(mo, ja, now + 1);
		} else {
			check[now] = true;
			combination(mo, ja + 1, now + 1);
			check[now] = false;
			combination(mo, ja, now + 1);
		}
	}
}
