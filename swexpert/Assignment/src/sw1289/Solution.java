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
			int a = 0, cnt = 0;//cnt는 바뀐 횐수, a는 현재 상태를 의미한다.
			
			/* 아래의 상태에서 만약 순서대로 진행중에 해당 위치가 특정값으로 설정될 경우가 a가 바뀌면서 cnt가 1 추가된다
			 * 예를 들어서 a=1이라는 것은 현재 i위치의 값이 1이라는 것으로 만약 우리가 해당 위치의 값이 0이 되도록 해야한다면
			 * a = 0으로 바꾸고 cnt에 1을 추가한다.
			 * 만약에 현재 위치의 값과 우리가 바꿔야하는 값이 같으면 그냥 넘어간다.
			 */
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
