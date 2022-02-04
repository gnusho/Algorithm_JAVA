package sw2001;

import java.util.Scanner;

class Solution {

	static int[][] arr;
	static int N, M;

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();

			arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			// 다른거 없이 걍 브루트포스인 것 같다
			int max = -1;
			for (int i = 0; i <= N - M; i++) { // N -M 은 따로 범위를 계산하기 싫어서 값을 설정했다
				for (int j = 0; j <= N - M; j++) { // 대신에 등호를 붙여야 한다. 그 칸을 포함해서 M칸을 세기 때문이다.
					int tmp = flies(i, j); // 괜히 files를 2번 실행시킬 필요없이 값을 받아 놓는다
					max = tmp > max ? tmp : max;
				}
			}
			
			System.out.printf("#%d %d\n", test_case, max);
		}
		
	}

	public static int flies(int x, int y) { // 그냥 막 더하는 메소드다
		int ret = 0;
		for(int i = x; i < x + M; i++) {
			for(int j = y; j < y + M; j++) {
				ret += arr[i][j];
			}
		}
		
		return ret;
	}
}
