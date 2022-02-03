package bruteforce;

import java.util.Scanner;

public class Boj1018 {
	static int N, M;
	static String[] chess = new String[N];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		chess = new String[N];

		for (int i = 0; i < N; i++) {
			chess[i] = sc.next();
		}

		int min = 65;
		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				int tmp = check(i,j);
				min = min>tmp? tmp:min;
			}
		}

		System.out.println(min);
	}

	public static int check(int x, int y) {
		// 흑백
		int tmp1 = 0;
		for (int i = x; i < x+8; i++) {
			for (int j = y; j < y+8; j++) {
				if ((i + j) % 2 == 0 && chess[i].charAt(j) == 'W')
					tmp1++;
				else if ((i + j) % 2 == 1 && chess[i].charAt(j) == 'B')
					tmp1++;
			}
		}

		// 백흑
		int tmp2 = 0;
		for (int i = x; i < x+8; i++) {
			for (int j = y; j < y+8; j++) {
				if ((i + j) % 2 == 1 && chess[i].charAt(j) == 'W')
					tmp2++;
				else if ((i + j) % 2 == 0 && chess[i].charAt(j) == 'B')
					tmp2++;
			}
		}
		
		return tmp1<tmp2? tmp1:tmp2;
	}
}