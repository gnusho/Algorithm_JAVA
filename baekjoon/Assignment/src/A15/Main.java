package A15;

import java.util.Scanner;

public class Main {

	static int N, M, R, arr[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();

		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		while(R-- > 0) {
			rotate();
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void rotate() {// 무조건 한번 회전
		int x = N, y = M;
		int start_x = 0, start_y = 0;
		
		while(x > 0 && y > 0) {
			rotation(start_x, start_y, x, y);
			start_x++;
			start_y++;
			// 여기는 그냥 1씩 더하면 됨 정사각형이 아니더라도 시작 지점의 x좌표와 y좌표는 같음
			x -= 2;
			y -= 2;
			// 위아래로 하나씩 빠져서 총 2를 빼줘야 함 
		}
	}
	
	public static void rotation(int start_x, int start_y, int x_len, int y_len) {// 껍질별로 회전
		
		int x = start_x;
		int y = start_y;
		int tmp = arr[x][y];
		
		// 각 for문이 같은 거리만큼 커버하도록 구현
		// 아래로 가기 -> x값 증가, y값 유지
		for(x = start_x + 1; x < start_x + x_len; x++) {
			int temp = arr[x][y];
			arr[x][y] = tmp;
			tmp = temp;
		}
		x--;
		// 오른쪽으로 가기 -> y값 증가, x값 유지
		for(y = start_y + 1; y < start_y + y_len; y++) {
			int temp = arr[x][y];
			arr[x][y] = tmp;
			tmp = temp;
		}
		y--;
		// 위로 가기 -> x값 감소, y값 유지
		for(x = start_x + x_len - 2; x >= start_x; x--) {
			int temp = arr[x][y];
			arr[x][y] = tmp;
			tmp = temp;
		}
		x++;
		// 왼쪽으로 가기 -> y값 감소, x값 유지
		for(y = start_y + y_len - 2; y >= start_y; y--) {
			int temp = arr[x][y];
			arr[x][y] = tmp;
			tmp = temp;
		}
		// 마지막 칸 처리?? ( 미정 ) -> 할필요 없음
	}

}

/*
2 2 1
1 2
3 4
*/