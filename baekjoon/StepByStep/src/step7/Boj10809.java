package step7;

import java.util.Scanner;

public class Boj10809 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int[] alphabet = new int[26];
		for(int i = 0 ;i < alphabet.length; i++) alphabet[i] = -1;
		
		String input = sc.next();
		
		for(int i = 0; i < input.length(); i++) {
			if(alphabet[input.charAt(i) - 'a'] >= 0) continue;
			alphabet[input.charAt(i) - 'a'] = i;
		}
		
		for(int i = 0 ; i < alphabet.length; i++) System.out.print(alphabet[i] + " ");
	}

}
