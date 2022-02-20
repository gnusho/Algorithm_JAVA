package queue;

import java.util.*;
import java.io.*;

public class Boj2346 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] input = br.readLine().split(" ");
		
		int[] num = new int[N];
		boolean[] check = new boolean[N];
		int cnt = 0;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i < N; i++) {
			num[i] = Integer.parseInt(input[i]);
		}
		
		sb.append("1 ");
		check[0] = true;
		int now = 0;
		
		while(cnt < N - 1) {
			
			int tmp = num[now];
			int count = 0;
			if(tmp > 0) {
				while(tmp > 0) {
					now++;
					now = now >= N? 0: now;
					if(!check[now]) {
						tmp--;
					}
					if(count > 10) break;
				}
			} else if(tmp < 0) {
				while(tmp < 0) {
					now--;
					now = now < 0? N - 1: now;
					if(!check[now]) {
						tmp++;
					}
				}
			}
			
			check[now] = true;
			cnt++;
			sb.append(now + 1).append(" ");
		}
		
		//for(int i = 0; i < N; i++) sb.append(!check[i]? i + 1: "");
		
		System.out.println(sb.toString());
	}

}
