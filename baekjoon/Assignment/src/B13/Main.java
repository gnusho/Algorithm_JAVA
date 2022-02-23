package B13;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int[] move_x = {-1, 1, 0, 0};
	static int[] move_y = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		char[][] arr = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
	
		boolean visit[][] = new boolean[N][N];
		// 생각을 해보자 만약에 예제에서 첫칸의 dfs를 실행시켜서 R인걸 방문하고 visit을 true로 만든다면
		// 이미 방문한건 들어가지 않으므로 그 다음칸의 R에서 dfs가 실행되지 않는다.
		// 즉 답은 main함수에서 dfs의 호출 횟수와 같다.
		
		int ans1 = 0; // 색약이 틀린 경우
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					dfs(arr, visit, i, j, arr[i][j], N, false);
					ans1++;
				}
			}
		}
		
		// visit값 초기화
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				visit[i][j] = false;
			}
		}
		
		int ans2 = 0; // 색약이 맞는 경우
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					dfs(arr, visit, i, j, arr[i][j], N, true);
					ans2++;
				}
			}
		}
		
		System.out.println(ans1 + " " + ans2);
	}

	private static void dfs(char[][] arr, boolean[][] visit, int x, int y, char c, int N, boolean flag) {
		// 적록색약이 아닌 경우
		visit[x][y] = true;
		for(int i = 0; i < 4; i++) {
			int xx = x + move_x[i];
			int yy = y + move_y[i];
			
			if(xx < 0 || xx >= N || yy < 0 || yy >= N || visit[xx][yy]) continue; // 범위 검사
			
			if(!flag && arr[xx][yy] == c) { // 색약이 아닌 경우 그냥 문자가 같은지만 확인하면 된다
				dfs(arr, visit, xx, yy, c, N, flag);
			}
			
			if(flag && (arr[xx][yy] == c || (arr[xx][yy] == 'G' && c == 'R') || (arr[xx][yy] == 'R' && c == 'G'))) {
				// 색약인 경우는 체크해주어야한다.
				dfs(arr, visit, xx, yy, c, N, flag);
			}
		}
	}

}
