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
				q.offer(sc.nextInt());
			}

			int minus = 1;
			while (true) {
				int tmp = q.poll();
				tmp -= minus++;
				minus = minus > 5? 1: minus;
				tmp = tmp > 0 ? tmp : 0;
				q.offer(tmp);

				if (tmp == 0)
					break;
			}

			System.out.print("#" + test_case);
			
			while(!q.isEmpty()) {
				System.out.print(" " + q.poll());
			}
			
			System.out.println();
		}
	}
}