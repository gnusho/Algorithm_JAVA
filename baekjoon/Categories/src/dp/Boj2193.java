package dp;

import java.util.Scanner;

public class Boj2193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		long[] dp = new long[N + 1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 1;
		for(int i = 3; i < N + 1; i++) {
			for(int j = i - 2; j >= 0; j--) {
				dp[i] += dp[j];
			}
		}
		System.out.println(dp[N]);
	}

}
