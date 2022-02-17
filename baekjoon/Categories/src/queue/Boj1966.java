package queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Boj1966 {

	public static void main(String[] args) throws Exception{
		
		Queue<Docs> q = new LinkedList<Docs>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			
			q.clear();
			String input1[] = br.readLine().split(" ");
			int N = Integer.parseInt(input1[0]);
			int M = Integer.parseInt(input1[1]);
			
			String input2[] = br.readLine().split(" ");
			int check[] = new int[10];
			int K = -1;
			for(int i = 0; i < N; i++) {
				q.offer(new Docs(i, Integer.parseInt(input2[i])));
				check[Integer.parseInt(input2[i])]++;
				if(i == M) K = Integer.parseInt(input2[i]);
			}

			int cnt = 0;
			for(int i = 9; i > K; i--) {
				while(check[i] > 0) {
					while(true) {
						if(q.peek().priority == i) {
							q.remove();
							cnt++;
							break;
						}
						q.offer(q.poll());
					}
					check[i]--;
				}
			}
			
			while(true) {
				if(q.peek().priority == K) {
					if(q.peek().place == M) break;
					else {
						q.remove();
						cnt++;
					}
				}else {
					q.offer(q.poll());
				}
			}
			
			System.out.println(cnt + 1);
		}
	}

	static class Docs{
		int place;
		int priority;
		
		Docs(int place, int priority){
			this.place = place;
			this.priority = priority;
		}
	}
}
