package sw1861;

import java.util.Scanner;

class Solution {

	static int[][] room = new int[1001][1001];
	//static boolean[][] check = new boolean[1001][1001];
	static int number, max_room, N;

	static int[] xx = { -1, 1, 0, 0 };
	static int[] yy = { 0, 0, -1, 1 };

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			number = -1;
			max_room = -1;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					room[i][j] = sc.nextInt();
				}
			}
			// 입력끝! 순회 시작

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(i, j, 1, room[i][j]);
				}
			}

			System.out.printf("#%d %d %d\n", test_case, number, max_room);
		}
	}

	public static void dfs(int x, int y, int cnt, int start) {
		// 갈 수 있는 곳이 아무 곳도 없으면 자동으로 끝날 것이고 그 순간에 값 검사하기
		boolean go = false;

		for (int i = 0; i < xx.length; i++) {

			int x_ = x + xx[i];
			int y_ = y + yy[i];

			// 정말 아무 생각 없이 실행시킨 dfs
			if (inRange(x_, y_) && room[x_][y_] - room[x][y] == 1) {
				dfs(x_, y_, cnt + 1, start);
			}
		}

		// 다 정리 됬을 때 정답을 정하는 코드
		if (!go) {
			if (cnt > max_room) {
				max_room = cnt;
				number = start;
			} else if (cnt == max_room && start < number) {
				number = start;
			}
		}
	}

	public static boolean inRange(int x, int y) {
		if (x < 0 || x >= N)
			return false;
		if (y < 0 || y >= N)
			return false;
		return true;
	}
}
// 어떻게 푸는게 가장 효율적일까?
// 방을 방마다 움직이면서 풀고 싶지만 자칫하면 100만*100만의 형태이지 않을까? (2초)
// 숫자가 전부 다르기 때문에, 한번 들렸으면 값을 저장해놓을 수 있을 듯 어차피 하나의 길뿐일 것이므로
// 결과적으로 메모이제이션이 될듯 함
// 근데 값을 저장할 필요가 있을까? 어차피 더 큰 수들도 오직 한 곳으로만 들어가는데
// 그냥 들렀으면 boolean으로 하자
// 그 이후엔 dfs
// 오 근데 숫자가 작은것보다 큰게 먼저 봐지면? 그 땐 값을 더할 수 있도록 구현하자
// 오 근데 무지성 dfs로도 풀린다 문제가 좀 이상한듯?
// 시간 남으면 이 코드 원래 생각한대로 최적화 시켜보자