package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj6603 {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]); 
			if(N == 0) break;
			
			int[] inputNum = new int[N];
			for(int i = 0; i < N; i++) inputNum[i] = Integer.parseInt(input[i + 1]);
			
			boolean[] check = new boolean[N]; // N개의 숫자를 전부 확인함
			int[] number = new int[6]; // 6개의 숫자만 확인함
			
			Combination(N, inputNum, check, number, 0, 0);
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void Combination(int N, int[] inputNum, boolean[] check, int[] number, int now, int cnt) {
		// now 와 cnt 검사
		if(cnt == 6) {
			for(int x: number)sb.append(x).append(" ");
			sb.append("\n");
			return;
		}
		if(now >= N) return;
		
		
		// combination 재귀 호출
		number[cnt] = inputNum[now];
		check[now] = true;
		Combination(N, inputNum, check, number, now + 1, cnt + 1);
		
		check[now] = false;
		Combination(N, inputNum, check, number, now + 1, cnt);
	}

}
