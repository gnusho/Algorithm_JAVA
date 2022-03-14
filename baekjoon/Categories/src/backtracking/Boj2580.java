package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj2580 {

	static boolean[][] colNumCheck = new boolean[10][10];
	static boolean[][] rowNumCheck = new boolean[10][10];
	static boolean[][][] boxNumCheck = new boolean[3][3][10];
	static int[][] arr = new int[9][9];
	static int cnt = 0;
	static boolean done = false;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
				if(arr[i][j] == 0) cnt++;
			}
		}
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				colNumCheck[i][arr[i][j]] = true;
				rowNumCheck[j][arr[i][j]] = true;
				boxNumCheck[i/3][j/3][arr[i][j]] = true;
			}
		}
		
		backTracking(0);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void backTracking(int count) {
		if(done) return;
		if(count == cnt) {
			done = true;
			return;
		}
		//System.out.println(count);
		boolean find = false;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(arr[i][j] != 0) continue;
				//System.out.println(i + " " + j);
				find = true;
				for(int t = 1; t <= 9; t++) {
					if(!colNumCheck[i][t] && !rowNumCheck[j][t] && !boxNumCheck[i/3][j/3][t]) {
						colNumCheck[i][t] = true;
						rowNumCheck[j][t] = true;
						boxNumCheck[i/3][j/3][t] = true;
						//System.out.println(t);
						arr[i][j] = t;
						backTracking(count + 1);
						if(done) break;
						colNumCheck[i][t] = false;
						rowNumCheck[j][t] = false;
						boxNumCheck[i/3][j/3][t] = false;
						arr[i][j] = 0;
					}
				}
				if(find) return;
			}
			if(find) return;
		}
	}
}
