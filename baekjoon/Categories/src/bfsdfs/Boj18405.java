package bfsdfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Boj18405 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]); // 시험관 크기
		int K = Integer.parseInt(input[1]); // 바이러스의 종류
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
				(int[] o1, int[] o2) -> o1[0] - o2[0]);
		
		int[][] arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
				if(arr[i][j] > 0) {
					pq.offer(new int[] {arr[i][j], i, j});
				}
			}
		}
		
		input = br.readLine().split(" ");
		int S = Integer.parseInt(input[0]); // 지나가는 시간
		int X = Integer.parseInt(input[1]) - 1; // X좌표
		int Y = Integer.parseInt(input[2]) - 1; // Y좌표
		
		Queue<int[]> q = new LinkedList<int[]>();
		
		int[] moveX = {-1, 1, 0, 0};
		int[] moveY = {0, 0, -1, 1};
		
		while(S-- > 0) {
			// pq만큼 빼서 q에 넣음
			while(!pq.isEmpty()) {
				q.offer(pq.poll());
			}
			
			// q를 보면서 순서대로 작동시킴
			int size = q.size();
			while(size-- > 0) {
				int[] now = q.poll();
			
				for(int i = 0; i < 4 ; i++) {
					int xx = now[1] + moveX[i];
					int yy = now[2] + moveY[i];
					
					if(xx < 0 || xx >= N || yy < 0 || yy >= N || arr[xx][yy] > 0) continue;
					
					arr[xx][yy] = now[0];
					pq.offer(new int[] {arr[xx][yy], xx, yy});
				}
			}
		}

		System.out.println(arr[X][Y]);
	}

}
