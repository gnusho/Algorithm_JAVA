package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Boj2644 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean check[] = new boolean[N];
		ArrayList<ArrayList<Integer>> adjArr = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < N; i++) adjArr.add(new ArrayList<Integer>());
		
		String[] input = br.readLine().split(" ");
		int X = Integer.parseInt(input[0]) - 1;
		int Y = Integer.parseInt(input[1]) - 1;
		
		int M = Integer.parseInt(br.readLine());
		while(M-- > 0) {
			input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]) - 1;
			int y = Integer.parseInt(input[1]) - 1;
			
			adjArr.get(x).add(y);
			adjArr.get(y).add(x);
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(X);
		check[X] = true;
		
		int level = 0;
		
		boolean find = false;
		
		while(!q.isEmpty()) {
			
			int size = q.size();
			level++;
			for(int i = 0; i < size; i++) {
				int now = q.poll();
				for (int j = 0; j < adjArr.get(now).size(); j++) {
					int tmp = adjArr.get(now).get(j);
					if(tmp == Y) {
						find = true;
						break;
					}
					if(!check[tmp]) {
						q.offer(tmp);
						check[tmp] = true;
					}
				}
				
				if(find) break;
			}
			
			if(find) break;
		}
		
		System.out.println(find? level:-1);
	}

}
