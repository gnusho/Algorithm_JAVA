package bruteforce;

import java.util.Scanner;

public class Boj14888 {

	static int N;
	static int[] num;
	static int[] calc = new int[4];
	static int min = 1000000000;
	static int max = -1000000000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		num = new int[N];

		for (int i = 0; i < N; i++)
			num[i] = sc.nextInt();
		for (int i = 0; i < 4; i++)
			calc[i] = sc.nextInt();

		dfs(num[0], 1);
		
		System.out.printf("%d\n%d", max, min);
	}

	public static void dfs(int result, int now) {

		if (now == N) {
			min = min > result ? result : min;
			max = max < result ? result : max;
			return;
		}

		for (int i = 0; i < 4; i++) {
			
			if (calc[i] == 0)
				continue;
			
			calc[i]--;
			if(i == 0) {
				dfs(result + num[now], now + 1);
			}else if(i == 1) {
				dfs(result - num[now], now + 1);
			}else if(i == 2) {
				dfs(result * num[now], now + 1);
			}else {
				dfs(result / num[now], now + 1);
			}
			calc[i]++;
		}
	}

}
