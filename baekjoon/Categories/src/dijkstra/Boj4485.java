package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Boj4485 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
		int testCase = 0;
		int moveX[] = { -1, 1, 0, 0 };
		int moveY[] = { 0, 0, -1, 1 };
		while ((N = Integer.parseInt(br.readLine())) != 0) {
			int[][] arr = new int[N][N];
			for(int i = 0; i < N; i++) {
				String[] input = br.readLine().split(" ");
				for(int j = 0; j < N; j++) arr[i][j] = Integer.parseInt(input[j]);
			}
			int[][] distArr = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(distArr[i], Integer.MAX_VALUE);
			}
			boolean[][] visit = new boolean[N][N];
			
			PriorityQueue<int[]> pq = new PriorityQueue<>((int[] o1, int[] o2)->{
				return o1[2] - o2[2];
			});
			
			distArr[0][0] = arr[0][0];
			pq.offer(new int[] {0,0,distArr[0][0]});
			
			while(!pq.isEmpty()) {
				int x = pq.peek()[0];
				int y = pq.peek()[1];
				pq.remove();
				
				if(visit[x][y]) continue;
				visit[x][y] = true;
				int dist = distArr[x][y];
				
				for(int i = 0; i < 4; i++) {
					int xx = x + moveX[i];
					int yy = y + moveY[i];
					
					if(xx < 0 || yy < 0 || xx >= N || yy >= N || visit[xx][yy]) continue;
					if(distArr[xx][yy] > dist + arr[xx][yy]) {
						distArr[xx][yy] = dist + arr[xx][yy];
						pq.offer(new int[] {xx, yy, distArr[xx][yy]});
					}
				}
			}
			
			System.out.println("Problem " + ++testCase + ": " + distArr[N-1][N-1]);
		}
	}

}
