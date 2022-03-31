package bfsdfs;

import java.util.LinkedList;
import java.util.Queue;

public class MyExample1 {

	public static void main(String[] args) {
		
		final int MAX = 20; // 답의 범위
		int ret = -1;
		int move[] = {-1, 1};
		int input[] = {0, 5, 15, 20}; // ABCD의 좌표
		boolean check[] = new boolean[MAX + 1];
		
		Queue<T> q = new LinkedList<T>();
		
		for(int x: input) { // 2. 점 ABCD에 대해서 각 점의 좌표값을 index로 하고 depth를 0으로 가지는 T를 만들어서 Queue에 집어넣는다
			q.offer(new T(x, 0));
			check[x] = true;
		}
		
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) { // 3. Queue가 Empty가 될때까지 다음을 반복한다
			T now = q.poll();
			sb.append(now.index).append(" ");
			ret = Math.max(ret, now.depth); // 3.a  next = now.index + 1 or now.index - 1
			for(int i = 0; i < 2; i++) {
				int next = now.index + move[i];
				if(next >= 0 && next <= MAX && !check[next]) { // 범위 확인 + 방문했는지 확인
					q.offer(new T(next, now.depth + 1)); // 3.b Queue.offer(new T(next, now.depth + 1))
					check[next] = true;
				}
			}
		}
		
		System.out.println(ret);
		System.out.println(sb.toString()); // q에 어떤 순서대로 들어갔는지 확인하는 코드
	}

	static class T{ // 1. class T를 만든다 class T는 index와 depth를 멤버 변수로 가진다.
		int index, depth;
		
		T(int index, int depth){
			this.index = index;
			this.depth = depth;
		}
	}
}
