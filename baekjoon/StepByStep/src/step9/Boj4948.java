package step9;

import java.util.Scanner;

public class Boj4948 {

	static boolean[] num = new boolean[300000];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		num[0] = true;
		num[1] = true;
		che();

		Scanner sc = new Scanner(System.in);
		int n;
		while ((n = sc.nextInt()) != 0) {
			int cnt = 0;
			for (int i = n + 1; i <= 2 * n; i++) {
				if (num[i] == false)
					cnt++;
			}
			System.out.println(cnt);
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
