package step10;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Boj11729 {
	
	static int cnt = 0;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void hanoi(int N, int from, int temp, int to) throws IOException {
		
		if(N == 1) {
			cnt++;
			bw.write(from + " " + to + "\n");
			return;
		}
		
		hanoi(N-1, from, to, temp);
		hanoi(1, from, temp, to);
		hanoi(N-1, temp, from, to);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println((int)Math.pow(2, N) - 1);
		hanoi(N,1,2,3);
		bw.flush();
	}

}
