package queue;

import java.io.*;
import java.util.*;

public class Boj2164 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Queue<Integer> q = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) q.offer(i + 1);
		
		while(q.size() > 1) {
			q.remove();
			q.offer(q.poll());
		}
		System.out.println(q.peek());
	}

}
