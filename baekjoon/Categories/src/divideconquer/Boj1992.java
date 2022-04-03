package divideconquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj1992 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		
		char[] input;
		for(int i = 0; i < N; i++) {
			input = br.readLine().toCharArray();
			for(int j = 0; j < N; j++) {
				arr[i][j] = input[j] - '0';
			}
		}
		StringBuilder sb = new StringBuilder();
		recur(arr, sb, N, 0, 0);
		
		System.out.println(sb.toString());
	}

	private static void recur(int[][] arr, StringBuilder sb, int size, int startX, int startY) {
		
		// 전체 확인
		for (int i = startX; i < startX + size; i++) {
			for (int j = startY; j < startY + size; j++) {
				if(arr[i][j] != arr[startX][startY]) {
					sb.append("(");
					recur(arr, sb, size/2, startX, startY);
					recur(arr, sb, size/2, startX, startY + size/2);
					recur(arr, sb, size/2, startX + size/2, startY);
					recur(arr, sb, size/2, startX + size/2, startY + size/2);
					sb.append(")");
					return;
				}
			}
		}
		
		// 같으면 숫자 뱉기
		sb.append(arr[startX][startY]);
	}

}
