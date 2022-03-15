package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj17136 {

	static int[][] arr = new int[10][10];
	static boolean pos = false;
	static int ret = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력 받기
		for(int i = 0; i < 10; i++) {
			String[] input = br.readLine().split(" ");
			for(int j = 0; j < 10; j++) arr[i][j] = Integer.parseInt(input[j]);
		}
		
		bt(new int[] {0,0,0,0,0});
		System.out.println(pos? ret: -1);
	}

	private static void bt(int[] cnts) {
		boolean isOne = false;
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(arr[i][j] == 0) continue;
				isOne = true;
				for(int size = 1; size <= 5; size++) {
					if(cnts[size - 1] == 5) continue;
					if(checkRange(i, j, size)) {
						setRange(i, j, size, 0);
						cnts[size - 1]++;
						bt(cnts);
						setRange(i, j, size, 1);
						cnts[size - 1]--;
					}
					
				}
				
				return;
			}
		}
		
		if(!isOne) {
			pos = true;
			int sum = cnts[0] + cnts[1] + cnts[2] + cnts[3] + cnts[4];
			ret = Math.min(sum, ret);
		}
	}

	private static void setRange(int i, int j, int size, int set) {
		for(int x = i; x < i + size; x++) {
			for(int y = j; y < j + size; y++) {
				arr[x][y] = set;
			}
		}
		
	}

	private static boolean checkRange(int i, int j, int size) {
		if(i + size - 1 >= 10 || j + size - 1 >= 10) return false;
		for(int x = i; x < i + size; x++) {
			for(int y = j; y < j + size; y++) {
				if(arr[x][y] == 0) return false;
			}
		}
		return true;
	}

}

/*
1 1 1 1 1 1 0 0 0 0 
1 1 1 1 1 1 0 0 0 0
1 1 1 1 1 1 0 0 0 0
1 1 1 1 1 1 0 0 0 0
1 1 1 1 1 1 0 0 0 0 
1 1 1 1 1 1 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
*/
