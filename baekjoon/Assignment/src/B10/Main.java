package B10;

import java.util.Scanner;

public class Main {

	static int max = -1;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int arr[][] = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String input = sc.next();
			for(int j = 0; j < M; j++) arr[i][j] = input.charAt(j);
		}
		
		boolean check[] = new boolean[26];
		
		check[arr[0][0] - 'A'] = true;
		backTracking(0, 0, check, arr, 1, N, M);
		
		System.out.println(max);
	}
	
	public static void backTracking(int x, int y, boolean[] check, int[][]arr, int count, int N, int M) {

		max = Math.max(max, count);
		
		int[] move_x = {-1, 1, 0, 0};
		int[] move_y = {0, 0, -1, 1};
		
		boolean flag = false;
		
		for(int i = 0; i < move_x.length; i++) {
			
			int xx = x + move_x[i];
			int yy = y + move_y[i];
			
			if(xx < 0 || xx >= N || yy < 0 || yy >= M || check[arr[xx][yy] - 'A']) continue;
			
			check[arr[xx][yy] - 'A'] = true;
			backTracking(xx, yy, check, arr, count + 1, N, M);
			check[arr[xx][yy] - 'A'] = false;
		}
		
	}

}
