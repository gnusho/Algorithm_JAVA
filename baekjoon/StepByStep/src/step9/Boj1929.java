package step9;

import java.util.Scanner;

public class Boj1929 {
	static boolean[] num = new boolean[1000001];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		num[0] = true;
		num[1] = true;
		che();

		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(), N = sc.nextInt();

		for (int i = M; i <= N; i++) {
			if (num[i] == false) {
				System.out.println(i);
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
