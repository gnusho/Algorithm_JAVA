package queue;

import java.io.*;
import java.util.*;

public class Boj1021 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		Queue<Integer> q = new LinkedList<>();
		
		input = br.readLine().split(" ");
		
		for(int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		int ret = 0;
		
		for(int i = 0; i < input.length; i++) {
			
			int tmp = Integer.parseInt(input[i]);
			int cnt = 0;
			
			while(q.peek() != tmp) {
				q.offer(q.poll());
				cnt++;
			}
			
			ret += Math.min(cnt, q.size() - cnt);
			
			q.remove();
		}
		
		System.out.println(ret);
	}

}
