package queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj16918 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int R = Integer.parseInt(input[0]); // row수
		int C = Integer.parseInt(input[1]); // col수
		int N = Integer.parseInt(input[2]); // 진행회차
		
		int[][] bomb = new int [R][C]; // 0이상 폭탄/ 0 미만 평지
		for(int i = 0; i < R; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j = 0; j < C; j++) {
				if(tmp[j] == '.') {
					bomb[i][j] = -1;
				}
			}
		}
		
		int turn = 1;
		int moveX[] = {0, -1, 1, 0, 0};
		int moveY[] = {0, 0, 0, -1, 1};
		
		Queue<int[]> q = new LinkedList<int[]>();
		
		while(turn < N) {
			turn++;
			
			// 폭탄 놔두기
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(bomb[i][j] < 0) bomb[i][j] = turn;
				}
			}
			
			// 폭탄 터뜨리기
			// 돌면서 이번에 터질 폭탄들 Q에 넣기
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(turn -bomb[i][j] == 3) q.offer(new int[] {i, j});
				}
			}
			
			// q비우면서 폭탄들 터뜨리기
			while(!q.isEmpty()) {
				int now[] = q.poll();
				
				for(int i = 0; i < 5; i++) {
					int xx = now[0] + moveX[i];
					int yy = now[1] + moveY[i];
					
					if(xx < 0 || xx >= R || yy < 0 || yy >= C) continue;
					
					bomb[xx][yy] = -1;
				}
			}
		}
		
		// 이게 BFS?????????
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(bomb[i][j] >= 0) sb.append('O');
				else sb.append('.');
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
