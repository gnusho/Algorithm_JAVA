package dp;

import java.util.Scanner;

public class Boj9251 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String A = sc.next();
		String B = sc.next();
		
		int Asize = A.length();
		int Bsize = B.length();
		
		int[][] dp = new int[Asize + 1][Bsize + 1];
		
		for(int i = 1; i < Asize + 1; i++) {
			for(int j = 1; j < Bsize + 1; j++) {
				if(A.charAt(i - 1) == B.charAt(j - 1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		System.out.println(dp[Asize][Bsize]);
	}

}
