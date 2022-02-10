package A13;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1; i <= N; i++) q.offer(i);
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		while(!q.isEmpty()) {
			int tmp = 0;
			for(int i = 0; i < K; i++) {
				tmp = q.poll();
				if(i != K-1) q.offer(tmp);
			}
			
			sb.append(tmp + ", ");
		}
		sb.delete(sb.length() - 2, sb.length());
		sb.append(">");
		
		System.out.println(sb.toString());
	}

}
