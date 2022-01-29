package step8;

import java.io.*;
import java.util.*;

public class Boj2775 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		int[][] B = new int[15][15];
		
		for(int i = 1; i < 15; i++) B[0][i] = i*(i+1)/2;
		
		for(int i = 1; i < 15; i++) {
			for(int j = 1; j < 15; j++) {
				B[i][j] = B[i-1][j] + B[i][j-1];
			}
		}
		
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			System.out.println(B[K][N] - B[K][N-1]);
		}
	}

}
