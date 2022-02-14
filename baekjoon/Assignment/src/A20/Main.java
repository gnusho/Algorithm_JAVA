package A20;

import java.util.Scanner;

public class Main {

	static boolean check[];
	static int ingrediants[][];
	static int min = 1000000001;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		check = new boolean[N];
		ingrediants = new int[N][2];

		for (int i = 0; i < N; i++) {
			ingrediants[i][0] = sc.nextInt(); // 신맛 입력
			ingrediants[i][1] = sc.nextInt(); // 쓴맛 입력
		}

		dfs(0, 0, 1, 0);

		System.out.println(min);
	}

	public static void dfs(int now, int cnt, int sour, int bitter) { // 매번 for문 돌리기 싫어서 그냥 값을 계속 전달하기로 결정
		if (now == check.length) { // 부분집합으로 처리가 됬다면, 재귀를 멈춰야 함
			if (cnt != 0) { // 단, 없는건 안됨 사용한 재료가 있다면 계싼함
				int tmp = Math.abs(sour - bitter); // 차니까 절댓값으로 처리
				min = tmp < min ? tmp : min;
			}
			return;
		}
		check[now] = true; // 해당 재료를 사용했다고 하고 재귀 진행
		dfs(now + 1, cnt + 1, sour * ingrediants[now][0], bitter + ingrediants[now][1]);
		check[now] = false; // 원래대로 돌려놓기
		dfs(now + 1, cnt, sour, bitter);
	}
}