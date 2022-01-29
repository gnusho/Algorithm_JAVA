package step9;

import java.util.Scanner;

public class Boj9020 {
	static boolean[] num = new boolean[10001];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		num[0] = true;
		num[1] = true;
		che();

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N;
		
		while(T-->0) {
			N = sc.nextInt();
			
			for(int i = N/2; i >= 2; i--) {
				if(!num[i]&&!num[N-i]) {
					System.out.printf("%d %d\n", i, N-i);
					break;
				}
			}
		}

	}

	public static void che() {
		for (int i = 2; i < num.length; i++) {
			if (num[i] == true)
				continue;

			for (int j = i * 2; j < num.length; j += i) {
				num[j] = true;
			}
		}
	}
}
