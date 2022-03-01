package sw2005;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			int N = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder("#");
			sb.append(test_case).append("\n");
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j <= i; j++) {
					int com = factorial(i)/(factorial(j)*factorial(i - j));
					
					sb.append(com).append(" ");
				}
				sb.append("\n");
			}
			
			System.out.print(sb.toString());
		}
		
	}
	
	public static int factorial(int x) {
		if(x == 0) return 1;
		if(x == 1) return 1;
		return x * factorial(x - 1);
	}

}
