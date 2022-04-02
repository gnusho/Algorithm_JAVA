package divideconquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj2630 {

	static int color[] = new int[2];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		
		String[] input;
		for(int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		}
		recur(arr, N, 0, 0);
		System.out.println(color[0]);
		System.out.println(color[1]);
	}

	private static void recur(int[][] arr, int size, int startX, int startY) {
		
		boolean flag = true;
		// 전체 숫자 검사
		for(int i = startX; i < startX + size; i++) {
			for(int j = startY; j < startY + size; j++) {
				if(arr[i][j] != arr[startX][startY]) {
					flag = false;
					break;
				}
			}
			if(!flag) break;
		}
		// 같으면 1 return
		if(flag) {
			color[arr[startX][startY]]++;
		}
		
		// 다르면 4등분해서 값 구한거 return
		else {
			recur(arr, size/2, startX, startY);
			recur(arr, size/2, startX + size/2, startY);
			recur(arr, size/2, startX, startY + size/2);
			recur(arr, size/2, startX + size/2, startY + size/2);
		}
	}

}
