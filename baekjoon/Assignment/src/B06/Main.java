package B06;

import java.util.Scanner;

public class Main {

	static int size = 10;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		boolean[][] bigPaper = new boolean[101][101];
		int cnt = 0;
		
		while(N-->0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					
					int xx = x + i;
					int yy = y + j;
					if(bigPaper[xx][yy]) continue; // true면 이미 색칠한거니까 또 색칠하지 않음
					bigPaper[xx][yy] = true;
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
