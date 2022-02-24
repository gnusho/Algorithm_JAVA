package D03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]); // N명의 학생 즉 N개의 정점
		int M = Integer.parseInt(input[1]); // M개의 단방향 도로 즉 M개의 간선
		int X = Integer.parseInt(input[2]) - 1; // 도착점
		
		// 이 문제를 풀기위해서 출발점을 X라 하고 다익스트라를 할 예정
		// 그러기 위해서 간선들은 방향을 바꿔서 사용함
		// 문제를 잘못읽어서 모든 점을 다 다익스트라를 실행
		
		ArrayList<ArrayList<int[]>> adjList = new ArrayList<ArrayList<int[]>>();
		for(int i = 0; i < N; i++) adjList.add(new ArrayList<int[]>());
		
		while(M-- > 0) {
			input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]) - 1; // 출발지점
			int end = Integer.parseInt(input[1]) - 1; // 도착지점
			int weight = Integer.parseInt(input[2]); // 걸리는 시간
			
			adjList.get(start).add(new int[] {end, weight});
		}
		
		int[][] distance = new int[N][N];
		for(int i = 0; i < N; i++) { // 각점을 모두 출발점으로 하여 다익스트라 실행
			
			Arrays.fill(distance[i], Integer.MAX_VALUE);
			boolean visit[] = new boolean[N];
			
			PriorityQueue<Point> pq = new PriorityQueue<Point>((p1, p2) -> p1.dist - p2.dist);
			distance[i][i] = 0;
			pq.offer(new Point(i, distance[i][i]));
			
			while(!pq.isEmpty()) {
				Point now = pq.poll();
				if(visit[now.idx]) continue;
				
				visit[now.idx] = true;
				
				for(int[] tmp: adjList.get(now.idx)) {
					int x = tmp[0];
					int dist = tmp[1];
					
					if(!visit[x] && distance[i][x] > distance[i][now.idx] + dist) {
						distance[i][x] = distance[i][now.idx] + dist;
						pq.offer(new Point(x, distance[i][x]));
					}
					
				}
			}
		}

		int MAX = 0;
		
		for(int i = 0; i < N; i++) {
			MAX = Math.max(MAX, distance[i][X] + distance[X][i]);
		}
		
		System.out.println(MAX);
	}
	
	static class Point{
		int idx;
		int dist;
		Point(int idx, int dist){
			this.idx = idx;
			this.dist = dist;
		}
	}

}
