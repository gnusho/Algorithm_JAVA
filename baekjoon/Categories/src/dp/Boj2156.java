package dp;

import java.util.Scanner;

public class Boj2156 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[][] dp = new int[N][3]; // 안마셨다, 1잔연속 마셨다, 2잔연속 마셨다.
		dp[0][1] = arr[0];
		for(int i = 1; i < N; i++) {
			dp[i][0] = Math.max(Math.max(dp[i-1][2], dp[i-1][1]), dp[i-1][0]);
			dp[i][1] = arr[i] + dp[i-1][0];
			dp[i][2] = arr[i] + dp[i-1][1];
		}
		
		int ret = 0;
		
		for(int i = 0; i < 3; i++) {
			ret = Math.max(ret, dp[N-1][i]);
		}
		
		System.out.println(ret);
	}

}
