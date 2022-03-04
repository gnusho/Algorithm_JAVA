package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Boj11725 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] parents = new int[N];
		boolean[] check = new boolean[N];
		ArrayList<ArrayList<Integer>> adjArr = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < N; i++) adjArr.add(new ArrayList<Integer>());
		
		String[] input;
		for(int i = 0; i < N - 1; i++) {
			input = br.readLine().split(" ");
			int X = Integer.parseInt(input[0]) - 1;
			int Y = Integer.parseInt(input[1]) - 1;
			
			adjArr.get(X).add(Y);
			adjArr.get(Y).add(X);
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(0);
		check[0] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i = 0; i < adjArr.get(now).size(); i++) {
				int tmp = adjArr.get(now).get(i);
				if(!check[tmp]) {
					parents[tmp] = now;
					check[tmp] = true;
					q.add(tmp);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N; i++) {
			sb.append(parents[i] + 1).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
