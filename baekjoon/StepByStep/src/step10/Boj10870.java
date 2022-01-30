package step10;

import java.util.Scanner;

public class Boj10870 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		System.out.println(fibo(N));
	}

	public static int fibo(int N) {
		if (N == 0)
			return 0;
		if (N == 1)
			return 1;
		return fibo(N - 1) + fibo(N - 2);
	}
}
