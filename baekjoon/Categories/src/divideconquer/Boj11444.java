package divideconquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj11444 {

	static final long divider = 1000000007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long input = Long.parseLong(br.readLine());

		long[][] matrix = { { 1, 1 }, { 1, 0 } };
		long[][] ms = dvMatrix(matrix, input);
		
		System.out.println(ms[1][0] % divider);

	}

	public static long[][] dvMatrix(long[][] matrix, Long B) {
		if (B == 1) {
			return matrix;
		}

		long[][] tmp = dvMatrix(matrix, B / 2);
		long[][] ret = squareMatrix(tmp, tmp);
		if (B % 2 == 0) {
			return ret;
		} else {
			return squareMatrix(ret, matrix);
		}
	}

	public static long[][] squareMatrix(long[][] m1, long[][] m2) {
		int N = 2;

		long[][] ret = new long[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					ret[i][j] += (m1[i][k] * m2[k][j]) % divider;
				}
				ret[i][j] %= divider;
			}
		}

		return ret;
	}

}
