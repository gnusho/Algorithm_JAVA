package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Boj10217 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			int K = Integer.parseInt(input[2]);
			
			ArrayList<int[]>[] arr = new ArrayList[N];
			for(int i = 0; i < N; i++) {
				arr[i] = new ArrayList<>();
			}
			
			while(K-- > 0) {
				input = br.readLine().split(" ");
				int from = Integer.parseInt(input[0]) - 1;
				int to = Integer.parseInt(input[1]) - 1;
				int cost = Integer.parseInt(input[2]);
				int time = Integer.parseInt(input[3]);
				
				arr[from].add(new int[] {to,cost,time});
			}
			
			boolean[][] visit = new boolean[N][M+1];
			int[][] dist = new int[N][M+1];
			
			for(int i = 0; i < N; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
			
			PriorityQueue<int[]> pq = new PriorityQueue<int[]>((int[] o1, int[] o2)->{
				return o1[0] - o2[0];
			});
			
			dist[0][0] = 0;
			pq.offer(new int[] {0,0,0}); // 걸린 시간, 도시, 비용
			
			while(!pq.isEmpty()) {
				int[] p = pq.poll();
				int time = p[0];
				int now = p[1];
				int cost = p[2];
				
				if(visit[now][cost]) continue;
				visit[now][cost] = true;
				
				for(int[] tmp: arr[now]) {
					int next = tmp[0];
					int c = tmp[1];
					int t = tmp[2];
					if(cost + c <= M && !visit[next][cost + c] && dist[next][cost + c] > t + time) {
						dist[next][cost + c] = t + time;
						pq.offer(new int[] {t + time, next, cost + c});
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
			for(int x: dist[N-1]) min = Math.min(min, x);
			
			if(min == Integer.MAX_VALUE) sb.append("Poor KCM\n");
			else sb.append(min).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
