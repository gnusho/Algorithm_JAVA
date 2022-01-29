package step4;

import java.util.Scanner;

public class Boj1110 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0, x = n;

		while (true) {
			x = (x % 10) * 10 + (x % 10 + x / 10) % 10;
			ans++;
			if (n == x)
				break;
		}

		System.out.println(ans);

	}
}
