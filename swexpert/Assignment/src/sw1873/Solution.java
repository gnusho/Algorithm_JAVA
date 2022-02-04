package sw1873;

import java.util.Scanner;

class Solution {

	static int H, W, N, X, Y; // X, Y는 탱크의 위치
	static char[][] map;
	static String order;
	// 위,아래,왼쪽,오른쪽
	static int[] move_y = { 0, 0, -1, 1 };
	static int[] move_x = { -1, 1, 0, 0 };
	static char[] tanks = { '^', 'v', '<', '>' };

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			H = sc.nextInt();
			W = sc.nextInt();

			map = new char[H][W];
			// 입력 + 탱크 위치 확인
			for (int i = 0; i < H; i++) {
				String tmp = sc.next();

				for (int j = 0; j < W; j++) {
					map[i][j] = tmp.charAt(j);

					if (map[i][j] == '^' || map[i][j] == '>' || map[i][j] == '<' || map[i][j] == 'v') {
						X = i;
						Y = j;
					}
				}
			}

			N = sc.nextInt();
			order = sc.next();

			for (int i = 0; i < N; i++) {
				char tmp = order.charAt(i);

				if (tmp == 'U') {
					tankMove(0);
				} else if (tmp == 'D') {
					tankMove(1);
				} else if (tmp == 'L') {
					tankMove(2);
				} else if (tmp == 'R') {
					tankMove(3);
				} else if (tmp == 'S') {
					
					if(map[X][Y] == '^') {
						bombMove(0);
					}if(map[X][Y] == 'v') {
						bombMove(1);
					}if(map[X][Y] == '<') {
						bombMove(2);
					}if(map[X][Y] == '>') {
						bombMove(3);
					}
				}
			}
			System.out.printf("#%d ", test_case);
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

	// 포탄의 이동을 함수를 통해서 일관적으로 만들자
	public static void bombMove(int index) {

		int xx = X, yy = Y;

		while (true) {
			xx += move_x[index];
			yy += move_y[index];

			if (inRange(xx, yy)) {
				if (map[xx][yy] == '*') { //벽돌로된 벽을 만남
					map[xx][yy] = '.';
					break;
				} else if (map[xx][yy] == '#') { //뚫을 수 없는 벽을 만남
					break;
				} else { // 그외 
					continue;
				}
			}
			else break; // 이거 처리 안해서 처음에 시간초과 났었음 밖에 나가면 끝내야함
		}
	}

	// 탱크의 이동을 함수를 통해서 일관적으로 만들자
	public static void tankMove(int index) {
		int xx = X + move_x[index];
		int yy = Y + move_y[index];

		if (inRange(xx, yy) && map[xx][yy] == '.') { // 이동시키는 코드
			map[X][Y] = '.';
			map[xx][yy] = tanks[index];
			X = xx;
			Y = yy;
		} else {
			map[X][Y] = tanks[index];
		}

	}

	// 탱크가 다음 칸으로 움직일 수 있는지 없는지 확인하는 함수, 평지에만 이동 가능하다.
	public static boolean inRange(int x, int y) {
		if (x < 0 || x >= H || y < 0 || y >= W)
			return false;
		return true;
	}

}
