package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj13335 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 다리를 건너는 트럭의 수
		int W = sc.nextInt(); // 다리의 길이
		int L = sc.nextInt(); // 다리의 최대 하중
		
		Queue<Integer> wait = new LinkedList<Integer>();
		Queue<int[]> move = new LinkedList<int[]>();
		
		for(int i = 0; i < N; i++) wait.offer(sc.nextInt());
		
		int t = 0;
		int sum = 0; // 현재 move q에 있는 트럭들의 합
		
		while(!wait.isEmpty() || !move.isEmpty()) {
			t++;
			
			// 1 씩 더해주고
			int qSize = move.size();
			while(qSize-- > 0) {
				int[] now = move.poll();
				now[1]++;
				move.offer(now);
			}
			
			// move q 가장 위에꺼 조건 맞으면 내보내고
			if(!move.isEmpty() && move.peek()[1] > W) {
				sum -= move.peek()[0];
				move.remove();
			}
			
			// wait q 가장 위에꺼 조건 맞으면 들여보냄
			if(!wait.isEmpty() && sum + wait.peek() <= L) {
				int now = wait.poll();
				sum += now;
				move.offer(new int[] {now, 1});
			}
		}
		
		System.out.println(t);
	}

}
