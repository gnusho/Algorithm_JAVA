package step7;

import java.util.Scanner;

public class Boj5622 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		
		int now = -1, sum = 0;
		int[] dial = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
		
		for(int i = 0 ; i< input.length(); i++) {
			int x = dial[(int)input.charAt(i) - 'A'];
			sum += x + 1;
		}
		
		System.out.println(sum);
	}

}
