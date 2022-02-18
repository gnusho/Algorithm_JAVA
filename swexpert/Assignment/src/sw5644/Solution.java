package sw5644;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

class Solution {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		int move_x[] = { 0, -1, 0, 1, 0 };
		int move_y[] = { 0, 0, 1, 0, -1 };

		for (int test_case = 1; test_case <= T; test_case++) {
			String[] input = br.readLine().split(" ");
			int M = Integer.parseInt(input[0]); // 총 이동 시간
			int A = Integer.parseInt(input[1]); // BC의 개수
			BC bcs[] = new BC[A];

			// 이동정보 입력
			int A_move[] = new int[M + 1]; // A의 이동 정보 -> M+1칸인건 0초일때를 처리하기 위함
			int B_move[] = new int[M + 1]; // B의 이동 정보-> M+1칸인건 0초일때를 처리하기 위함

			input = br.readLine().split(" ");
			for (int i = 1; i <= M; i++)
				A_move[i] = Integer.parseInt(input[i - 1]); // A의 이동정보 입력 받음
			input = br.readLine().split(" ");
			for (int i = 1; i <= M; i++)
				B_move[i] = Integer.parseInt(input[i - 1]); // B의 이동정보 입력 받음

			// BC의 정보 입력
			for (int i = 0; i < A; i++) {
				input = br.readLine().split(" ");
				int X = Integer.parseInt(input[1]) - 1;
				int Y = Integer.parseInt(input[0]) - 1;
				int C = Integer.parseInt(input[2]);
				int P = Integer.parseInt(input[3]);
				bcs[i] = new BC(new Point(X, Y), C, P);
			}

			Arrays.sort(bcs); // 내림차순 정렬

			int sum = 0;
			Point userA = new Point(0, 0); // A의 초기 위치
			Point userB = new Point(9, 9); // B의 초기 위치

			// 하나씩 옮겨가면서 구현
			boolean bc_check_A[] = new boolean[A]; // A가 갈 수 있는데 확인
			boolean bc_check_B[] = new boolean[A]; // B가 갈 수 있는데 확인

			for (int i = 0; i < M + 1; i++) {
				for (int j = 0; j < A; j++) {
					bc_check_A[j] = false;
					bc_check_B[j] = false;
				}

				// A와 B를 각각 이동 시킨 후 각각 BC와 거리를 비교해서 커버 범위 이내면 bc_check에 체크!
				// A와 B 이동
				userA.x += move_x[A_move[i]];
				userA.y += move_y[A_move[i]];
				userB.x += move_x[B_move[i]];
				userB.y += move_y[B_move[i]];

				// 알고리즘 구현
				for (int j = 0; j < A; j++) {
					if (bcs[j].point.getDist(userA) <= bcs[j].coverage) bc_check_A[j] = true;
					if (bcs[j].point.getDist(userB) <= bcs[j].coverage) bc_check_B[j] = true;
				}
				
				boolean A_check = false, B_check = false;
				int cnt = 0;
				for (int j = 0; j < A; j++) {
					if (!A_check && !B_check) {
						if (cnt == 0) {
							if (bc_check_A[j] && bc_check_B[j]) { // 최대값이 같은 경우
								sum += bcs[j].performance;
								cnt++; // 이 때는 해당 값이 A의 것인지 B의 것인지 모르므로 cnt를 통해서 제어한다.
							} else if (bc_check_A[j] && !bc_check_B[j]) { // A가 나온 경우
								sum += bcs[j].performance;
								A_check = true;
							} else if (!bc_check_A[j] && bc_check_B[j]) { // B가 나온 경우
								sum += bcs[j].performance;
								B_check = true;
							}
						} else {
							if(bc_check_A[j] || bc_check_B[j]) { // 최대값이 같았던 경우
								sum += bcs[j].performance; // 가장 먼저 나오는 값을 더해준다
								break;
							}
						}
					} else if (A_check && !B_check) { // 이전에 A의 값이 먼저 선택된 경우
						if(bc_check_B[j]) {
							sum += bcs[j].performance;
							break;
						}
					} else if (!A_check && B_check) { // 이전에 B의 값이 먼저 선택된 경우
						if(bc_check_A[j]) {
							sum += bcs[j].performance;
							break;
						}
					} else
						break;
				}

			}

			System.out.printf("#%d %d\n", test_case, sum);
		}
	}

	static class BC implements Comparable<BC> {
		Point point;
		int coverage;
		int performance;

		public BC(Point point, int C, int P) {
			this.point = point;
			this.coverage = C;
			this.performance = P;
		}

		@Override
		public int compareTo(BC o) {
			return o.performance - this.performance;
		}
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getDist(Point o) {
			return Math.abs(this.x - o.x) + Math.abs(this.y - o.y);
		}
	}
}
