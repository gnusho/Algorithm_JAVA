package step10;

import java.util.Scanner;

public class Boj10872 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		
		System.out.println(fibo(N));
	}
	
	public static long fibo(long N) {
		if(N == 0) return 1;
		return N * fibo(N-1);
	}

}
