package B09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static String arr[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new String[N];
		
		for(int i = 0; i < N; i++) arr[i] = br.readLine();
		divideAndConquer(0, 0, N);
		System.out.println(sb.toString());
		
	}

	public static void divideAndConquer(int x, int y, int size) {
		
		// 다 똑같은지 확인
		boolean flag = true;
		char tmp = arr[x].charAt(y);
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(tmp == arr[i].charAt(j)) continue;
				flag = false;
				break;
			}
		}
		
		if(flag) {
			sb.append(tmp);
			return;
		}
		
		// 안 똑같으면 4등분 해서 재귀를 돌릴 겁니다.
		sb.append('(');
		divideAndConquer(x, y, size / 2);
		divideAndConquer(x, y + size / 2, size / 2);
		divideAndConquer(x + size / 2, y, size / 2);
		divideAndConquer(x + size / 2, y + size / 2, size / 2);
		sb.append(')');
		
	}
}
