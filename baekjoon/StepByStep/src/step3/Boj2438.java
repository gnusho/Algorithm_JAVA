package step3;

import java.io.IOException;
import java.util.Scanner;

public class Boj2438 {
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			String tmp = "";
			for (int j = 0; j < i; j++)
				tmp += "*";
			System.out.println(tmp);
		}

	}
}
