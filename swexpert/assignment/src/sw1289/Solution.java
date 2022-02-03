package sw1289;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		
		/*
		 * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			
			String x = sc.next();
			int a = 0, cnt = 0;
			for(int i = 0 ; i < x.length(); i++) {
				int tmp = x.charAt(i) - '0';
				
				if(tmp == a) {
					continue;
				}
				
				cnt++;
				a = a==0? 1:0;
			}

			System.out.printf("#%d %d\n", test_case, cnt);
		}
	}
}
