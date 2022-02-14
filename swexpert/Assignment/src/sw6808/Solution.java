package sw6808;

import java.util.Scanner;

class Solution {
	
	static int card[] = new int[18];
	static int kyu[] = new int[9];
	static int in[] = new int[9];
	static int win = 0, lose = 0;
	
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			for(int i = 0; i < 18; i++) {
				card[i] = 0;
			}
			win = 0;
			lose = 0;
			for(int i = 0; i < 9; i++) {
				kyu[i] = sc.nextInt();
				card[kyu[i] - 1] = -1;
			}
			
			dfs(0);
			
			System.out.printf("#%d %d %d\n", test_case, win, lose);
		}
	}
	
	public static void dfs(int now) {
		
		if(now == 9) {
			
			int tmp1 = 0, tmp2 = 0;
			for(int i = 0; i < 9; i++) {
				int sum = kyu[i] + in[i];
				if(kyu[i] > in[i]) {
					tmp1 += sum;
				} else {
					tmp2 += sum;
				}
			}
			if(tmp1 > tmp2) win++;
			else if(tmp1 < tmp2) lose++;
			return;
		}
		
		for(int i = 0; i < 18; i++) {
			if(card[i] == -1 || card[i] == 1) continue;
			
			in[now] = i + 1;
			card[i] = 1;
			dfs(now + 1);
			card[i] = 0;
		}
	}
}
