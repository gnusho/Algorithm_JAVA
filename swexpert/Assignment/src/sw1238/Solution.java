package sw1238;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int start = sc.nextInt();
			
			boolean[][] arr = new boolean[N][N]; // 인접리스트로 하고 싶었으나 그러면 겹치게 들어오는거 처리가 힘듬
			
			for(int i = 0; i < N/2; i++) {
				int from = sc.nextInt() - 1;
				int to = sc.nextInt() - 1;
				
				arr[from][to] = true;
			}
			
			boolean[] visited = new boolean[N];
			
			int ret = -1;
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.offer(start - 1);
			visited[start - 1] = true;
			
			while(!queue.isEmpty()) {
				
				int tmp = -1;
				int size = queue.size();
				for(int i = 0; i < size; i++) {
					int now = queue.poll();
					for(int to = 0; to < N; to++) {
						if(arr[now][to] && !visited[to]) {
							queue.offer(to);
							tmp = Math.max(tmp, to);
							visited[to] = true;
						}
					}					
				}
				
				if(tmp >= 0) ret = tmp + 1; 
			}

			System.out.printf("#%d %d\n", test_case, ret);
		}
	}
	
	// dfs로 풀었을 때, 값을 왼쪽에서 보냐 오른쪽에서 보냐에 따라서 답이 다르게 나오는 불상사가 있었음
	// bfs로 다시 시도해봄
}
