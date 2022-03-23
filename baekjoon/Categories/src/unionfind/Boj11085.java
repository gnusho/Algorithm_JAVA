package unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Boj11085 {

	static int[] arr;
	
	public static int find(int a) {
		if(arr[a] == a) return a;
		else return find(arr[a]);
	}
	
	public static void merge(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a > b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		if(a==b) return;
		arr[b] = a;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int P = Integer.parseInt(input[0]);
		int W = Integer.parseInt(input[1]);
		arr = new int[P];
		for(int i = 0; i < P; i++) arr[i] = i;
		
		input = br.readLine().split(" ");
		int C = Integer.parseInt(input[0]);
		int V = Integer.parseInt(input[1]);

		ArrayList<int[]> list = new ArrayList<>();
		
		while(W-- > 0) {
			input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			int val = Integer.parseInt(input[2]);
			
			list.add(new int[] {val, x, y});
		}
		
		Collections.sort(list, (int[] o1 ,int[] o2) -> {
			return o2[0] - o1[0];
		});
		
		for(int[] now: list) {
			//System.out.println(now[0]);
			int x = now[1];
			int y = now[2];
			
			merge(x,y);
			
			if(find(C) == find(V)) {
				System.out.println(now[0]);
				return;
			}
		}
	}

}
