package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Boj1916 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<int[]>[] adjList = new ArrayList[N];
		for(int i = 0; i < N; i++) adjList[i] = new ArrayList<int[]>();
		
		for(int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			int from = Integer.parseInt(input[0]) - 1;
			int to = Integer.parseInt(input[1]) - 1;
			int cost = Integer.parseInt(input[2]);
			
			adjList[from].add(new int[] {to,cost});
		}
		String[] input = br.readLine().split(" ");
		int start = Integer.parseInt(input[0]) - 1;
		int end = Integer.parseInt(input[1]) - 1;
		
		//다익스트라 구현
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] visit = new boolean[N];
		PriorityQueue<int[]> pq = new PriorityQueue<>((int[] o1, int[] o2) -> {
			return o1[0] - o2[0];
		});
		
		dist[start] = 0;
		pq.add(new int[] {dist[start], start});
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			int d = now[0];
			int point = now[1];
			
			if(visit[point]) continue;
			visit[point] = true;
			
			for(int[] tmp: adjList[point]) {
				int next = tmp[0];
				int val = tmp[1];
				
				if(!visit[next] && dist[point] + val <dist[next]) {
					dist[next] = dist[point] + val;
					pq.add(new int[] {dist[next], next});
				}
			}
		}
		
		System.out.println(dist[end]);
	}

}
