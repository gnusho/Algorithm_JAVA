package sw4012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static int MIN = 20000 * 16 * 2;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		int[][] arr;
		for (int test_case = 1; test_case <= T; test_case++) {
			min = MIN;
			int N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			int sum = 0;
			for (int i = 0; i < N; i++) {

				String[] input = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(input[j]);
					sum += arr[i][j];
				}
			}

			boolean check[] = new boolean[N];
			backTracking(arr, check, N, 0, 0);
			System.out.printf("#%d %d\n", test_case, min);
		}
	}

	private static void backTracking(int[][] arr, boolean[] check, int N, int now, int cnt) {
		if (now >= N || cnt > N / 2) {
			return;
		}
		if (cnt == N / 2) {
			int tmp1 = 0, tmp2 = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < i; j++) {
					if (check[i]&&check[j]) {
						tmp1 += arr[i][j] + arr[j][i];
					} else if(!check[i]&&!check[j]) {
						tmp2 += arr[i][j] + arr[j][i];
					}
				}

			}

			min = Math.min(min, Math.abs(tmp1 - tmp2));
			return;
		}

		check[now] = true;
		backTracking(arr, check, N, now + 1, cnt + 1);
		check[now] = false;
		backTracking(arr, check, N, now + 1, cnt);
	}

}
