package step3;

import java.io.IOException;
import java.util.Scanner;

public class Boj10871 {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), x = sc.nextInt();
		String answer = "";

		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			if (a < x)
				answer += a + " ";
		}

		System.out.print(answer);

	}
}
