package unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj17090 {
	static int N,M;
	static int[][] arr;
	static boolean[][] check;
	static boolean[][] pos;
	
	static int ret = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		arr = new int[N][M];
		check = new boolean[N][M];
		pos = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				arr[i][j] = tmp[j];
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!check[i][j]) dfs(i,j);
				if(pos[i][j]) ret++;
			}
		}
		
		System.out.println(ret);
	}

	private static void dfs(int x, int y) {
		check[x][y] = true;
		
		int xx = x;
		int yy = y;
		
		if(arr[x][y] == 'U') xx--;
		else if(arr[x][y] == 'R') yy++;
		else if(arr[x][y] == 'D') xx++;
		else if(arr[x][y] == 'L') yy--;
		
		if(xx < 0 || xx >= N || yy < 0 || yy >= M) {
			pos[x][y] = true;
		} else {
			if(!check[xx][yy]) dfs(xx, yy);
			if(pos[xx][yy]) pos[x][y] = true;
		}
	}

}
