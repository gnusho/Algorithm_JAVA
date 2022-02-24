package A28;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String input[] = br.readLine().split(" ");
		
		int V = Integer.parseInt(input[0]); // 정점 수
		int E = Integer.parseInt(input[1]); // 간선 수
		
		int start = Integer.parseInt(br.readLine()) - 1; // 시작 지점
		
		ArrayList<ArrayList<int[]>> adjList = new ArrayList<ArrayList<int[]>>();
		for(int i = 0; i < V; i++) adjList.add(new ArrayList<int[]>()); // 하나하나 넣어줘야함
			
		for(int i = 0; i < E; i++) {
			input = br.readLine().split(" ");
			int u = Integer.parseInt(input[0]) - 1; // 출발 지점
			int v = Integer.parseInt(input[1]) - 1; // 도착 지점
			int w = Integer.parseInt(input[2]); // 가중치
			
			adjList.get(u).add(new int[] {v, w}); // 인접리스트에 값 넣어줌
		}
		
		int[] dist = new int[V]; // 출발점에서 각 정점까지의 최단 거리
		boolean[] check = new boolean[V]; // 각 정점의 최단거리가 정해져있는지 확인
		Arrays.fill(dist, Integer.MAX_VALUE); // 각 점을 INF로 채움
		
		dist[start] = 0;
		
		PriorityQueue<Point> pq = new PriorityQueue<Point>((p1, p2) -> p1.dist - p2.dist); // 우선순위큐를 사용해서 아래의 1번 실행
		// 람다를 사용해서 정렬함
		pq.offer(new Point(start, dist[start])); // 첫번째 칸 넣어주기
		
		while(!pq.isEmpty()) {
			
			// 1. 거리가 가장 작은 정점 고르기
			Point now = pq.poll(); // 여기서 해당 정점 값이 작아도 이미 확정된 점이면 안됨
			if(check[now.idx]) continue;

			// 2. 거리 확정시키기
			check[now.idx] = true; // 이제 만약에 pq에 남아있어도 위에서 걸러줌
			
			// 3. 선택된 정점을 경유지로 해서 다른 정점의 값 갱신하기
			for(int[] tmp : adjList.get(now.idx)) { // 인접 리스트를 돌면서
				
				int index = tmp[0];
				int weight = tmp[1];
				
				if(!check[index] && dist[index] > dist[now.idx] + weight) {
					dist[index] = dist[now.idx] + weight;
					pq.offer(new Point(index, dist[index]));
				}
				
			}
		}
		
		for(int x: dist) {
			if(x == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(x);
		}
	}
	
	static class Point{
		int idx; // 정점 번호
		int dist; // 해당 정점의 당시 dist 
		
		Point(int idx , int dist){
			this.idx = idx;
			this.dist = dist;
		}
	}
}
