package sw3499;

import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			String[] input = new String[N];
			String[] ret = new String[N];
			
			for(int i = 0; i < N; i++) input[i] = sc.next();
			
			int n = N/2;
			int index = 0;
			
			for(int i = 0; i < N; i += 2) {
				ret[i] = input[index++]; 
			}
			
			for(int i = 1; i < N; i += 2) {
				ret[i] = input[index++];  
			}
			
			System.out.printf("#%d", test_case);
			for(int i = 0; i < N; i++) {
				System.out.print(" " + ret[i]);
			}
			System.out.println();
		}
	}
}
