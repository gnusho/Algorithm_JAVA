package sw1210;

import java.util.Scanner;

class Solution {

	static int arrSize = 100;
	static int[] move_x = { 0, 0};
	static int[] move_y = { -1, 1}; // 내려갈 필요는 없으니까 방향은 2개 1개는 따로 처리
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
	public static int getStart(int d) {

		int now_x = arrSize - 1;
		int now_y = d;

		while (now_x > 0) {
			for (int i = 0; i < move_x.length; i++) {
				// 한번에 갈만큼 가도록 구현해보자
				int xx = now_x, yy = now_y;
				boolean flag = false;
				while (true) { // 이렇게만 구현하면 위로 올라가는 것도 쭉 올라간다
					xx += move_x[i];
					yy += move_y[i];

					if (inRange(xx, yy) && ladder[xx][yy] == 1) {
						flag = true;
					} else {
						yy -= move_y[i];
						break;
					}
				}
				
				if(flag) {
					now_x = xx;
					now_y = yy;
					break;
				}
			}
			now_x--; // 좌우로 가건 안가건 한칸은 무조건 위로 올라가라
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
