package A17;

import java.util.Scanner;

public class Main {

	static int N, M, K, arr[][], kk[][], num[], tmpArr[][];
	static boolean check[];
	static int ret = 101*50;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		arr = new int[N][M];
		tmpArr = new int[N][M];
		kk = new int[K][3];
		num = new int[K];
		check = new boolean[K];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
				tmpArr[i][j] = arr[i][j];
			}
		}
		
		for(int i = 0; i < K; i++) {
			kk[i][0] = sc.nextInt(); // start_x
			kk[i][1] = sc.nextInt(); // start_y
			kk[i][2] = sc.nextInt(); // 길이
		}
		permutation(0);
		System.out.println(ret);
	}
	
	// 순서가 중요하니까 조합입니다!
	public static void permutation(int cnt) {
		if(cnt == K) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					arr[i][j] = tmpArr[i][j];
				}
			}
			for(int i = 0; i < K; i++) {
				int tmp = num[i];
				rotate(kk[tmp][0], kk[tmp][1], kk[tmp][2]);
			}
			
			for(int i = 0; i < N; i++) {
				int sum = 0;
				for(int j = 0; j < M; j++) {
					sum += arr[i][j];
				}
				ret = ret>sum? sum:ret;
			}
			return;
		}
		
		for(int i = 0; i < K; i++) {
			if(check[i]) continue;
			
			check[i] = true;
			num[cnt] = i;
			permutation(cnt + 1);
			check[i] = false;
		}
	}
	
	public static void rotate(int r, int c, int s) {// 무조건 한번 회전
		int len = 2*s + 1;
		int start_x = r - 1 - s, start_y = c - 1 - s;
	
		while(len > 0) {
			rotation(start_x, start_y, len);
			start_x++;
			start_y++;
			// 여기는 그냥 1씩 더하면 됨 정사각형이 아니더라도 시작 지점의 x좌표와 y좌표는 같음
			len -= 2;
			// 위아래로 하나씩 빠져서 총 2를 빼줘야 함 
		}
	}
	
	public static void rotation(int start_x, int start_y, int len) {// 껍질별로 회전
		int x = start_x;
		int y = start_y;
		int tmp = arr[x][y];
		
		// 각 for문이 같은 거리만큼 커버하도록 구현
		// A15와 다르게 이번엔 시계 방향으로 돌리기
		for(y = start_y + 1; y < start_y + len; y++) {
			int temp = arr[x][y];
			arr[x][y] = tmp;
			tmp = temp;
		}
		y--;
		for(x = start_x + 1; x < start_x + len; x++) {
			int temp = arr[x][y];
			arr[x][y] = tmp;
			tmp = temp;
		}
		x--;
	
		for(y = start_y + len - 2; y >= start_y; y--) {
			int temp = arr[x][y];
			arr[x][y] = tmp;
			tmp = temp;
		}
		y++;
		
		for(x = start_x + len - 2; x >= start_x; x--) {
			int temp = arr[x][y];
			arr[x][y] = tmp;
			tmp = temp;
		}
		// 마지막 칸 처리?? ( 미정 ) -> 할필요 없음
	}

}
/*
5 6 6
1 2 3 2 5 6
3 8 7 2 1 3
8 2 3 1 4 5
3 4 5 1 1 1
9 3 2 1 4 3
3 4 2
4 2 1
4 2 1
4 2 1
4 2 1
4 2 1
*/