package dp;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj14501 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N];
		int[] P = new int[N];
		for(int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			T[i] = Integer.parseInt(input[0]);
			P[i] = Integer.parseInt(input[1]);
		}
		
		// DP로 풀어보자
		int[][] dp = new int[N][2]; //0이면 못넣은거 1이면 넣은거
		for(int i = 0; i < N; i++) {
			if(i + T[i] - 1 < N) dp[i][1] = P[i]; // 초기 값은 자기만 했을 경우
			
			for(int j = 0; j < i; j++) {
				if(j + T[j] - 1 < i && i + T[i] - 1 < N) { // 오늘자 상담을 넣을 수 있다는 것
					dp[i][1] = Math.max(dp[i][1], P[i] + dp[j][1]);
				} else { // 오늘자 상담을 넣을 수 없다는 것
					dp[i][0] = Math.max(dp[i][0], dp[j][1]);
				}
			}
		}
		
		System.out.println(Math.max(dp[N-1][0], dp[N-1][1]));
	}

}
