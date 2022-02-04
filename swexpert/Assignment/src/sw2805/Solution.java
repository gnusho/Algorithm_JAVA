package sw2805;

import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		int N, r = 1, sum = 0;
		boolean isPlus = false;

		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력을 받으면서 끝내버리자!
			N = sc.nextInt();

			r = N / 2; // 좌우에서 계산할 필요 없는 값
			sum = 0;
			isPlus = false;

			for (int i = 0; i < N; i++) {
				String tmp = sc.next();

				for (int j = 0; j < N; j++) {
					if(j < r || j > N - r - 1) continue; // 범위를 확인하고 필요없으면 continue
					int temp = tmp.charAt(j) - '0'; // 간편하게 unicode로 덧셈
					sum += temp;
				}

				if (r == 0) // r이 0이라면 가장 많은 칸을 더한 가운데 줄에 왔다는 뜻이므로 이제 1씩 더해감
					isPlus = true;
				
				if(isPlus) r++;
				else r--;
				
			}
			
			System.out.printf("#%d %d\n", test_case, sum);
		}
	}
}