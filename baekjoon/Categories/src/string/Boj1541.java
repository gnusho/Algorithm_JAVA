package string;

import java.util.Scanner;

public class Boj1541 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String tmp = sc.next();
		
		// 첫번째 빼기 이후론 모든 숫자들을 빼준다.
		boolean isPlus = true;
		int sum = 0, k;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < tmp.length(); i++) {
			
			char temp = tmp.charAt(i);
			if(temp >= '0' && temp <= '9') {
				sb.append(temp);
			} else {
				k = Integer.parseInt(sb.toString());
				sb = new StringBuilder();
				
				if(isPlus) sum += k;
				else sum -= k;
				
				if(temp == '-') {
					isPlus = false;
				}
			}
		}
		
		k = Integer.parseInt(sb.toString());
		if(isPlus) sum += k;
		else sum -= k;
		System.out.println(sum);
	}

}
