package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj17136 {

	static int[][] arr = new int[10][10];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 10; i++) {
			String[] input = br.readLine().split(" ");
			for(int j = 0; j < 10; j++) arr[i][j] = Integer.parseInt(input[j]);
		}
		
		int cnt = 0;
		
		for(int i = 5; i > 0; i--) {
			cnt += count(i);
		}
		
		boolean pos = true;
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(arr[i][j] == 1) pos = false;
			}
		}
		
		System.out.println(pos? cnt: -1);
	}

	private static int count(int size) {
		int ret = 0;
		for(int i = 0; i < 11 - size; i++) {
			for(int j = 0; j < 11 - size; j++) {
	
				boolean pos = true;
				for(int x = 0; x <size; x++) {
					for(int y = 0; y < size; y++) {
						if(arr[i + x][j + y] == 0) pos = false;
					}
				}
				
				if(pos) {
					ret++;
					for(int x = 0; x <size; x++) {
						for(int y = 0; y < size; y++) {
							arr[i + x][j + y] = 0;
						}
					}
				}
			}
			
			if(ret == 5) break;
		}
		return ret;
	}

}
