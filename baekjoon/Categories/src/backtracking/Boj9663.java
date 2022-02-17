package backtracking;

import java.util.Scanner;

public class Boj9663 {

	static int ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int chess[][] = new int[N][N];
		
		backtracking(N, chess, 0);
		
		System.out.println(ans);
	}

	public static void backtracking(int N, int chess[][], int now) {
		if(now == N) {
			ans++;
			return;
		}
		for(int i = 0; i < N; i++) {
			if(chess[now][i] == 0) {
				checkChess(N, chess, now, i);
				backtracking(N, chess, now + 1);
				uncheckChess(N, chess, now, i);
			}
		}
	}
	
	// 0인거 찾아서 now + 1로 바꾸기
	public static void checkChess(int N, int chess[][], int now, int i) {
		int x = now, y = i;
		while(x >=0 && x < N && y >= 0 && y < N) {
			if(chess[x][y] == 0) chess[x][y] = now + 1;
			x++;
			y++;
		}
		
		// 대각선 처리2
		x = now;
		y = i;

		while(x >=0 && x < N && y >= 0 && y < N) {
			if(chess[x][y] == 0) chess[x][y] = now + 1;
			x++;
			y--;
		}
		
		// 가로선 처리
		y = i;
		for(x = now; x < N; x++) {
			if(chess[x][y] == 0) chess[x][y] = now + 1;
		}
	}
	
	// now + 1 찾으면 0으로 바꾸기
	public static void uncheckChess(int N, int chess[][], int now, int i) {
		int x = now, y = i;
		while(x >=0 && x < N && y >= 0 && y < N) {
			if(chess[x][y] == now + 1) chess[x][y] = 0;
			x++;
			y++;
		}
		
		// 대각선 처리2
		x = now;
		y = i;

		while(x >=0 && x < N && y >= 0 && y < N) {
			if(chess[x][y] == now + 1) chess[x][y] = 0;
			x++;
			y--;
		}
		
		// 가로선 처리
		y = i;
		for(x = now; x < N; x++) {
			if(chess[x][y] == now + 1) chess[x][y] = 0;
		}
	}
}

