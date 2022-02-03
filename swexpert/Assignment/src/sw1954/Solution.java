package sw1954;

import java.util.Scanner;

public class Solution {

	static int cnt = 1;
	static int[][] arr = new int[10][10];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			
			cnt = 1;
			int n = sc.nextInt();
			snail(n, 0, 0);
			System.out.println("#" + test_case);
			for(int i = 0; i < n;i++) {
				for(int j=0;j<n;j++) {
					System.out.printf("%d ", arr[i][j]);
				}
				System.out.println();
			}
		}
	}
	
	public static void snail(int n, int start_x, int start_y) {
		
		if(n < 1) {
			return;
		}else if(n == 1) {
			arr[start_x][start_y] = cnt;
			return;
		}
		
		int x = start_x, y = start_y;
		
		// y쪽으로 먼저 +1
		for(y = start_y; y < start_y + n - 1; y++) {
			arr[x][y] = cnt++;
		}
		
		// x쪽으로 +1
		for(x = start_x; x < start_x + n - 1; x++) {
			arr[x][y] = cnt++;
		}
		
		// y쪽으로 -1
		for(y = start_y + n - 1; y > start_y; y--) {
			arr[x][y] = cnt++;
		}
		
		// x쪽으로 -1
		for(x = start_x + n - 1; x > start_x; x--) {
			arr[x][y] = cnt++;
		}
		
		snail(n-2, start_x + 1, start_y + 1);
	}

}
