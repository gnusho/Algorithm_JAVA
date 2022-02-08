package sw9229;

import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		// 정확히 2개면 무지성 이중 for문 브루트포스 아닐까?
		// 과자가 총 1000개니까 1000C2하면 500*999 만큼만 연산하면 되는데 백만이 안되는걸?
		
		int[] snack = new int[1001];
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(), M = sc.nextInt();
			int max = -1;
			for(int i = 0; i < N; i++) snack[i] = sc.nextInt();
			
			for(int i = 0; i < N - 1; i++) {
				for(int j = i + 1; j < N; j++) {
					int tmp = snack[i] + snack[j];
					if(tmp <= M && tmp > max) max = tmp;
				}
			}
			
			System.out.printf("#%d %d\n", test_case, max);
		}
	}
}
