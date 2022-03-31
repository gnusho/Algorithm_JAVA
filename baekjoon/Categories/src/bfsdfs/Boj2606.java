package bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Boj2606 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		boolean[] check = new boolean[N];
		ArrayList<ArrayList<Integer>> adjArr = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < N ; i++) adjArr.add(new ArrayList<Integer>());
		
		String[] input;
		while(M-- > 0) {
			input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]) - 1;
			int y = Integer.parseInt(input[1]) - 1;
			adjArr.get(x).add(y);
			adjArr.get(y).add(x); // 양방향 간선 확인안해서 틀림
		}
		
		int cnt = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		check[0] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i = 0; i < adjArr.get(now).size(); i++) {
				int tmp = adjArr.get(now).get(i);
				if(!check[tmp]) {
					//System.out.println(tmp);
					q.add(tmp);
					check[tmp] = true;
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
