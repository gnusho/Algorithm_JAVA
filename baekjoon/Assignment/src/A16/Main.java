package A16;

import java.util.Scanner;

public class Main {

	static int N, M, R, arr[][] = new int[101][101];
	static int tmpArr[][] = new int[101][101]; // 돌릴 때 하나씩 안하고 통째로 할 예정

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		while (R-- > 0) {
			int order = sc.nextInt();

			for (int i = 0; i < 101; i++) {
				for (int j = 0; j < 101; j++) {
					tmpArr[i][j] = 0;
				}
			}

			if (order == 1) {
				mirrorUpDown();
			} else if (order == 2) {
				mirrorLeftRight();
			} else if (order == 3) {
				rotateRight();
			} else if (order == 4) {
				rotateLeft();
			} else if (order == 5) {
				rotateQuarterRight();
			} else if (order == 6) {
				rotateQuarterLeft();
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void mirrorUpDown() {
		for (int i = 0; i < N / 2; i++) { // 5면 0,1만 보면 되니까 for 조건은 저게 적합 2는 안뒤집을거
			for (int j = 0; j < M; j++) {
				int tmp = arr[i][j];
				arr[i][j] = arr[N - i - 1][j];
				arr[N - i - 1][j] = tmp;
			}
		}
	}

	public static void mirrorLeftRight() {
		for (int i = 0; i < M / 2; i++) { // 5면 0,1만 보면 되니까 for 조건은 저게 적합 2는 안뒤집을거
			for (int j = 0; j < N; j++) {
				int tmp = arr[j][i];
				arr[j][i] = arr[j][M - i - 1];
				arr[j][M - i - 1] = tmp;
			}
		}
	}

	public static void rotateRight() {

		// 돌려서 해당되는 걸 tmpArr에 집어넣는다
		double mid_x = (1.0 * N - 1) / 2, mid_y = (1.0 * M - 1) / 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				double a = i - mid_x;
				double b = j - mid_y;
				// -90도 회전변환시엔, (a,b) -> (b,-a)
				tmpArr[(int) (mid_y + b)][(int) (mid_x - a)] = arr[i][j];
			}
		}

		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				arr[i][j] = tmpArr[i][j];
			}
		}

		// N,M swap
		int tmp = N;
		N = M;
		M = tmp;
	}

	public static void rotateLeft() {

		// 돌려서 해당되는 걸 tmpArr에 집어넣는다
		double mid_x = (1.0 * N - 1) / 2, mid_y = (1.0 * M - 1) / 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				double a = i - mid_x;
				double b = j - mid_y;
				// 90도 회전변환시엔, (a,b) -> (-b,a)
				tmpArr[(int) (mid_y - b)][(int) (mid_x + a)] = arr[i][j];
			}
		}

		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				arr[i][j] = tmpArr[i][j];
			}
		}

		// N,M swap
		int tmp = N;
		N = M;
		M = tmp;
	}

	public static void rotateQuarterRight() {

		// swap하면서 진행
		// 1 -> 2 - i값 유지 j값 변경
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				tmpArr[i][M / 2 + j] = arr[i][j];
			}
		}

		// 2 -> 3 - j값 유지 i값 변경
		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				tmpArr[N / 2 + i][j] = arr[i][j];
			}
		}

		// 3 -> 4 - i값 유지 j값 변경
		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				tmpArr[i][j - M / 2] = arr[i][j];
			}
		}

		// 4 -> 1 - j값 유지 i값 변경
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				tmpArr[i - N / 2][j] = arr[i][j];
			}
		}

		// tmpArr에서 arr로 copy
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				arr[i][j] = tmpArr[i][j];
			}
		}
	}

	public static void rotateQuarterLeft() {
		// swap하면서 진행
		// 1 -> 4
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				tmpArr[i + N / 2][j] = arr[i][j];
			}
		}

		// 4 -> 3
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				tmpArr[i][j + M / 2] = arr[i][j];
			}
		}

		// 3 -> 2
		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				tmpArr[i - N / 2][j] = arr[i][j];
			}
		}

		// 2 -> 1
		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				tmpArr[i][j - M / 2] = arr[i][j];
			}
		}

		// tmpArr에서 arr로 copy
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				arr[i][j] = tmpArr[i][j];
			}
		}
	}
}
