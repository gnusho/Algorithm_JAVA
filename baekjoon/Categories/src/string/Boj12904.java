package string;

import java.util.Scanner;

public class Boj12904 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String S = sc.next();
		String T = sc.next();
		StringBuilder sb = new StringBuilder(T);
		
		// 거꾸로하면 쉽다는게 명확한 상황이다
		while(sb.length() > S.length()) {
			
			if(sb.charAt(sb.length() - 1) == 'A') {
				sb.setLength(sb.length() - 1);
			} else if(sb.charAt(sb.length() - 1) == 'B') {
				sb.setLength(sb.length() - 1);
				sb.reverse();// sb를 걍 뒤집어줌 따로 할당할 필요 X
			}	
		}
		
		if(S.equals(sb.toString())) System.out.println(1);
		else System.out.println(0);
	}

}
