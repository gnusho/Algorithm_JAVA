package greedy;

import java.util.Scanner;

public class Boj1969 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		String[] dnas = new String[N];
		int[][] cnts = new int[M][4];
		
		//ATGC
		for(int i = 0; i < N; i++) {
			dnas[i] = sc.next();
			
			for(int j = 0 ; j < M ; j++) {
				char tmp = dnas[i].charAt(j);
				if(tmp == 'A') cnts[j][0]++;
				else if(tmp == 'C') cnts[j][1]++;
				else if(tmp == 'G') cnts[j][2]++;
				else if(tmp == 'T') cnts[j][3]++;
			}
		}
		
		int cnt = 0;
		StringBuilder ans = new StringBuilder();
		
		for(int j = 0 ; j < M ; j++) {
			int index = 0;
			for(int l = 0; l < 4; l++) index = (cnts[j][l] > cnts[j][index])? l:index;
			cnt += N - cnts[j][index];
			if(index == 0)ans.append("A");
			else if(index == 1)ans.append("C");
			else if(index == 2)ans.append("G");
			else if(index == 3)ans.append("T");
		}
		
		System.out.printf("%s\n%d\n", ans, cnt);
	}

}
