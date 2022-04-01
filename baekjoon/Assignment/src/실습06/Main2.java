package 실습06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

// dist 배열 + DIJKSTRA

public class Main2 {

	public static void main(String[] args) throws Exception {
		int[] moveX = { -1, 1, 0, 0 };
		int[] moveY = { 0, 0, -1, 1 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		char[][] arr = new char[N][M];

		Point start = null;

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == '0') {
					start = new Point(i, j);
					arr[i][j] = '.';
				}
			}
		}

		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[][][] dist = new int[N][M][64];

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				Arrays.fill(dist[i][j], Integer.MAX_VALUE);
			}
		}
		
		dist[start.x][start.y][0] = 0;
		pq.offer(new Node(start, 0, 0));
		
		int ret = -1;
		while(!pq.isEmpty()) {
			
			Point p = pq.peek().p;
			int d = pq.peek().dist;
			int k = pq.peek().key;
			pq.remove();
			
			if(dist[p.x][p.y][k] < d) continue;
			
			if(arr[p.x][p.y] == '1') {
				ret = dist[p.x][p.y][k];
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int xx = moveX[i] + p.x;
				int yy = moveY[i] + p.y;
		
				if(xx < 0 || yy < 0 || xx >= N || yy >= M || arr[xx][yy] == '#') {
					continue;
				}
				if(arr[xx][yy] == '.' || arr[xx][yy] == '1') {
					if(dist[xx][yy][k] > d + 1) {
						dist[xx][yy][k] = d + 1;
						pq.offer(new Node(new Point(xx,yy), d+1, k));
					}
				} else if(arr[xx][yy] >= 'a' && arr[xx][yy] <= 'f') {
					int tmp = arr[xx][yy] - 'a';
					if(dist[xx][yy][k|1<<tmp] > d + 1) {
						dist[xx][yy][k|1<<tmp] = d + 1;
						pq.offer(new Node(new Point(xx,yy), d+1, k|1<<tmp));
					}
				} else if(arr[xx][yy] >= 'A' && arr[xx][yy] <= 'F') {
					int tmp = arr[xx][yy] - 'A';
					if((k & 1 << tmp) > 0 && dist[xx][yy][k] > d + 1) {
						dist[xx][yy][k] = d + 1;
						pq.offer(new Node(new Point(xx,yy), d+1, k));
					}
				}
			}
			
		}
		
		System.out.println(ret);
	}

	static class Node implements Comparable<Node>{
		Point p;
		int dist;
		int key;
		
		Node(Point p, int dist, int key) {
			this.p = p;
			this.dist = dist;
			this.key = key;
		}

		@Override
		public int compareTo(Node o) {
			return dist - o.dist;
		}
		
	}

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
