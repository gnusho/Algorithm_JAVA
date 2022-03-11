package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj2529 {

	static String minStr = "", maxStr = "";
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		
		int number[] = new int[10];
		boolean visit[] = new boolean[10];
		
		for(int i = 0; i < 10; i++) number[i] = -1;
		backTracking(K, input, number, visit, 0);
		
		System.out.println(maxStr + "\n" + minStr);
	}

	private static void backTracking(int K, String[] input, int[] number, boolean[] visit, int now) {
		
		if(now == K + 1) {
			StringBuilder sb= new StringBuilder();
			for(int x: number) {
				if(x >= 0) sb.append(x);
			}
			
			if(minStr.length() == 0) minStr = sb.toString();
			if(maxStr.length() == 0) maxStr = sb.toString();
			
			// for문 돌면서 비교
			for(int i = 0; i <= K; i++) {
				int tmp = sb.charAt(i) - '0';
				int minChar = minStr.charAt(i) - '0';
				
				if(tmp < minChar) {
					minStr = sb.toString();
					break;
				} else if(tmp > minChar) {
					break;
				}
			}
			
			for(int i = 0; i <= K; i++) {
				int tmp = sb.charAt(i) - '0';
				int maxChar = maxStr.charAt(i) - '0';
	
				if(tmp > maxChar) {
					maxStr = sb.toString();
					break;
				} else if(tmp < maxChar) {
					break;
				}
			}
			
			return;
		}
		
		for(int i = 0; i < 10; i++) {
			// now = 0일때
			if(now == 0 && !visit[i]) {
				number[0] = i;
				visit[i] = true;
				backTracking(K, input, number, visit, now + 1);
				visit[i] = false;
			}
			// now > 0
			else if(now > 0 && !visit[i]) {
				if(input[now - 1].compareTo(">") == 0 && number[now - 1] > i) {
					number[now] = i;
					visit[i] = true;
					backTracking(K, input, number, visit, now + 1);
					visit[i] = false;
				} else if(input[now - 1].compareTo("<") == 0 && number[now - 1] < i) {
					number[now] = i;
					visit[i] = true;
					backTracking(K, input, number, visit, now + 1);
					visit[i] = false;
				}
			}
		}
		
	}

}
