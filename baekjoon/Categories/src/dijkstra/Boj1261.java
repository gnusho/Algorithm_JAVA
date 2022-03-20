package dijkstra;

import java.io.*;
import java.util.*;

public class Boj1261 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		int N = Integer.parseInt(input[1]);
		int M = Integer.parseInt(input[0]);

		boolean[][] walls = new boolean[N][M]; // true면 벽이 있고 아니면 false
		boolean[][] visit = new boolean[N][M]; // 방문했는지 확인하는 용도
		int[][] distArr = new int[N][M];
		for (int i = 0; i < N; i++)
			Arrays.fill(distArr[i], Integer.MAX_VALUE);

		int[] moveX = { -1, 1, 0, 0 };
		int[] moveY = { 0, 0, -1, 1 };

		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (tmp[j] == '1') walls[i][j] = true;
			}
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((int[] o1, int[] o2) -> {
			return o1[0] - o2[0];
		});

		distArr[0][0] = 0;
		pq.offer(new int[] { 0, 0, 0 });

		while (!pq.isEmpty()) {
			int[] now = pq.poll(); // dist , x , y

			if (visit[now[1]][now[2]]) continue;
			visit[now[1]][now[2]] = true;
			
			for(int i = 0; i < 4; i++) {
				int x = now[1] + moveX[i];
				int y = now[2] + moveY[i];
				
				if(x < 0 || y < 0 || x >= N || y >= M || visit[x][y]) continue;
				
				if(walls[x][y] && distArr[x][y] > now[0] + 1) {
					distArr[x][y] = now[0] + 1;
					pq.offer(new int[] {distArr[x][y], x, y});
				} else if(!walls[x][y] && distArr[x][y] > now[0]) {
					distArr[x][y] = now[0];
					pq.offer(new int[] {distArr[x][y], x, y});
				}
			}
		}
		
		System.out.println(distArr[N-1][M-1]);
	}

}
