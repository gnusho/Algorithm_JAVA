package sw7272;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String[] input = br.readLine().split(" ");
			String a = input[0];
			String b = input[1];
			
			if(compare(a,b)) System.out.printf("#%d SAME\n", test_case);
			else  System.out.printf("#%d DIFF\n", test_case);
		}
	}

	private static boolean compare (String a, String b) {
		
		if(a.length() != b.length()) return false;
		
		a = change(a);
		b = change(b);

		return a.equals(b);
	}
	
	public static String change(String a) {
		a = a.replace('B', '2');
		
		a = a.replace('A', '1');
		a = a.replace('D', '1');
		a = a.replace('O', '1');
		a = a.replace('P', '1');
		a = a.replace('Q', '1');
		a = a.replace('R', '1');
		
		a = a.replace('C', '0');
		a = a.replace('E', '0');
		a = a.replace('F', '0');
		a = a.replace('G', '0');
		a = a.replace('H', '0');
		a = a.replace('I', '0');
		a = a.replace('J', '0');
		a = a.replace('K', '0');
		a = a.replace('L', '0');
		a = a.replace('M', '0');
		a = a.replace('N', '0');
		a = a.replace('S', '0');
		a = a.replace('T', '0');
		a = a.replace('U', '0');
		a = a.replace('V', '0');
		a = a.replace('W', '0');
		a = a.replace('X', '0');
		a = a.replace('Y', '0');
		a = a.replace('Z', '0');

		return a;
	}

}
