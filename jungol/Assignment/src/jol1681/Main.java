package jol1681;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

	// 모든 점을 지나는 최단경로 문제니까 이 문제는 MST문제이다
	// 딱봐도 간선이 많다. 그러니까 프림알고리즘을 사용하는 것이 좋을 것 같다. 
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 장소의 수
		
		int[][] adjMatrix = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for(int j = 0; j < N; j++) adjMatrix[i][j] = Integer.parseInt(input[j]);
		}
		
		// 돌아와야되서 생각을 다시 해봅시다. 이전의 프림 알고리즘 코드는 모두 지우고
		// 이거 그냥 돌기엔 아무리 생각해도 너무 많음 13P13은 60억이라고 함
		// 그렇다면? DFS? 진심으로? 왜 카테고리가 백트랙킹이지 짜증나게 다른 아이디어가 있을거야...
		// 이거가 dp문제라고 하는 외판원 순회문제와 똑같은 문제라고 하는데 당장은 그냥 백트랙킹으로 풀자
		// 순열 문제다.
		
		boolean visit[] = new boolean[N]; // 방문 확인
		
		// 무조건 0부터 시작해야함
		visit[0] = true;
		backTracking(adjMatrix, visit, N, 0, 1, 0);
		
		System.out.println(min);
	}
	
	private static void backTracking(int[][] adjMatrix, boolean[] visit, 
			int N, int sum, int cnt, int now) {
		
		// cnt == N일 때 처리 => 1로 들어가기전에 마지막으로 들리는 정점으로 처리
		if(cnt > N) return;
		else if(cnt == N) {
			if(adjMatrix[now][0] > 0) {
				min = Math.min(min, sum + adjMatrix[now][0]);
			}
			return;
		}
		
		// 아니라면 순열 진행
		for (int i = 0; i < N; i++) {
			if(!visit[i] && adjMatrix[now][i] > 0) {
				visit[i] = true;
				backTracking(adjMatrix, visit, 
						N, sum + adjMatrix[now][i], cnt + 1, i);
				visit[i] = false;
			}
		}
		
	}

}
/*
5
0 14 4 10 20
14 0 7 8 7
4 5 0 7 16
11 7 9 0 2
18 7 17 4 0
 */
