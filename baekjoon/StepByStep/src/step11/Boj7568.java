package step11;

import java.util.Scanner;

public class Boj7568 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		Info[] infos = new Info[N];

		for (int i = 0; i < N; i++) {
			infos[i] = new Info();
			infos[i].x = sc.nextInt();
			infos[i].y = sc.nextInt();
		}

		for (Info info1 : infos) {
			int k = 0;
			for (Info info2 : infos) {
				if (info2.x > info1.x && info2.y > info1.y) {
					k++;
				}
			}
			System.out.print((k + 1) + " ");
		}
	}

	static class Info {
		int x = 0, y = 0;
	}

}
