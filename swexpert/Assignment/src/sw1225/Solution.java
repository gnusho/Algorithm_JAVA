package sw1225;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = 10;
		Queue<Integer> q = new LinkedList<Integer>();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();

			for (int i = 0; i < 8; i++) {
				q.offer(sc.nextInt()); // 입력받는 즉시 q에 넣어줌
			}

			int minus = 1; // 빼주는 값
			while (true) {
				int tmp = q.poll();
				tmp -= minus++;
				minus = minus > 5? 1: minus; // 1부터 5까지가 한싸이클이므로 6이상이 되지 않도록 검사해주고 1로 초기화
				tmp = tmp > 0 ? tmp : 0; // 0 밑으로 내려가지 않게 검사
				q.offer(tmp);

				if (tmp == 0) // 맨 뒤에 꺼가 0이면 멈추기
					break;
			}

			System.out.print("#" + test_case);
			
			while(!q.isEmpty()) {
				System.out.print(" " + q.poll()); // 매번 poll을 통해서 q를 비우므로 다른 초기화는 필요없다
			}
			
			System.out.println();
		}
	}
}