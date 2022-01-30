package step10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Boj2447 {
	
	static int N;
	static char[][] stars;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		stars = new char[N][N];
		star(N/3, 0, 0, false);
		
		for(int i = 0; i < N ;i++) {
			String str = "";
			for(int j = 0 ; j < N; j++) {
				str += stars[i][j];
			}
			str+="\n";
			bw.write(str);
		}
		bw.flush();
	}

	public static void star(int N, int start_x, int start_y, boolean blank) {
		
		if(N == 0) {
			//System.out.println(start_x + "" + start_y + "" + blank);
			if(blank) stars[start_x][start_y] = ' ';
			else stars[start_x][start_y] = '*';
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				int x_tmp = start_x + i * N;
				int y_tmp = start_y + j * N;
				
				if(blank || i == 1 && j == 1) {
					star(N/3, x_tmp, y_tmp, true);
				}else {
					star(N/3, x_tmp, y_tmp, false);
				}
			}
		}
	}
}
