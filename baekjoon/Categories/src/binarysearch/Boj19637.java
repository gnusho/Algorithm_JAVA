package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Boj19637 {
	
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		List<Title> list = new ArrayList<Title>();
		
		for(int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			int x = Integer.parseInt(input[1]);
			list.add(new Title(input[0], x));
		}
		
		Collections.sort(list, (Title t1, Title t2) -> {
			return t1.value - t2.value;
		});
		
		for(int i = 0; i < M; i++) {
			int x = Integer.parseInt(br.readLine());
			sb.append(list.get(lowerBound(list, x)).name).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static class Title{
		String name;
		int value;
		Title(String name, int value){
			this.name = name;
			this.value = value;
		}
	}
	
	public static int lowerBound(List<Title> list, int target) {
		int start = 0, end = list.size() - 1, mid;
		while(end > start) {
			mid = (start + end)/2;
			if(list.get(mid).value >= target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return end;
	}

}
