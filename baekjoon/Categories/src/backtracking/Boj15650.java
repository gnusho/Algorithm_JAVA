package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj15650 {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		boolean check[] = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			check[i] = true;
			backTracking(check, N, M, 1, i + 1);
			check[i] = false;
		}
		
		System.out.println(sb.toString());
	}

	private static void backTracking(boolean[] check, int N, int M, int cnt, int now) {
		
		if(cnt == M) {
			for (int i = 0; i < N; i++) {
				if(check[i]) sb.append(i + 1).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		if(now >= N) return;
		
		check[now] = true;
		backTracking(check, N, M, cnt + 1, now + 1);
		check[now] = false;
		backTracking(check, N, M, cnt, now + 1);
	}

}
