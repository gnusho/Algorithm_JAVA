package step7;

import java.util.Scanner;

public class Boj2908 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a = sc.next(), b = sc.next();
		int a_ = (a.charAt(2) - (int)'0')*100 + (a.charAt(1) - (int)'0')*10 + (a.charAt(0) - (int)'0');
		int b_ = (b.charAt(2) - (int)'0')*100 + (b.charAt(1) - (int)'0')*10 + (b.charAt(0) - (int)'0');
		
		System.out.println((a_ > b_)? a_:b_);
	}

}
