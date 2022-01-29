package step9;

import java.util.Scanner;

public class Boj1085 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();

		int ans = x;
		ans = ans > y ? y : ans;
		ans = ans > w - x ? w - x : ans;
		ans = ans > h - y ? h - y : ans;
		System.out.println(ans);
	}

}
