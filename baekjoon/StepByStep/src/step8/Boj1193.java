package step8;

import java.util.Scanner;

public class Boj1193 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int sum = func(n);

		int ii = n - (sum) * (sum + 1) / 2;

		//System.out.println(sum + " " + ii);

		int type = sum % 2; // 1이면 분모가 1부터 시작, 0이면 분자가 1부터 시작
		int top = (type == 0) ? sum + 2 - ii : ii;
		System.out.printf("%d/%d\n", top, sum + 2 - top);

	}

	public static int func(int n) {
		int x = 0;
		while (true) {
			if (n > x * (x + 1) / 2 && n <= (x + 1) * (x + 2) / 2) {
				break;
			}
			x++;
		}
		return x;
	}

}

/*
 * 1 2 3 분자 4 5 6 분모 7 8 9 10
 */