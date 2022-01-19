package step7;

import java.util.Scanner;

public class Boj11720 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), sum = 0;
		String input = sc.next();
		
		for(int i = 0; i < n; i++) sum += (int)input.charAt(i) - '0';
		System.out.println(sum);
	}

}
