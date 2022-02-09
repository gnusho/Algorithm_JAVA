package sw1210;

import java.util.Scanner;

class Solution {

	static int arrSize = 100;
	static int[] move_x = { 0, 0, -1 };
	static int[] move_y = { -1, 1, 0 }; // 내려갈 필요는 없으니까 방향은 3개,
	static int[][] ladder = new int[arrSize][arrSize];

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {

			int d = -1; // destination의 준말 d
			int whyGetInput = sc.nextInt(); // 왜 받는지 모르겠는데 받아놓기

			// 입력 받기
			for (int i = 0; i < arrSize; i++) {
				for (int j = 0; j < arrSize; j++) {
					ladder[i][j] = sc.nextInt();
					if (ladder[i][j] == 2)
						d = j; // 어차피 마지막 줄일 것이므로
				}
			}

			// 아래에서 위로 올라가자
			System.out.printf("#%d %d\n", test_case, getStart(d));
		}
	}

	// 기존의 방식대로 구현하니까 사다리를 건널때 왔다갔다 무한루프를 도는 현상이 나타났다
	// 해당 움직임의 방향을 1차 확인하고 행동해야겠다.
	public static int getStart(int d) {

		int now_x = arrSize - 1;
		int now_y = d;
		int way = 2; // (2 -> up) (0 -> left) (1 -> right)

		while (now_x > 0) {
			if (way == 2) { // 위로 올라갈땐 좌우를 살펴야함
				for (int i = 0; i < move_x.length; i++) {
					int xx = now_x + move_x[i];
					int yy = now_y + move_y[i];

					if (inRange(xx, yy) && ladder[xx][yy] == 1) {
						now_x = xx;
						now_y = yy;
						way = i;
						break;
					}
				}
			} else { // 가던 방향부터 확인하고 있으면 그쪽으로 감
				int xx = now_x + move_x[way];
				int yy = now_y + move_y[way];

				if (inRange(xx, yy) && ladder[xx][yy] == 1) { // 가던 방향에 있으면 그냥 ㄱ ㄱ
					now_x = xx;
					now_y = yy;
				} else { // 없으면 이젠 올라가야할 타이밍
					now_x += move_x[2];
					now_y += move_y[2];
					way = 2;
				}
			}
		}

		return now_y;
	}

	public static boolean inRange(int x, int y) {
		if (x < 0 || x >= arrSize)
			return false;
		if (y < 0 || y >= arrSize)
			return false;
		return true;
	}
}
