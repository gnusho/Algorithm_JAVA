package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Boj1162 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int K = Integer.parseInt(input[2]);
		
		ArrayList<int[]>[] adjList = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		while(M-- > 0) {
			input = br.readLine().split(" ");
			int X = Integer.parseInt(input[0]) - 1;
			int Y = Integer.parseInt(input[1]) - 1;
			int V = Integer.parseInt(input[2]);
			
			adjList[X].add(new int[] {Y, V});
			adjList[Y].add(new int[] {X, V});
		}
		
		long[][] distArr = new long[N][K + 1];
		boolean[][] visit = new boolean[N][K + 1];
		
		PriorityQueue<long[]> pq = new PriorityQueue<>((long[] o1, long[] o2)->{
			if(o1[0] > o2[0]) return 1;
			else if(o1[0] < o2[0]) return -1;
			return 0;
		});
		
		for(int i = 0; i < N; i++) {
			Arrays.fill(distArr[i], Long.MAX_VALUE);
		}
		distArr[0][0] = 0;
		pq.offer(new long[] {0,0,0}); // 거리, 도시, 포장한 도로 수
		
		while(!pq.isEmpty()) {
			long dist = pq.peek()[0];
			int now = (int)pq.peek()[1];
			int k = (int)pq.peek()[2];
			pq.remove();
			if(visit[now][k]) continue;
			visit[now][k] = true;
			
			//System.out.println((now+1) + ":" + dist);
			for(int[] tmp: adjList[now]) {
				int next = tmp[0];
				int val = tmp[1];
				
				// 해당 도로를 포장할 때
				if(k < K && !visit[next][k+1] && distArr[next][k + 1] > dist) {
					distArr[next][k+1] = dist;
					pq.offer(new long[] {distArr[next][k+1], next, k+1});
				}
				
				// 해당 도로를 포장하지 않을 때
				if(!visit[next][k] && distArr[next][k] > dist + val) {
					distArr[next][k] = dist + val;
					pq.offer(new long[] {distArr[next][k], next, k});
				}
			}
		}
		
		long min = Long.MAX_VALUE;
		for(long x: distArr[N-1]) min = Math.min(min, x);
		System.out.println(min);
	}

}
