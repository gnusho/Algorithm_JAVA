package step7;

import java.util.Scanner;

public class Boj1157 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		
		int[] alpha = new int[26];
		
		for(int i = 0; i <word.length(); i++) {
			int tmp = word.charAt(i);
			if(tmp >= (int)'A' && tmp <= (int)'Z') alpha[tmp - 'A']++;
			if(tmp >= (int)'a' && tmp <= (int)'z') alpha[tmp - 'a']++;	
		}
		
		int max = -1, index = -1;
		boolean many = false;
		
		for(int i = 0; i < alpha.length; i++) {
			if(alpha[i] > max) {
				max = alpha[i];
				index = i;
				many = false;
			}
			else if(alpha[i] == max) many =true;
		}
		
		if(many == true) System.out.println('?');
		else System.out.println((char)(index + 'A'));
	}

}
