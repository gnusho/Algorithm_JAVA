package bfsdfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj5014 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int F = Integer.parseInt(input[0]); // 전체 층수
		int S = Integer.parseInt(input[1]) - 1; // 현재 층
		int G = Integer.parseInt(input[2]) - 1; // 목적 층
		int U = Integer.parseInt(input[3]); // 위로 올라가는 층
		int D = Integer.parseInt(input[4]); // 아래로 내려가는 층
		
		int[] move = {U, -D};
		
		boolean[] check = new boolean[F];
		
		boolean find = false;
		int level = 0;
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(S);
		check[S] = true;
		
		if(S == G) {
			System.out.println(0);
			return;
		}
		
		while(!q.isEmpty()) {
			
			int size = q.size();
			level++;
			for(int i = 0; i < size; i++) {
				int now = q.poll();
				
				for(int j = 0; j < 2; j++) {
					int tmp = now + move[j];
					if(tmp < 0 || tmp >= F || check[tmp]) continue;
					if(tmp == G) {
						find = true;
						break;
					}
					
					q.offer(tmp);
					check[tmp] = true;
				}
				
				if(find) break;
			}
			if(find) break;
		}
		
		if(find) System.out.println(level);
		else System.out.println("use the stairs");
	}

}
