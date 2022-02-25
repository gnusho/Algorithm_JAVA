package A30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int cnt = 0; // 토마토의 총개수를 센다. 향후 이게 0이되면 토마토가 다 익은것이다.
		int[][] arr = new int[M][N];
		
		// 문제 풀이는 bfs를 사용해서 depth를 구할 예정이다.
		// 그러므로 입력 받다가 1이 나오면 q에 넣어준다.
		Queue<Point> q = new LinkedList<Point>();
		
		for(int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
				if(arr[i][j] == 1) q.offer(new Point(i, j));
				else if(arr[i][j] == 0) cnt++; // 안 익은거 개수만 세면 된다.
			}
		}
		
		int[] move_x = {-1, 1, 0, 0};
		int[] move_y = {0, 0, -1, 1};
		int depth = -1; // depth가 일자라고 생각하면 된다.
		
		while(!q.isEmpty()) {
			
			depth++;
			int size = q.size();
			for(int i = 0; i < size; i++) {
				Point now = q.poll();
				
				for(int j = 0; j < 4; j++) {
					int xx = now.x + move_x[j];
					int yy = now.y + move_y[j];
					if(xx < 0 || yy < 0 || xx >= M || yy >= N || arr[xx][yy] != 0) continue;
					
					cnt--; // 하나 더 익었다.
					arr[xx][yy] = 1; // 익었다는걸 표시해줬다.
					q.offer(new Point(xx, yy));
				}
			}
			
		}
		
		if(cnt > 0) System.out.println(-1);
		else System.out.println(depth);
		
	}
	
	static class Point{ // 아 배열쓰면 되는데 또 클래스 만들었네 습관아 무섭다 진짜
		int x,y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
