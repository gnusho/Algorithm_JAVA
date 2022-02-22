package A22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N, M, V;
	static boolean[][] arr;
	static boolean[] visited;
	static StringBuilder sb1 = new StringBuilder();
	static StringBuilder sb2 = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		V = Integer.parseInt(input[2]);

		arr = new boolean[N][N];
		visited = new boolean[N];

		while (M-- > 0) {
			input = br.readLine().split(" ");
			int from = Integer.parseInt(input[0]);
			int to = Integer.parseInt(input[1]);
			arr[from - 1][to - 1] = true;
			arr[to - 1][from - 1] = true; // 양방향 간선인데 문제에서 말을 안해줌
		}

		dfs(V - 1);
		System.out.println(sb1.toString());
		for (int i = 0; i < N; i++)
			visited[i] = false;
		bfs(V - 1);
		System.out.println(sb2.toString());
	}

	public static void dfs(int now) { // 실습코드와 다르지 않음

		visited[now] = true;
		sb1.append(now + 1).append(" ");

		for (int i = 0; i < N; i++) {
			if (arr[now][i] && !visited[i]) {
				dfs(i);
			}
		}

	}

	public static void bfs(int start) { // 실습코드와 다르지 않음

		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int tmp = q.poll();
			sb2.append(tmp + 1).append(" ");
			
			for (int i = 0; i < N; i++) {
				if (arr[tmp][i] && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}
