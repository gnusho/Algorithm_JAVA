package step10;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Boj11729 {
	
	static int N;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		System.out.println((int)Math.pow(2, N) - 1);
		hanoi(1,2,3,N);
		bw.flush();
	}

	public static void hanoi(int a, int b, int c, int N) throws IOException {
		if(N == 1) {
			bw.write(a + " " + c + "\n");
		}
		else {
			hanoi(a, c, b, N-1);
			bw.write(a + " " + c + "\n");
			hanoi(b, a, c, N-1);
		}
	}
}
