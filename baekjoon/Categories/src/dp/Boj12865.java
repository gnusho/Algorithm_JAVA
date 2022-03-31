package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj12865 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		int[][] info = new int[N+1][2];
		int[][] dp = new int[N+1][K + 1];
		
		for(int i = 1; i < N + 1; i++) {
			input = br.readLine().split(" ");
			info[i][0] = Integer.parseInt(input[0]);
			info[i][1] = Integer.parseInt(input[1]);
		}
		
		for(int i = 1; i < N + 1; i++) {
			for(int j = 0; j < K + 1; j++) {
				if(j - info[i][0] >= 0) {
					dp[i][j] = Math.max(info[i][1] + dp[i-1][j-info[i][0]], dp[i-1][j]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}

}
