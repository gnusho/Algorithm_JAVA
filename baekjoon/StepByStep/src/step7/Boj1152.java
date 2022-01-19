package step7;

import java.util.Scanner;

public class Boj1152 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		int cnt = 0;
		int before = ' ';
		
		for(int i=0; i< input.length(); i++) {
			if(before == (int)' ' && (int)input.charAt(i)!= (int)' ') cnt++;
			before = input.charAt(i);
		}
		
		System.out.println(cnt);
	}

}
