package String;

import java.util.Scanner;

public class Boj2941 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		boolean[] check = new boolean[input.length()];

		if (input.length() < 1) {
			System.out.println(0);
			return;
		}

		int cnt = 0;
		for (int i = 0; i < input.length(); i++) {
			if (check[i] == true)
				continue;
			int tmp = input.charAt(i);

			if (tmp == 'c' && i + 1 < input.length()) {
				if (input.charAt(i + 1) == (int) '=') {
					check[i] = true;
					check[i + 1] = true;
					cnt++;
				} else if (input.charAt(i + 1) == (int) '-') {
					check[i] = true;
					check[i + 1] = true;
					cnt++;
				}
			}

			if (tmp == 'd' && i + 2 < input.length()) {
				if (input.charAt(i + 1) == (int) 'z' && input.charAt(i + 2) == (int) '=') {
					check[i] = true;
					check[i + 1] = true;
					check[i + 2] = true;
					cnt++;
					continue;
				}
			}

			if (tmp == 'd' && i + 1 < input.length()) {
				if (input.charAt(i + 1) == (int) '-') {
					check[i] = true;
					check[i + 1] = true;
					cnt++;
				}
			}

			if (tmp == 'l' && i + 1 < input.length()) {
				if (input.charAt(i + 1) == (int) 'j') {
					check[i] = true;
					check[i + 1] = true;
					cnt++;
				}
			}

			if (tmp == 'n' && i + 1 < input.length()) {
				if (input.charAt(i + 1) == (int) 'j') {
					check[i] = true;
					check[i + 1] = true;
					cnt++;
				}
			}

			if (tmp == 's' && i + 1 < input.length()) {
				if (input.charAt(i + 1) == (int) '=') {
					check[i] = true;
					check[i + 1] = true;
					cnt++;
				}
			}

			if (tmp == 'z' && i + 1 < input.length()) {
				if (input.charAt(i + 1) == (int) '=') {
					check[i] = true;
					check[i + 1] = true;
					cnt++;
				}
			}
		}

		for (int i = 0; i < check.length; i++) {
			if (check[i] == false)
				cnt++;
		}
		System.out.println(cnt);
	}
}
