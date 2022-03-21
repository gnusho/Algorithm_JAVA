package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Boj1504 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int[] startPoints = new int[3];
		
		int N = Integer.parseInt(input[0]);
		int E = Integer.parseInt(input[1]);
		
		ArrayList<int[]>[] adjList = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]) - 1;
			int y = Integer.parseInt(input[1]) - 1;
			int val = Integer.parseInt(input[2]);
			
			adjList[x].add(new int[] {y, val});
			adjList[y].add(new int[] {x, val});
		}
		
		input = br.readLine().split(" ");
		startPoints[1] = Integer.parseInt(input[0]) - 1;
		startPoints[2] = Integer.parseInt(input[1]) - 1;
		
		int[][] minDistArr = new int[3][N];
		
		for(int i = 0; i < 3; i++) {
			Arrays.fill(minDistArr[i], Integer.MAX_VALUE);
			PriorityQueue<int[]> pq = new PriorityQueue<>((int[] o1, int[] o2) -> {
				return o1[1] - o2[1];
			});
			boolean visit[] = new boolean[N];
		
			minDistArr[i][startPoints[i]] = 0;
			pq.offer(new int[] {startPoints[i], 0});
			
			while(!pq.isEmpty()) {
				int[] tmp = pq.poll();
				int now = tmp[0];
				
				if(visit[now]) continue;
				visit[now] = true;
				
				for(int[] cand: adjList[now]) {
					int next = cand[0];
					int dist = cand[1];
					if(!visit[next] && minDistArr[i][next] > minDistArr[i][now] + dist) {
						minDistArr[i][next] = minDistArr[i][now] + dist;
						pq.offer(new int[] {next, minDistArr[i][next]});
					}
				}
			}
		}
		
		int[][] cases = {{0, 1, 2}, {0, 2, 1}};
		
		int min = Integer.MAX_VALUE;
		
		for(int[] c: cases) {
			int sum = 0;
			boolean pos = true;
			for(int i = 0; i < 3; i++) {
				if(i == 2) {
					int tmp = minDistArr[c[i]][N-1];
					if(tmp == Integer.MAX_VALUE) {
						pos = false;
						break;
					}
					sum += tmp;
				} else {
					int tmp = minDistArr[c[i]][startPoints[c[i+1]]];
					if(tmp == Integer.MAX_VALUE) {
						pos = false;
						break;
					}
					sum += tmp;
				}
			}
			if(pos) {
				min = Math.min(min, sum);
			}
		}
		
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}

}
