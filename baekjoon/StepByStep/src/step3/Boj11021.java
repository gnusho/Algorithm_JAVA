package step3;

import java.io.IOException;
import java.util.Scanner;

public class Boj11021 {
	public static void main(String[] args) throws IOException {

		// boj_11021
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 1; i <= t; i++) {

			int a = sc.nextInt(), b = sc.nextInt();
			System.out.printf("Case #%d: %d\n", i, a + b);
		}

	}
}
