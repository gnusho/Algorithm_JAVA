package divideconquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj10830 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		Long B = Long.parseLong(input[1]);
		
		int[][] matrix = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			input = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		int[][] ans = dvMatrix(matrix, B);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print((ans[i][j] % 1000) + " ");
			}
			System.out.println();
		}
	}

	public static int[][] dvMatrix(int[][] matrix, Long B){
		if(B == 1) {
			return matrix;
		}
		
		int[][] tmp = dvMatrix(matrix, B/2);
		int[][] ret = square(tmp, tmp);
		if(B%2 == 0) {
			return ret;
		} else {
			return square(ret, matrix);
		}
	}
	
	public static int[][] square(int[][] m1, int[][] m2){
		int N = m1.length;
		
		int[][] ret = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					ret[i][j] += (m1[i][k] * m2[k][j])%1000;
				}
				ret[i][j] %= 1000;
			}
		}
		
		return ret;
	}
}
