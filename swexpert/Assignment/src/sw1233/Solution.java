package sw1233;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

	static int[] bst = new int[201];

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			for(int i = 0; i < bst.length; i++) bst[i] = -1; // 값 초기화 -1이면 없는 것
			
			for(int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String whyInput = st.nextToken(); // 번호를 왜 주는 걸까요...
				bst[i] = st.nextToken().charAt(0); // queue를 integer로 다루고자...
			}

			System.out.printf("#%d %d\n", test_case, bfs(N));
		}
	}
	
	public static int bfs(int N) { // 범위 확인해야되니까 + 사실 짝수면 될리가 없다
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			int tmp = bst[now];
			if(tmp >= '0' && tmp <= '9') {
				// tmp가 숫자면 child가 없어야 함
				if(now * 2 <= N && bst[now * 2] != -1) return 0;
				if(now * 2 + 1 <= N && bst[now * 2 + 1] != -1) return 0;
			} else {
				// tmp가 연산자면 child가 둘 다 있어야 함
				if(now * 2 > N || bst[now * 2] == -1) return 0;
				if(now * 2 + 1 > N || bst[now * 2 + 1] == -1) return 0;
				q.offer(now * 2);
				q.offer(now * 2 + 1);
			}

		}
		
		return 1;
	}
}

/*
9
1 *
2 +
3 -
4 /
5 2
6 6
7 4
8 8
9 7
*/