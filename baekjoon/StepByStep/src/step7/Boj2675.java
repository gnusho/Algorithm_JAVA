package step7;

import java.util.Scanner;

public class Boj2675 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t-- > 0) {
			int repeat = sc.nextInt();
			String s = sc.next();
			
			for(int i = 0; i<s.length(); i++) {
				for(int j=0;j<repeat;j++) System.out.print(s.charAt(i));
			}
			System.out.println();
		}
	}

}
