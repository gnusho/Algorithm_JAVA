package String;

import java.util.Scanner;

public class Boj1120 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a = sc.next(), b = sc.next();

		if (a.length() > b.length()) {
			String tmp = a;
			a = b;
			b = tmp;
		}

		int min = b.length();
		for (int i = 0; i < b.length() - a.length() + 1; i++) {
			int cnt = 0;
			for (int j = 0; j < a.length(); j++) {
				if (a.charAt(j) != b.charAt(i + j))
					cnt++;
			}
			min = min > cnt ? cnt : min;
		}

		System.out.println(min);
	}

}
