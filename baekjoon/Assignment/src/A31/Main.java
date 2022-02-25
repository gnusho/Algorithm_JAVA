package A31;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");

		int R = Integer.parseInt(input[0]);
		int C = Integer.parseInt(input[1]);
		int T = Integer.parseInt(input[2]); // 시간

		// int sum = 0; // 합을 구해둘까 했는데 이게 소수점을 버리면 어차피 유지가 안될거 같다.

		int arr[][][] = new int[R][C][2];
		// 3차원 배열의 첫번째 칸이 우리가 아는 칸이고 두번째 칸은 확산시에 받은거를 따로 저장하기 위함

		int cleanCnt = 0; // 입력받을 때 사용할 것
		int[][] clean = new int[2][2]; // 공기청정기 위치 -> 다행히도 움직이진 않는듯
		for (int r = 0; r < R; r++) {
			input = br.readLine().split(" ");
			for (int c = 0; c < C; c++) {
				arr[r][c][0] = Integer.parseInt(input[c]);
				if (arr[r][c][0] == -1) {
					clean[cleanCnt][0] = r;
					clean[cleanCnt][1] = c;
					cleanCnt++;
				}
			}
		}

		int moveX[] = { -1, 0, 1, 0 };
		int moveY[] = { 0, -1, 0, 1 };
		int dust = 0;
		while (T-- > 0) {
			dust = 0;

			// 1. 미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다.

			// 1-1. 각 칸을 돌면서 확산시키고 얼마를 받는지 확인한다.
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {

					if (arr[r][c][0] < 0)
						continue; // 공기청정기는 먼지 안나눈다.

					int tmp = arr[r][c][0] / 5; // 확산할 때의 값
					int cnt = 0; // 퍼뜨리는데 성공한 방향의 수

					if (tmp == 0)
						continue;

					for (int i = 0; i < 4; i++) {
						int rr = r + moveX[i];
						int cc = c + moveY[i];

						if (rr < 0 || rr >= R || cc < 0 || cc >= C || arr[rr][cc][0] < 0)
							continue;

						cnt++;
						arr[rr][cc][1] += tmp;
					}

					arr[r][c][0] -= tmp * cnt;
				}
			}

			// 1-2. 배열을 돌면서 받은걸 제대로 0칸으로 이동시킨다. + dust를 구한다.
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					arr[r][c][0] += arr[r][c][1]; // 받은거 이동시키기
					arr[r][c][1] = 0; // 초기화 시켜놔야 나중에 사용한다.
					if(arr[r][c][0] > 0) dust += arr[r][c][0]; // dust에 값 이동
				}
			}

			// 2. 공기청정기가 작동한다 -> 0칸과 1칸 둘 다 이동시켜야함
			// 2-1. 위에꺼 순환
			dust -= upperCirculation(arr, clean[0], R, C);
			// 2-2. 아래꺼 순환
			dust -= lowerCirculation(arr, clean[1], R, C);
		}

		System.out.println(dust);
	}

	private static int upperCirculation(int[][][] arr, int[] clean, int R, int C) {

		int nowX = clean[0];
		int nowY = clean[1];
		int last = 0; // 사실 nowY는 0일 수 밖에 없음

		// x 유지 y 증가
		for (nowY = 1; nowY < C - 1; nowY++) {
			int tmp = arr[nowX][nowY][0];
			arr[nowX][nowY][0] = last;
			last = tmp;
		}

		// y 유지 x 감소
		for (nowX = clean[0]; nowX > 0; nowX--) {
			int tmp = arr[nowX][nowY][0];
			arr[nowX][nowY][0] = last;
			last = tmp;
		}

		// x 유지 y 감소
		for (nowY = C - 1; nowY > 0; nowY--) {
			int tmp = arr[nowX][nowY][0];
			arr[nowX][nowY][0] = last;
			last = tmp;
		}

		// y 유지 x 증가
		for (nowX = 0; nowX < clean[0]; nowX++) { //여기 시작점을 1로 해서 틀렸었음
			int tmp = arr[nowX][nowY][0];
			arr[nowX][nowY][0] = last;
			last = tmp;
		}
		
		return last;
	}

	private static int lowerCirculation(int[][][] arr, int[] clean, int R, int C) {
		int nowX = clean[0];
		int nowY = clean[1];
		int last = 0; // 사실 nowY는 0일 수 밖에 없음

		// x 유지 y 증가
		for (nowY = 1; nowY < C - 1; nowY++) {
			int tmp = arr[nowX][nowY][0];
			arr[nowX][nowY][0] = last;
			last = tmp;
		}

		// y 유지 x 증가
		for (nowX = clean[0]; nowX < R - 1; nowX++) {
			int tmp = arr[nowX][nowY][0];
			arr[nowX][nowY][0] = last;
			last = tmp;
		}

		// x 유지 y 감소
		for (nowY = C - 1; nowY > 0; nowY--) {
			int tmp = arr[nowX][nowY][0];
			arr[nowX][nowY][0] = last;
			last = tmp;
		}

		// y 유지 x 감소
		for (nowX = R - 1; nowX > clean[0]; nowX--) {
			int tmp = arr[nowX][nowY][0];
			arr[nowX][nowY][0] = last;
			last = tmp;
		}
		
		return last;
	}

}

/*
6 6 10
100 100 100 100 100 100
100 100 100 100 100 100
-1 100 100 100 100 100
-1 100 100 100 100 100
0 0 0 0 0 0
0 0 0 0 0 0
 */
