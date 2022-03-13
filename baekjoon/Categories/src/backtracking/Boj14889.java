package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj14889 {

	static int N, arr[][];
	static int ret = Integer.MAX_VALUE;
	static boolean visit[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N];
		String[] input;
		for(int i =0; i < N; i++) {
			input = br.readLine().split(" ");
			for(int j = 0; j < N; j++) arr[i][j] = Integer.parseInt(input[j]);
		}
		
		backTracking(0, 0);
		
		System.out.println(ret);
	}

	public static void backTracking(int now, int cnt) {
		if(cnt == N/2) {
			int start = 0, link = 0;
			for (int i = 0; i < N; i++) {
				for(int j = i + 1; j < N; j++) {
					if(visit[i]&&visit[j]) start += arr[i][j] + arr[j][i];
					if(!visit[i]&&!visit[j]) link += arr[i][j] + arr[j][i];
				}
			}
			
			ret = Math.min(ret, Math.abs(start- link));
			
			return;
		}
		if(now >= N) return;
		
		visit[now] = true;
		backTracking(now + 1, cnt + 1);
		visit[now] = false;
		backTracking(now + 1, cnt);
	}
}
